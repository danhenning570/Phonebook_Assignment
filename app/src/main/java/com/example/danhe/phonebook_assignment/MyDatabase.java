package com.example.danhe.phonebook_assignment;

import android.content.ContentValues;
import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import android.provider.SyncStateContract;
import android.support.v7.view.menu.MenuAdapter;

import java.util.ArrayList;

/**
 * Created by danhenning on 17/03/2017.
 */

public class MyDatabase {
    public static final String TABLE_NAME = "contact";
    public static final String FIELD_ID = "id";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_SURNAME = "surname";
    public static final String FIELD_MOBILE = "mobile";
    public static final String FIELD_EMAIL = "email";

    Context con;
    MadHelper madHelper;


    public MyDatabase(Context context) {
        con = context;
        madHelper = new MadHelper(con);
    }

    public void addContact(String firstname, String surname, String mobile, String email) {
        SQLiteDatabase db = madHelper.getWritableDatabase("Password");
        //db.execSQL("insert into contact (_id, name, mobile, email) values(''Abd','123','Abd')");
        ContentValues values = new ContentValues();
        values.put(FIELD_FIRSTNAME, firstname);
        values.put(FIELD_SURNAME, surname);
        values.put(FIELD_MOBILE, mobile);
        values.put(FIELD_EMAIL, email);
        db.insert(TABLE_NAME, FIELD_FIRSTNAME, values);
    }

    public ArrayList<String> getAllContacts(){
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = madHelper.getWritableDatabase("Password");
        String[] col = {FIELD_FIRSTNAME,FIELD_SURNAME,FIELD_EMAIL,FIELD_MOBILE};
        Cursor cu = db.query(TABLE_NAME,col,null,null,null,null,null);
        cu.moveToFirst();
            while ( cu.moveToNext() ) {
                String firstname = cu.getString(cu.getColumnIndex(FIELD_FIRSTNAME));
                String surname = cu.getString(cu.getColumnIndex(FIELD_SURNAME));
                String email = cu.getString(cu.getColumnIndex(FIELD_EMAIL));
                String mobile = cu.getString(cu.getColumnIndex(FIELD_MOBILE));
                String row = firstname+" "+surname+" "+email+" "+mobile;
                data.add(row);

            }


        return data;
    }





}



