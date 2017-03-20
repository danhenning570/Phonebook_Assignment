package com.example.danhe.phonebook_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by danhenning on 17/03/2017.
 */

import net.sqlcipher.database.SQLiteDatabase;

import java.util.ArrayList;

public class ListContacts extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_contacts);
        lv = (ListView) findViewById(R.id.listView);
        // this might need to be its own activity
        MyDatabase myDatabase = new MyDatabase(this);
        al = myDatabase.getAllContacts();
        SQLiteDatabase.loadLibs(this);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
        lv.setAdapter(adp);
    }

    public void loadAddActivity(View v){
        startActivity(new Intent(this, AddActivity.class));
    }


}
