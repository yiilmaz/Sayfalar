package com.sedatyilmaz.sayfalar;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME ="Veri.db";
    public static final String TABLE_URUNLER = "Urunler";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_URUNAD = "_urunAd";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sorgu = "Create Table " + TABLE_URUNLER + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_URUNAD + " TEXT" +
                ");";
        db.execSQL(sorgu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_URUNLER);
        onCreate(db);
    }

    public void urunEkle(Urunler urun){
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(COLUMN_URUNAD, urun.get_urunAd());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_URUNLER, null, contentValues1);
        db.close();
    }

    public void urunSil(String urunAd){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from " + TABLE_URUNLER + " where " + COLUMN_URUNAD + "=\"" + urunAd + "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getReadableDatabase();
        String sorgu = "select * from " + TABLE_URUNLER;

        Cursor c = db.rawQuery(sorgu, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex(COLUMN_URUNAD))!=null){
                dbString += c.getString(c.getColumnIndex(COLUMN_URUNAD));
                dbString += "\n";
            }
            c.moveToNext();
        }

        c.close();
        db.close();
        return  dbString;
    }
}
