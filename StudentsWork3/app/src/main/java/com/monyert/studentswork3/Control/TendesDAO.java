package com.monyert.studentswork3.Control;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.monyert.studentswork3.Model.Tenda;

import java.util.ArrayList;

public class TendesDAO {
    private MySQLiteHelper connexion;
    private SQLiteDatabase db;
    ArrayList<Tenda> llistaTendes;

    public TendesDAO(Context context) {
        connexion = new MySQLiteHelper( context );
        db = connexion.getWritableDatabase();

        //deleteTenda();
        /*
        //Tendes per defecte
        //Tavernes
        Tenda dulasoft = new Tenda("m0", "DulaSoft", 39.0742933, -0.2623244, "m0", 962042042, "Carrer Pintor Sorolla, 10", "https://geo2.ggpht.com/cbk?panoid=uCya8S-WrADJcJApaU3LfA&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=78.21614&pitch=0&thumbfov=100");
        insertTenda(db, dulasoft);
        Tenda apptavernes = new Tenda("m1", "App Tavernes", 39.0713536, -0.2656068, "m0", 611469719, "C/ Nou 10 Bajo Derecha", "https://lh5.googleusercontent.com/p/AF1QipMv-Con-Odt73UL-ToqeabkJ7YUZdhUqrTWRMbz=w408-h306-k-no");
        insertTenda(db, apptavernes);
        //Gandia
        Tenda pcboxgandia = new Tenda("m3", "PCBOX Gandía", 38.9688219, -0.1838479, "m1", 962950693, "Carrer Magistrat Català, 36", "https://lh5.googleusercontent.com/p/AF1QipNQrPPfxP0DX5V8FTzH2fYk2iEGnzdhrNfB-U-M=w408-h306-k-no");
        insertTenda(db, pcboxgandia);
        Tenda maingandia = new Tenda("m4", "Main Informàtica", 38.967845, -0.1914968, "m1", 962965723, "Plaça Alqueria Nova, 1", "https://lh5.googleusercontent.com/p/AF1QipPSj0PxLpTgA2z23xUI2wwt3tenvZYYLP_25raN=w408-h374-k-no");
        insertTenda(db, maingandia);
        //Alzira
        Tenda inbox = new Tenda("m5", "INBOX ALZIRA", 39.1488273, -0.4339983, "m2", 962019731, "Carrer de Gabriela Mistral, 13", "https://lh5.googleusercontent.com/p/AF1QipPetktP14l3VRVAV6HbXbPLNRghXcB_731rWWkj=w540-h200-k-no");
        insertTenda(db, inbox);
        Tenda maxpc = new Tenda("m6", "Maxpc", 39.1479711, -0.4379587, "m2", 962014142, "Calle Colón Nº34", "https://lh5.googleusercontent.com/p/AF1QipMNzRHySrKMpYMzwVPYEpTCKc6muBwopaeJT8mf=w408-h407-k-no");
        insertTenda(db, maxpc);
        //Carcaixent
        Tenda ewop = new Tenda("m7", "Ewop Informática", 39.1213314, -0.4486178, "m3", 962018855, "Carrer de José Vidal Canet, 69", "https://lh5.googleusercontent.com/p/AF1QipP9EUtHGHIGzb5TWDvNf20khDPW4rT_s7nJ_-4=w408-h544-k-no");
        insertTenda(db, ewop);
        Tenda vico = new Tenda("m8", "Vicoral Informatica", 39.1220394, -0.450651, "m3", 962013820, "Carrer de Julián Ribera, 9", "https://lh5.googleusercontent.com/p/AF1QipPJGYoBZEqeSk27KzYbTYJnykBFkKugR8i8J7sq=w408-h229-k-no");
        insertTenda(db, vico);
        //Cullera
        Tenda tot = new Tenda("m9", "TOT INFORMATICA", 39.1622998, -0.2541872, "m4", 961730760, "Avinguda del País Valencià, 29", "https://geo0.ggpht.com/cbk?panoid=h6OKrTfzb2I1C5jhCkTpIQ&output=thumbnail&cb_client=search.TACTILE.gps&thumb=2&w=408&h=200&yaw=357.32648&pitch=0&thumbfov=100");
        insertTenda(db, tot);
        Tenda appcullera = new Tenda("m10", "APP CULLERA", 39.1629926, -0.2482393, "m4", 960073380, "Carrer del 25 Abril, 27", "https://lh5.googleusercontent.com/p/AF1QipO9OoP_GVcPqrbSe1OdZ1xw2umYUNra3mZAAUJ5=w408-h306-k-no");
        insertTenda(db, appcullera);
        */
    }

    public ArrayList<Tenda> getTendesPoblacio (String poblacio) {
        String sql = "SELECT * FROM Tendes WHERE Poblacio = '" + poblacio +"';";
        Cursor c = db.rawQuery(sql, null);
        llistaTendes = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                Tenda m = new Tenda();
                m.setCodi(c.getString(0));
                m.setTenda(c.getString(1));
                m.setLat(c.getDouble(2));
                m.setLon(c.getDouble(3));
                m.setPoblacio(c.getString(4));
                m.setTelefon(c.getInt(5));
                m.setAdresa(c.getString(6));
                m.setFoto(c.getString(7));
                llistaTendes.add(m);
            } while(c.moveToNext());
        }
        return llistaTendes;

    }

    public void closeDB () {
        db.close();
    }

    public boolean insertTenda (Tenda tenda) {
        db.execSQL("INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) " +
                "VALUES ('" + tenda.getCodi() + "', '" + tenda.getTenda() +"', " + tenda.getLat() + "," + tenda.getLon() + ",'" + tenda.getPoblacio() + "'," + tenda.getTelefon() + ",'" + tenda.getAdresa() + "','" + tenda.getFoto() + "')");

        return true;
    }
    public boolean deleteTenda () {
        db.execSQL("DROP TABLE IF EXISTS Tendes ");
        db.execSQL("CREATE TABLE Tendes (codi TEXT PRIMARY KEY, tenda TEXT NOT NULL, Lat REAL, Lon REAL,\n" +
                "Poblacio TEXT, Telefon TEXT, Adresa TEXT, Foto TEXT, FOREIGN\n" +
                "KEY(Poblacio) REFERENCES Poblacions(codi))");

        return true;
    }
    public boolean updatePoblacio (String key) {
        // TODO
        return false;
    }

}
