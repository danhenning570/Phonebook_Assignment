package com.example.danhe.phonebook_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by danhenning on 17/03/2017.
 */

import net.sqlcipher.database.SQLiteDatabase;

public class AddActivity extends AppCompatActivity {

    MyDatabase myDatabase;

    EditText etFirstName, etSurName, etMobile, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        myDatabase = new MyDatabase(this);
        etFirstName = (EditText) findViewById(R.id.editText);
        etSurName = (EditText) findViewById(R.id.editText2);
        etMobile = (EditText) findViewById(R.id.editText4);
        etEmail = (EditText) findViewById(R.id.editText3);



    }

    public void saveData(View v){
        String firstname = etFirstName.getText().toString();
        String surname = etSurName.getText().toString();
        String mobile = etMobile.getText().toString();
        String email = etEmail.getText().toString();
        etFirstName.setText("");
        etSurName.setText("");
        etMobile.setText("");
        etEmail.setText("");
        myDatabase.addContact(firstname,surname,mobile,email);
        Toast.makeText(this,"Contact Saved",Toast.LENGTH_SHORT).show();

    }
    public void goBack(View v){
        startActivity(new Intent(this,ListContacts.class));
    }




    }

