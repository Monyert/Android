package com.monyert.studentswork3.View;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.monyert.studentswork3.Control.MySQLiteHelper;
import com.monyert.studentswork3.R;

public class GestioTendesActivity extends MainMenu {

    SQLiteDatabase db;
    MySQLiteHelper connexion;

    EditText codi;
    EditText nom;
    EditText lat;
    EditText lon;
    EditText poblacio;
    EditText telefon;
    EditText adreça;
    EditText foto;

    TextView res;

    Button ins, upd, del, list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestio_tendes);
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
        poblacio = (EditText) findViewById(R.id.edit_Poblacio);
        telefon = (EditText) findViewById(R.id.edit_Telefon);
        adreça = (EditText) findViewById(R.id.edit_Adreça);
        foto = (EditText) findViewById(R.id.edit_URL);

        res = (TextView) findViewById(R.id.text_res);
        res.setMovementMethod(new ScrollingMovementMethod());

        ins = (Button) findViewById(R.id.boto_insert);
        upd = (Button) findViewById(R.id.boto_update);
        del = (Button) findViewById(R.id.bodo_borrar);
        list = (Button) findViewById(R.id.boto_list);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = codi.getText().toString();
                char[] charArray = test.toCharArray();
                String test2 = poblacio.getText().toString();
                char[] charArray2 = test2.toCharArray();

                if (codi.getText().toString().equals("") || charArray[0] != 109 || nom.getText().toString().equals("") || lat.getText().toString().equals("")
                        || lon.getText().toString().equals("") || charArray2[0] != 109 || telefon.getText().toString().equals("") || adreça.getText().toString().equals("")){
                    Toast.makeText(GestioTendesActivity.this, "Invalid Data, Try Again", Toast.LENGTH_SHORT).show();
                }else {

                    String cod = codi.getText().toString();
                    String name = nom.getText().toString();
                    String lati = lat.getText().toString();
                    String loni = lon.getText().toString();
                    String pob = poblacio.getText().toString();
                    String tel = telefon.getText().toString();
                    String adr = adreça.getText().toString();
                    String img = foto.getText().toString();

                    ContentValues nouRegistre = new ContentValues();
                    nouRegistre.put("codi", cod);
                    nouRegistre.put("tenda", name);
                    nouRegistre.put("Lat", lati);
                    nouRegistre.put("Lon", loni);
                    nouRegistre.put("poblacio", pob);
                    nouRegistre.put("telefon", tel);
                    nouRegistre.put("adresa", adr);
                    nouRegistre.put("foto", img);

                    db.insert("Tendes", null, nouRegistre);
                    Toast.makeText(GestioTendesActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM Tendes", null);
                res.setText("");
                if(c.moveToFirst()){
                    do{
                        String cod = c.getString(0);
                        String name = c.getString(1);
                        String lati = c.getString(2);
                        String loni = c.getString(3);
                        String pob = c.getString(4);
                        String tel = c.getString(5);
                        String adr = c.getString(6);
                        String img = c.getString(7);


                        res.append(" "+cod+" "+ name + " " +lati+ " " +loni+ " " +pob+ "\n"+tel+ "\n"+adr+ "\n"+ img + "\n");
                        res.append("\n");
                    }while (c.moveToNext());
                }
            }
        });

        upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = codi.getText().toString();
                char[] charArray = test.toCharArray();
                String test2 = poblacio.getText().toString();
                char[] charArray2 = test2.toCharArray();

                if (codi.getText().toString().equals("") || charArray[0] != 109 || nom.getText().toString().equals("") || lat.getText().toString().equals("")
                        || lon.getText().toString().equals("") || charArray2[0] != 109 || telefon.getText().toString().equals("") || adreça.getText().toString().equals("")){
                    Toast.makeText(GestioTendesActivity.this, "Invalid Data Update, Try Again", Toast.LENGTH_SHORT).show();
                }else {
                    String cod = codi.getText().toString();
                    String name = nom.getText().toString();
                    String lati = lat.getText().toString();
                    String loni = lon.getText().toString();
                    String pob = poblacio.getText().toString();
                    String tel = telefon.getText().toString();
                    String adr = adreça.getText().toString();
                    String img = foto.getText().toString();

                    ContentValues update = new ContentValues();
                    update.put("codi", cod);
                    update.put("tenda", name);
                    update.put("Lat", lati);
                    update.put("Lon", loni);
                    update.put("poblacio", pob);
                    update.put("telefon", tel);
                    update.put("adresa", adr);
                    update.put("foto", img);

                    db.update("Tendes", update, "codi = ?", new String[]{cod});
                    Toast.makeText(GestioTendesActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = codi.getText().toString();

                db.delete("Tendes","codi = ?",new String[]{cod});
                Toast.makeText(GestioTendesActivity.this, "Code "+cod+" Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
