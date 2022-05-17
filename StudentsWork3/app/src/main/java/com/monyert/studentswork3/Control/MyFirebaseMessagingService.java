package com.monyert.studentswork3.Control;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.monyert.studentswork3.R;
import com.monyert.studentswork3.View.MainActivity;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("msg", "Message data payload: " + remoteMessage.getData());
        }
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            createNotification(remoteMessage.getNotification().getBody());
        }
    }
    private void createNotification(String message) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // The pending intent to be runned after receiving the message
        PendingIntent resultIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Only show notificactions from the News channel?
        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder(this, "Chanel1")
                .setSmallIcon(R.mipmap.ic_launcher) .setContentTitle("Notifications from My Tendes")
                .setContentText(message) .setAutoCancel(true)
                .setSound(notificationSoundURI) .setContentIntent(resultIntent) ;

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mNotificationBuilder.build());
    }
}