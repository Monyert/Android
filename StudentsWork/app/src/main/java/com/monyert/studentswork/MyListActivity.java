package com.monyert.studentswork;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListActivity extends MainMenu {

    String[] nom_anime = {"Dragon Quest: Fly", "Dragon Ball" ,  "Black Lagoon"};
    String[] nom_anime2 = {"Fly", "Goku" ,  "Lagoon"};
    String[] nom_anime3 = {"1988", "1982" ,  "2004"};
    int[] image_anime = {R.mipmap.angel, R.mipmap.goku, R.mipmap.foto};
    int[] image_anime2 = {R.mipmap.fly, R.mipmap.bola, R.mipmap.blacklagoon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView myanime = (ListView) findViewById(R.id.contenedor_listas);
        final Adaptador adaptador = new Adaptador();

        myanime.setAdapter(adaptador);
        myanime.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                buildDialog ( nom_anime2[position], nom_anime3[position] , position );
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    class Adaptador extends BaseAdapter{

        @Override
        public int getCount() {
            return image_anime.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.item_list,null);
            ImageView imagen = (ImageView)view.findViewById(R.id.imagen_lista);
            TextView texto = (TextView)view.findViewById(R.id.texto_lista);

            imagen.setImageResource(image_anime[i]);
            texto.setText(nom_anime[i]);
            return view;
        }
    }

    public void buildDialog (String title, String message, int position) {
        final ImageView image = new ImageView(this); image.setImageResource(image_anime2[position]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title); builder.setMessage(message); builder.setPositiveButton("OK", null);
        builder.setView(image); builder.create(); builder.show();
    }

}


