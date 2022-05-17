package com.monyert.studentswork3.View;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.monyert.studentswork3.Model.Poblacio;
import com.monyert.studentswork3.Control.PoblacionsDAO;
import com.monyert.studentswork3.Model.Tenda;
import com.monyert.studentswork3.Control.TendesDAO;
import com.monyert.studentswork3.R;

import java.util.ArrayList;

public class TendesActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ArrayList<Tenda> tendes;
    private ArrayList<Poblacio> poblacions;
    private Tenda tenda;

    private LatLng latLng;
    private TendesDAO myTendesDAO;
    private PoblacionsDAO myPoblacionsDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendes);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myPoblacionsDAO = new PoblacionsDAO(this);
        poblacions = myPoblacionsDAO.getPoblacions();

        myTendesDAO = new TendesDAO(this);
        tendes = myTendesDAO.getTendesPoblacio(getIntent().getExtras().getString("Poblacio"));
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        for (int i=0; i < tendes.size(); i++) {
            Log.d ("tendes", "Tenda: " + tendes.get(i).getTenda());
            latLng = new LatLng(tendes.get(i).getLat(), tendes.get(i).getLon());
            mMap.addMarker(new MarkerOptions().position(latLng).title(tendes.get(i).getTenda())
            );
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        /*
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // Intent for calling MapsTendesActivity
        Intent intent = new Intent(this, InfoTendesActivity.class);
        //Getting the information to send to the other activity
        Bundle b = new Bundle();
        b.putString("Tenda", marker.getTitle());
        for (int i = 0; i < tendes.size() ; i++) {
            if(marker.getTitle().equals(tendes.get(i).getTenda())){
                b.putString("Carrer", tendes.get(i).getAdresa());
                b.putString("telefon", Integer.toString(tendes.get(i).getTelefon()));
                b.putString("url", tendes.get(i).getFoto());
            }
        }

        intent.putExtras(b); //Adding the information to the intent
        startActivity(intent); //Starting the new activity
        return false;
    }
}
