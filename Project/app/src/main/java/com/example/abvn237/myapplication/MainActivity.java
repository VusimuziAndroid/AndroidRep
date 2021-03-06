package com.example.abvn237.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    Intent startMainScreen = new Intent(getApplicationContext(),Login.class);
                    startActivity(startMainScreen);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        myThread.start();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





       /* bRegister.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                switch( v.getId()) {
                    case R.id.bRegister:

                        String Name = etName.getText().toString();
                        String Surname = etSurname.getText().toString();
                        int marks=1;
                        //   myDB.addStudent(Name,Surname,50,db);
                        // db.execSQL(" insert into student_table values(2,'Thabo','Malaza',60);");
                        // myDB.addStudent(db);


                        Toast.makeText(getApplicationContext(), " Successfully registered ...",
                                Toast.LENGTH_SHORT).show();

                        break;
                }

            }


        });*/
        /*bRegister.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {

                switch( v.getId()) {
                    case R.id.bRegister:

                        String Name = etName.getText().toString();
                        String Surname = etSurname.getText().toString();

                        myDB.addStudent(Name,Surname,50,db);

                        break;
                }

            }




        });*/




    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
