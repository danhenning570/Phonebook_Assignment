package com.example.danhe.phonebook_assignment;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase.loadLibs(this);

        MyDatabase myDatabase = new MyDatabase(this);

    }

    public void loadListContacts(View v){
        startActivity(new Intent(this, ListContacts.class));
    }






}
