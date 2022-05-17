package com.monyert.studentswork3.Control;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.monyert.studentswork3.Model.Poblacio;

import java.util.ArrayList;

public class PoblacionsDAO {
    private MySQLiteHelper connexion;
    private SQLiteDatabase db;
    ArrayList<Poblacio> llistaPoblacions;




    public PoblacionsDAO(Context context){
        connexion = new MySQLiteHelper( context );
        db = connexion.getWritableDatabase();

        //deletePoblacio();
        /*
            Poblacio tavernes = new Poblacio("m0", "Tavernes de la Valldigna", 39.07317018386034, -0.26494752979738223);
            insertPoblacio(tavernes);
            Poblacio gandia = new Poblacio("m1", "Gandia", 38.967945337836085, -0.18451187863968244);
            insertPoblacio(gandia);
            Poblacio alzira = new Poblacio("m2", "Alzira", 39.151022224260785, -0.43321595008796976);
            insertPoblacio(alzira);
            Poblacio carcaixent = new Poblacio("m3", "Carcaixent", 39.12011286519448, -0.45421398631140164);
            insertPoblacio(carcaixent);
            Poblacio cullera = new Poblacio("m4", "Cullera", 39.16321812890377, -0.25443139749950205);
            insertPoblacio(cullera);
           */
    }

    public ArrayList<Poblacio> getPoblacions () {
        String sql = "SELECT * FROM Poblacions" ;
        Cursor c = db.rawQuery(sql, null);
        llistaPoblacions = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Poblacio m = new Poblacio();
                m.setCodi(c.getString(0));
                m.setPoblacio(c.getString(1));
                m.setLat(c.getDouble(2));
                m.setLon(c.getDouble(3));
                llistaPoblacions.add(m);
            } while(c.moveToNext());
        }
        return llistaPoblacions;
    }

    public void closeDB () {
        db.close();
    }

    public boolean insertPoblacio (Poblacio poblacio) {
        db.execSQL("INSERT INTO Poblacions (codi, poblacio, Lat, Lon) " +
                "VALUES ('" + poblacio.getCodi() + "', '" + poblacio.getPoblacio() +"', " + poblacio.getLat() + "," + poblacio.getLon() +")");
        // TODO

        return true;
    }
    public boolean deletePoblacio () {
        db.execSQL("DROP TABLE IF EXISTS Poblacions ");
        db.execSQL("CREATE TABLE Poblacions (codi TEXT PRIMARY KEY, poblacio TEXT NOT NULL, Lat REAL NOT NULL, Lon REAL NOT NULL)");
        // TODO
        return true;
    }
    public boolean updatePoblacio (String key) {
        // TODO
        return false;
    }
}
