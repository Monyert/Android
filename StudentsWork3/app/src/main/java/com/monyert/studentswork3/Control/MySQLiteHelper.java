package com.monyert.studentswork3.Control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.monyert.studentswork3.Model.Poblacio;
import com.monyert.studentswork3.Model.Tenda;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Informatica";
    private static final int DATABASE_VERSION = 10;

    //SQL sentence to create a table
    String sqlCreate = "CREATE TABLE Poblacions (codi TEXT PRIMARY KEY, poblacio TEXT NOT NULL, Lat REAL NOT NULL, Lon REAL NOT NULL)";
    String sqlCreate2 = "CREATE TABLE Tendes (codi TEXT PRIMARY KEY, tenda TEXT NOT NULL, Lat REAL, Lon REAL,\n" +
            "Poblacio TEXT, Telefon TEXT, Adresa TEXT, Foto TEXT, FOREIGN\n" +
            "KEY(Poblacio) REFERENCES Poblacions(codi))";

    String tavernes = "INSERT INTO Poblacions (codi, poblacio, Lat, Lon) VALUES ('m0', 'Tavernes de la Valldigna', 39.07317018386034, -0.26494752979738223)";
    String gandia = "INSERT INTO Poblacions (codi, poblacio, Lat, Lon) VALUES ('m1', 'Gandia', 38.967945337836085, -0.18451187863968244)";
    String alzira = "INSERT INTO Poblacions (codi, poblacio, Lat, Lon) VALUES ('m2', 'Alzira', 39.151022224260785, -0.43321595008796976)";
    String carcaixent = "INSERT INTO Poblacions (codi, poblacio, Lat, Lon) VALUES ('m3', 'Carcaixent', 39.12011286519448, -0.45421398631140164)";
    String cullera = "INSERT INTO Poblacions (codi, poblacio, Lat, Lon) VALUES ('m4', 'Cullera', 39.16321812890377, -0.25443139749950205)";

    String dulasoft = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m0', 'DulaSoft', 39.0742933, -0.2623244, 'm0', 962042042, 'Carrer Pintor Sorolla, 10', 'dulasoft.jpg')";
    String apptavernes = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m1', 'App Tavernes', 39.0713536, -0.2656068, 'm0', 611469719, 'C/ Nou 10 Bajo Derecha', 'apptavernes.jpg')";

    String pcboxgandia = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m2', 'PCBOX Gandía', 38.9688219, -0.1838479, 'm1', 962950693, 'Carrer Magistrat Català, 36', 'pcboxgandia.jpg')";
    String maingandia = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m3', 'Main Informàtica', 38.967845, -0.1914968, 'm1', 962965723, 'Plaça Alqueria Nova, 1', 'maingandia.jpg')";

    String inbox = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m4', 'INBOX ALZIRA', 39.1488273, -0.4339983, 'm2', 962019731, 'Carrer de Gabriela Mistral, 13', 'inboxalz.jpg')";
    String maxpc = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m5', 'Maxpc', 39.1479711, -0.4379587, 'm2', 962014142, 'Calle Colón Nº34', 'maxpcalz.jpg')";

    String ewop = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m6', 'Ewop Informática', 39.1213314, -0.4486178, 'm3', 962018855, 'Carrer de José Vidal Canet, 69', 'ewopcar.jpg')";
    String vico = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m7', 'Vicoral Informatica', 39.1220394, -0.450651, 'm3', 962013820, 'Carrer de Julián Ribera, 9', 'vicocar.jpg')";

    String tot = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m8', 'TOT INFORMATICA', 39.1622998, -0.2541872, 'm4', 961730760, 'Avinguda del País Valencià, 29', 'totcull.jpg')";
    String appcullera = "INSERT INTO Tendes (codi, tenda, Lat, Lon, poblacio, telefon, adresa, foto) VALUES ('m9', 'APP CULLERA', 39.1629926, -0.2482393, 'm4', 960073380, 'Carrer del 25 Abril, 27', 'appcull.png')";
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
        db.execSQL(sqlCreate2);

        db.execSQL(tavernes);
        db.execSQL(gandia);
        db.execSQL(alzira);
        db.execSQL(carcaixent);
        db.execSQL(cullera);

        db.execSQL(dulasoft);
        db.execSQL(apptavernes);

        db.execSQL(pcboxgandia);
        db.execSQL(maingandia);

        db.execSQL(inbox);
        db.execSQL(maxpc);

        db.execSQL(ewop);
        db.execSQL(vico);

        db.execSQL(tot);
        db.execSQL(appcullera);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Poblacions ");
        db.execSQL(sqlCreate); // Creating a new version
        db.execSQL("DROP TABLE IF EXISTS Tendes ");
        db.execSQL(sqlCreate2);

        db.execSQL(tavernes);
        db.execSQL(gandia);
        db.execSQL(alzira);
        db.execSQL(carcaixent);
        db.execSQL(cullera);

        db.execSQL(dulasoft);
        db.execSQL(apptavernes);

        db.execSQL(pcboxgandia);
        db.execSQL(maingandia);

        db.execSQL(inbox);
        db.execSQL(maxpc);

        db.execSQL(ewop);
        db.execSQL(vico);

        db.execSQL(tot);
        db.execSQL(appcullera);

    }

}
