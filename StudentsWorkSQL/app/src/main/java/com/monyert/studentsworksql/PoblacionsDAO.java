package com.monyert.studentsworksql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

public class PoblacionsDAO {
    private MySQLiteHelper connexion;
    private SQLiteDatabase db;
    ArrayList<Poblacio> llistaPoblacions;

    public PoblacionsDAO(Context context){
        connexion = new MySQLiteHelper( context );
        db = connexion.getWritableDatabase();

    }

    public ArrayList<Poblacio> getPoblacions () {
        String sql = "SELECT * FROM Poblacions" ;
        Cursor c = db.rawQuery(sql, null);
        llistaPoblacions = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Poblacio m = new Poblacio();
                m.setCodi(c.getString(0)); m.setPoblacio(c.getString(1));
                m.setLat(c.getFloat(2)); m.setLon(c.getFloat(3));
                llistaPoblacions.add(m);
            } while(c.moveToNext());
        }
        return llistaPoblacions;
    }

    public void closeDB () {
        db.close();
    }

    public boolean insertPoblacio (Poblacio poblacio) {
        // TODO

        return false;
    }
    public boolean deletePoblacio (String key) {
        // TODO
        return false;
    }
    public boolean updatePoblacio (String key) {
        // TODO
        return false;
    }
}
