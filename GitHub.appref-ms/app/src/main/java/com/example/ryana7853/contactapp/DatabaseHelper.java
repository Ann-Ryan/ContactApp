package com.example.ryana7853.contactapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ryana7853 on 5/11/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "Contacts.db";
    public static final String TABLE_NAME = "Contact_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "NUMBER";
    public static final String COL_4 = "EMAIL";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String number, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);

        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result));
        if(result == -1) return false;

        contentValues.put(COL_3, number);

        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result));
        if(result == -1) return false;

        contentValues.put(COL_4, email);

        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result));
        if(result == -1) return false;


        /*
        contentValues.put(COL_2, name);
        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result));
        if(result == -1) return false;
        contentValues.put(COL_3, number);
        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        long result2 = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result2));
        //this is the part that returns negative one and fails
         if(result2 == -1) return false;
        contentValues.put(COL_4, email);
        Log.d("MyContact", String.valueOf(contentValues.valueSet()));
        long result3 = db.insert(TABLE_NAME, null, contentValues);
        Log.d("MyContact", String.valueOf(result3));
        if(result3 == -1) return false;
        */

        return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }



}
