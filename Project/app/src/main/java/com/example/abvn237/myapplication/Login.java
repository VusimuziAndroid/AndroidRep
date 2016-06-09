package com.example.abvn237.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Login extends AppCompatActivity {

    EditText etAccNr,etATMPin,etIdNr;
    TextView tvRegisterLink;
   // Button bRegister,bLogin;

    DatabaseHelper myDB; // declaring the database handler
    SQLiteDatabase db; // declaring the sqlite database variable
    Button bRegister,bLogin; // creating the regitration button
    Context context=this;

    ArrayAdapter<String> adapter;
    ArrayList<String> login= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

        etAccNr = (EditText) findViewById(R.id.etAccountNr);
        etATMPin = (EditText) findViewById(R.id.etATMPin);
        etIdNr = (EditText) findViewById(R.id.etIdNr);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        db=openOrCreateDatabase("BusinessBankingApp33.sql",MODE_PRIVATE,null);
//        myDB = new DatabaseHelper(this);

        //Opening or creating the database


        
       // bRegister = (Button) findViewById(R.id.bRegister);
       // bLogin = (Button) findViewById(R.id.bLogin);
              /*  bRegister.setOnClickListener((View.OnClickListener) this);
        bLogin.setOnClickListener((View.OnClickListener) this);*/
    }

    //The onClick method for handling the events
    public void onClickLogin(View view){

        switch( view.getId()) {

            case R.id.bLogin:

                String accNr = etAccNr.getText().toString();

                String pinNr = etATMPin.getText().toString();


                setAccHolderSessionInfo(accNr);

                Login(accNr,pinNr);


                break;

            case R.id.tvRegisterLink:

                 //The intent for redirecting to the activity for validate the existance of the account before registration

                Intent register = new Intent(Login.this,Registration.class);
                startActivity(register);


                break;
        }

    }



    public void Login(String accNr, String pinNr){

        //declaring the cursor for receiving the columns from the database

        // Cursor c = db.rawQuery(" SELECT ACC_NR,CAWRD_NR,PIN_NUMBER FROM Account ",null);


        if(accNr.equals(""))
        {

            etAccNr.setError("Supply the value for the account");
           /* Toast.makeText(Login.this, "Supply value for the account number",
                    Toast.LENGTH_SHORT).show();*/
        }
        else if(pinNr.equals(""))
        {
            etATMPin.setError("Supply the value for the pin number");
           /* Toast.makeText(Login.this, "Supply value for the pin number",
                    Toast.LENGTH_SHORT).show();*/
        }
        else {

            //The while loop for looping through the cursor

            /*SharedPreferences accessValue1 = this.getSharedPreferences("MyPrefs",MODE_PRIVATE);
            SharedPreferences.Editor e = accessValue1.edit();*/




            if (accNr.equals(accNr) && pinNr.equals(pinNr)) {

                Intent home = new Intent(Login.this, Home.class);
                startActivity(home);
            }
            //   else if(!accNr.equals(AccNr) && !pinNr.equals(PinNr)){
            else {
                Toast.makeText(Login.this, "The credentials supplied does n't exists",
                        Toast.LENGTH_SHORT).show();
            }
          //  checkLogin(accNr,pinNr);
            //   Cursor c = db.rawQuery(" SELECT ACC_NR,CARD_NR,PIN_NUMBER,ID_NUMBER FROM Account WHERE ACC_NR="+accNr,null);

        }

    }





    public void checkLogin(String accNr, String pinNr)
    {

       // Cursor c = db.rawQuery(" SELECT a.ACC_NR ACC_NR,a.CARD_NR CARD_NR,a.PIN_NUMBER PIN_NUMBER,a.ID_NUMBER ID_NUMBER, at.ACC_TYPE_ID ACC_TYPE_ID,at.ACC_TYPE_DESC ACC_TYPE_DESC,u.USERNAME USERNAME, u.PASSWORD PASSWORD,ah.ACC_HOLDER_NAME ACC_HOLDER_NAME,ah.ACC_HOLDER_SURNAME ACC_HOLDER_SURNAME FROM Account a, AccType at, User u,Account_Holder ah WHERE a.ACC_TYPE_ID=at.ACC_TYPE_ID AND a.USER_ID=u.USER_ID AND a.ACC_NR = ah.ACC_NR AND a.ACC_NR="+accNr,null);
        Cursor c=myDB.getAccountDetails(accNr,db);
        while(c.moveToNext()){


            String AccNr = c.getString(0);
            String CardNr = c.getString(1);
            String PinNr = c.getString(2);
            String IdNr = c.getString(3);
            String AccTypeId=c.getString(4);
            String AccType = c.getString(5);
            String Username = c.getString(6);
            String Password = c.getString(7);
            String Name=c.getString(8);
            String Surname=c.getString(9);



            // String Username=c.getString(3);

            Account account = new Account();

            // account.setAccount(AccNr,CardNr, PinNr, DateOpened,AccTypeId);

            account.setAccountNr(AccNr);
            account.setCardNumber(CardNr);
            account.setPinNumber(PinNr);
            account.setIDNumber(IdNr);


            AccType accType = new AccType(AccTypeId,AccType);
          //  accType.setAccTypeId(AccTypeId);


            User user = new User(Username,Password);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            String strDate = dateFormat.format(date);

           // setUserSession(account,accType,user);

            SharedPreferences pref = getSharedPreferences("MyPref",context.MODE_PRIVATE);

            SharedPreferences.Editor edit = pref.edit();

            edit.putString("AccNr",account.getAccountNr());
            edit.putString("PinNr",account.getPinNumber());
            edit.putString("CardNr",account.getCardNumber());
            edit.putString("IdNr",account.getIDNumber());
            edit.putString("AccTypeId",accType.getAccTypeId());
            edit.putString("AccType", accType.getAccTypeDesc());
            edit.putString("Username",user.getUsername());
            edit.putString("Password",user.getPassword());
            edit.putString("CurrentDate",strDate);


          /*  edit.putString("Name",Name);
            edit.putString("Surname",Surname);*/


            edit.commit();
















               /* Toast.makeText(Login.this, "Account Number "+account.getAccountNr()+" Pin Number "+account.getPinNumber(),
                        Toast.LENGTH_SHORT).show();*/




            if (account.getAccountNr().equals(accNr) && account.getPinNumber().equals(pinNr)) {

                Intent home = new Intent(Login.this, Home.class);
                startActivity(home);
            }
            //   else if(!accNr.equals(AccNr) && !pinNr.equals(PinNr)){
            else {
                Toast.makeText(Login.this, "The credentials supplied does n't exists",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void setAccHolderSessionInfo(String accNr){


        Cursor c = db.rawQuery(" SELECT ah.ACC_HOLDER_NAME ACC_HOLDER_NAME, ah.ACC_HOLDER_SURNAME ACC_HOLDER_SURNAME,ah.ADDRESS ADDRESS,ah.ID_NUMBER ID_NUMBER,ah.USER_ID USER_ID, t.TREND_DATE TREND_DATE, t.TREND_TIME TREND_TIME, t.BALANCE BALANCE, t.ACC_TYPE_ID ACC_TYPE_ID FROM Account_Holder ah, Trend t, Account a WHERE ah.ACC_NR=a.ACC_NR AND t.ACC_NR=a.ACC_NR  AND a.ACC_NR="+accNr,null);
        while(c.moveToNext()) {


            String Name=c.getString(0);
            String Surname=c.getString(1);
            String Address=c.getString(2);
            String IdNumber=c.getString(3);
            String UserId=c.getString(4);
            String TrendDate=c.getString(5);
            String TrendTime=c.getString(6);
            String Balance=c.getString(7);
            String AccTypeId=c.getString(8);

            SharedPreferences pref = getSharedPreferences("MyPref", context.MODE_PRIVATE);

            SharedPreferences.Editor edit = pref.edit();


            edit.putString("Name",Name);
            edit.putString("Surname",Surname);
            edit.putString("Address",Address);
            edit.putString("IdNumber",IdNumber);
            edit.putString("User_Id",UserId);
            edit.putString("TrendDate",TrendDate);
            edit.putString("TrendTime",TrendTime);
            edit.putString("Balance",Balance);
            edit.putString("AccTypeId",AccTypeId);

            edit.commit();


        }


      /*  Cursor c2 = db.rawQuery(" SELECT TREND_NR, TREND_DATE, TREND_TIME, BALANCE, ACC_TYPE_ID, ACC_NR FROM Trend WHERE ACC_NR="+accNr,null);
        while(c.moveToNext()) {


            String TrendNr=c.getString(0);
            String TrendDate=c.getString(1);
            String TrendTime=c.getString(2);
            String Balance=c.getString(3);
            String AccTypeId=c.getString(4);
            String AccNr=c.getString(5);



            SharedPreferences pref = getSharedPreferences("MyPref", context.MODE_PRIVATE);

            SharedPreferences.Editor edit = pref.edit();



            edit.putString("TrendNr",TrendNr);
            edit.putString("TrendDate",TrendDate);
            edit.putString("TrendTime",TrendTime);
            edit.putString("Balance",Balance);
            edit.putString("AccTypeId",AccTypeId);






            edit.commit();


        }*/




    }

    public void setUserSession(Account account, AccType accType, User user){

        SharedPreferences pref = getSharedPreferences("MyPref",context.MODE_PRIVATE);

        SharedPreferences.Editor edit = pref.edit();

        edit.putString("AccNr",account.getAccountNr());
        edit.putString("PinNr",account.getPinNumber());
        edit.putString("CardNr",account.getCardNumber());
        edit.putString("IdNr",account.getIDNumber());
        edit.putString("AccType",accType.getAccTypeDesc());
        edit.putString("Username",user.getUsername());
        edit.putString("Password",user.getPassword());

        edit.commit();


    }

}
