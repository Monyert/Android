package com.monyert.studentsworksql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Informatica";
    private static final int DATABASE_VERSION = 1;

    //SQL sentence to create a table
    String sqlCreate = "CREATE TABLE Tendes (codi TEXT PRIMARY KEY, poblacio TEXT NOT NULL, Lat REAL NOT NULL, Lon REAL NOT NULL)";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Tendes ");
        db.execSQL(sqlCreate); // Creating a new version
    }
}
