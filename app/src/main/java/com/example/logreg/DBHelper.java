package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "androiddb";
    public static final int DB_VERSION = 1;

    public static final String FELHASZNALO_TABLE = "felhasznalo";

    public static final String COL_ID = "id";
    public static final String COL_EMAIL = "email";
    public static final String COL_FELHASZNALONEV = "felhnev";
    public static final String COL_JELSZO = "jelszo";
    public static final String COL_TELJESNEV = "teljesnev";
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " +FELHASZNALO_TABLE+ " ("+
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL+" VARCHAR(255) NOT NULL, " +
                COL_FELHASZNALONEV+"VARCHAR(255) NOT NULL"+
                COL_JELSZO+"VARCHAR(255) NOT NULL"+
                COL_TELJESNEV+"VARCHAR(255) NOT NULL"+
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+ FELHASZNALO_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }
    public boolean adatrogzites(String email, String felhasznalonev, String jelszo,String teljesnev){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_EMAIL, email);
        values.put(COL_FELHASZNALONEV, felhasznalonev);
        values.put(COL_JELSZO, jelszo);
        values.put(COL_TELJESNEV, teljesnev);
        return db.insert(FELHASZNALO_TABLE,null,values) != -1;
    }
    public Cursor adatLekerdezes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(FELHASZNALO_TABLE, new String[]{COL_ID,COL_EMAIL,COL_FELHASZNALONEV,COL_JELSZO,COL_TELJESNEV},null,null,null,null,null);
    }

}
