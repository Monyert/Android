package com.monyert.studentswork3.View;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.monyert.studentswork3.Control.MySQLiteHelper;
import com.monyert.studentswork3.R;

import java.io.InputStream;

public class GestioPoblacionsActivity extends MainMenu {

    SQLiteDatabase db;
    MySQLiteHelper connexion;

    EditText codi;
    EditText nom;
    EditText lat;
    EditText lon;
    TextView res;

    Button ins, upd, del, list;

    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestio_poblacions);
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

        connexion = new MySQLiteHelper(this);
        db = connexion.getWritableDatabase();

        codi = (EditText) findViewById(R.id.edit_codi);
        nom = (EditText) findViewById(R.id.edit_nom);
        lat = (EditText) findViewById(R.id.edit_lat);
        lon = (EditText) findViewById(R.id.edit_lon);
        res = (TextView) findViewById(R.id.text_res);

        ins = (Button) findViewById(R.id.boto_insert);
        upd = (Button) findViewById(R.id.boto_update);
        del = (Button) findViewById(R.id.bodo_borrar);
        list = (Button) findViewById(R.id.boto_list);


        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = codi.getText().toString();
                char[] charArray = test.toCharArray();

                if (codi.getText().toString().equals("") || charArray[0] != 109 || nom.getText().toString().equals("") || lat.getText().toString().equals("") || lon.getText().toString().equals("")){
                    Toast.makeText(GestioPoblacionsActivity.this, "Invalid Data, Try Again", Toast.LENGTH_SHORT).show();
                }else {
                    String cod = codi.getText().toString();
                    String name = nom.getText().toString();
                    String lati = lat.getText().toString();
                    String loni = lon.getText().toString();

                    ContentValues nouRegistre = new ContentValues();
                    nouRegistre.put("codi", cod);
                    nouRegistre.put("poblacio", name);
                    nouRegistre.put("Lat", lati);
                    nouRegistre.put("Lon", loni);

                    db.insert("Poblacions", null, nouRegistre);
                    Toast.makeText(GestioPoblacionsActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT codi, poblacio, Lat, Lon FROM Poblacions", null);
                res.setText("");
                if(c.moveToFirst()){
                    do{
                        String cod = c.getString(0);
                        String name = c.getString(1);
                        String lati = c.getString(2);
                        String loni = c.getString(3);

                        res.append(" "+cod+" "+ name + " "+lati+" "+loni+"\n");
                    }while (c.moveToNext());
                }
            }
        });

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = codi.getText().toString();
                char[] charArray = test.toCharArray();
                if (codi.getText().toString().equals("")||nom.getText().toString().equals("")||lat.getText().toString().equals("")||lon.getText().toString().equals("")
                        || charArray[0] != 109 || nom.getText().toString().equals("") || lat.getText().toString().equals("") || lon.getText().toString().equals("")){
                    Toast.makeText(GestioPoblacionsActivity.this, "Invalid Data Update, Try Again", Toast.LENGTH_SHORT).show();
                }else {
                    String cod = codi.getText().toString();
                    String name = nom.getText().toString();
                    String lati = lat.getText().toString();
                    String loni = lon.getText().toString();

                    ContentValues update = new ContentValues();
                    update.put("codi", cod);
                    update.put("poblacio", name);
                    update.put("Lat", lati);
                    update.put("Lon", loni);

                    db.update("Poblacions", update, "codi = ?", new String[]{cod});
                    Toast.makeText(GestioPoblacionsActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = codi.getText().toString();

                db.delete("Poblacions","codi = ?",new String[]{cod});
                Toast.makeText(GestioPoblacionsActivity.this, "Code "+cod+" Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
