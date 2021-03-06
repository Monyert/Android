package com.monyert.studentswork4;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {
    private static SoundPool soundPool;
    private static int hitsound;
    private static int oversound;
    private static int wallsound;

    public SoundPlayer(Context context){
        soundPool = new SoundPool(2,AudioManager.STREAM_MUSIC,0);
        hitsound = soundPool.load(context,R.raw.beep1,1);
        oversound = soundPool.load(context,R.raw.explode,1);
        wallsound = soundPool.load(context,R.raw.beep2,1);
    }

    public void playHitSound(){
        soundPool.play(hitsound,1.0f,1.0f,1,0,1.0f);
    }

    public void playOverSound(){
        soundPool.play(oversound,1.0f,1.0f,1,0,1.0f);
    }

    public void playWallSound(){
        soundPool.play(wallsound,1.0f,1.0f,1,0,1.0f);
    }
}

