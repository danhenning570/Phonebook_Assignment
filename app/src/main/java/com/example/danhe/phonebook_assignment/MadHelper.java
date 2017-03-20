package com.example.danhe.phonebook_assignment;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by danhenning on 16/03/2017.
 */

public class MadHelper extends SQLiteOpenHelper {

    public static  final String DATABASE_NAME = "maddb";
    public static  final int DATABASE_VERSION = 1;

    public static  final String TABLE_NAME = "contact";
    public static  final String FIELD_ID= "id";
    public static  final String FIELD_FIRSTNAME= "firstname";
    public static  final String FIELD_SURNAME= "surname";
    public static  final String FIELD_MOBILE= "mobile";
    public static  final String FIELD_EMAIL= "email";
    public static  final String QUERY_CREATE = "CREATE TABLE "+TABLE_NAME+" ( "+FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIELD_FIRSTNAME+" VARCHAR(120), "+FIELD_SURNAME+" VARCHAR(120),"+FIELD_MOBILE+" VARCHAR(100), "+FIELD_EMAIL+" VARCHAR(150) ) ";

    public MadHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE);

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){

}



}



