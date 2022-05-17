package com.monyert.studentswork3.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.monyert.studentswork3.R;



public class InfoTendesActivity extends AppCompatActivity {

    TextView nom,carrer,telefon;
    ImageView foto_tenda;
    String url;

    TextView ofertaTenda;
    FirebaseDatabase database;
    DatabaseReference dbTendaRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tendes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        nom = findViewById(R.id.nom_tenda);
        carrer = findViewById(R.id.nom_carrer);
        telefon = findViewById(R.id.telefon);
        foto_tenda = findViewById(R.id.image_tenda);

        nom.setText(getIntent().getExtras().getString("Tenda"));
        carrer.setText(getIntent().getExtras().getString("Carrer"));
        telefon.setText(getIntent().getExtras().getString("telefon"));
        url = getIntent().getExtras().getString("url");

        ofertaTenda = findViewById(R.id.ofertes);
        database = FirebaseDatabase.getInstance();
        //dbTendaRef = database.getReference("m0");

        if(url.equals("dulasoft.jpg")){
            foto_tenda.setImageResource(R.drawable.dulasoft);
            dbTendaRef = database.getReference("m0");
        }
        if(url.equals("apptavernes.jpg")){
            foto_tenda.setImageResource(R.drawable.apptavernes);
            dbTendaRef = database.getReference("m1");
        }
        if(url.equals("pcboxgandia.jpg")){
            foto_tenda.setImageResource(R.drawable.pcboxgandia);
            dbTendaRef = database.getReference("m2");
        }
        if(url.equals("maingandia.jpg")){
            foto_tenda.setImageResource(R.drawable.maingandia);
            dbTendaRef = database.getReference("m3");
        }
        if(url.equals("inboxalz.jpg")){
            foto_tenda.setImageResource(R.drawable.inboxalz);
            dbTendaRef = database.getReference("m4");
        }
        if(url.equals("maxpcalz.jpg")){
            foto_tenda.setImageResource(R.drawable.maxpcalz);
            dbTendaRef = database.getReference("m5");
        }
        if(url.equals("ewopcar.jpg")){
            foto_tenda.setImageResource(R.drawable.ewopcar);
            dbTendaRef = database.getReference("m6");
        }
        if(url.equals("vicocar.jpg")){
            foto_tenda.setImageResource(R.drawable.vicocar);
            dbTendaRef = database.getReference("m7");
        }
        if(url.equals("totcull.jpg")){
            foto_tenda.setImageResource(R.drawable.totcull);
            dbTendaRef = database.getReference("m8");
        }
        if(url.equals("appcull.png")){
            foto_tenda.setImageResource(R.drawable.appcull);
            dbTendaRef = database.getReference("m9");
        }

        dbTendaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                ofertaTenda.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

    }

    public void CridarALaTenda(View view) {
        Intent cridar = new Intent(Intent.ACTION_DIAL);
        cridar.setData(Uri.parse("tel:"+telefon.getText().toString().trim()));
        startActivity(cridar);
    }
}
