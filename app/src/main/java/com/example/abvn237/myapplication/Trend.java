package com.example.abvn237.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.SmsManager;

import java.text.SimpleDateFormat;

/**
 * Created by ABVN237 on 4/4/2016.
 */
//The class for setting and returning values from the database
public class Trend {

   private String TrendNumber;
   private String TrendDate;
   private String TrendTime;
   private String Amount;
   private String AccTypeId;
   private String AccountNumber;
   private String Balance;
    private String percentage;
    private String purchaseAmount;
    private String TotalAmount;
    private String Vat;
    private String newPercentage;
    private String newAmountSpent;
    DatabaseHelper myDB;
    SQLiteDatabase db;



    //The constructor for the Trend class
    public Trend(String trendDate, String trendTime, String balance,String accountNumber,String vat){

     //   this.TrendNumber=trendNumber;
        this.TrendDate=trendDate;
        this.TrendTime=trendTime;
        this.Balance=balance;
        this.AccountNumber=accountNumber;
        this.Vat=vat;
    }

    //The method for setting the values to the Trend class
  /*  public void setTrend(String trendDate,String trendTime, String balance,String amount){


        this.TrendDate=trendDate;
        this.TrendTime=trendTime;
        this.Balance=balance;
        this.Amount=amount;

    }*/

    public void setTrendDate(String trendDate){
        this.TrendDate=trendDate;
    }

    public void setTrendTime(String trendTime){
        this.TrendTime=trendTime;
    }

    public void setBalance(String balance){
        this.Balance=balance;
    }

    public void setAmount(String amount){
        this.Amount=amount;
    }
    public void setPercentage(String Percentage){
        this.percentage = Percentage;
    }

    public void setPurchaseAmount(String PurchaseAmount){

        this.purchaseAmount = PurchaseAmount;

    }

    public String getTime(long time){

        SimpleDateFormat sdf10 = new SimpleDateFormat("MMM MM dd,yyyy h:mm a");
        String dateTime5 = sdf10.format(time);

        return dateTime5;

    }

    public void getTrendInformation(String currentAmt,String transDate,String transTime,String AccNr, String balance) {

        double finalAmount, previousAmount = 0,vat=1.14, currentAmount, InterestRates = 10.5;

        String strVAT = Double.toString(vat);




        Trend trend = new Trend(transDate, transTime, balance,AccNr,strVAT);

        Cursor c = myDB.getTrends(trend.getTrendDate(), trend.getTrendTime(), trend.getBalance(), trend.getAccountNumber(), db);

        while (c.moveToNext()) {


            String TrendNr = c.getString(0);
            String TrendDate = c.getString(1);
            String TrendTime = c.getString(2);
            String Amount = c.getString(3);
            String accNr = c.getString(4);

            previousAmount = Double.parseDouble(Amount.toString());
            currentAmount = Double.parseDouble(currentAmt.toString());


            finalAmount = (currentAmount + previousAmount) + InterestRates;


            String strAmount = Double.toString(finalAmount);



           // myDB.addTransaction(trend.getTrendDate(), trend.getTrendTime(), trend.getBalance(),trend, db);





        }
    }

    public String getTotalAmount(String strVat,String strBalance){

       // double vat = Double.parseDouble(strVat);
        double vat = 25.0;
       // double balance = Double.parseDouble(strBalance);
        double balance = 350.0;
        double totalAmount = vat*balance+vat;

        String strTotalAmount= Double.toString(totalAmount);

        return strTotalAmount;


    }
    public String getDate(long date){

        SimpleDateFormat sdf11 = new SimpleDateFormat("MMM MM dd,yyyy ");
        String dateString5 = sdf11.format(date);

        return dateString5;

    }



    public void sendSMSNotification(){

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("0726882993",null,"The amount was deposited in your account",null,null);
    }


    public void setAccountNumber(String accountNumber){
        this.AccountNumber=accountNumber;
    }

    //The method for returning the Trend Number
    public String getTrendNumber(){
        return TrendNumber;
    }

    //The method for returning the Trend Date
    public String getTrendDate(){

        return TrendDate;
    }

    public String getPurchaseAmount(){

        return purchaseAmount;
    }
    //The method for returning the Trend Time
    public String getTrendTime(){

        return TrendTime;
    }

    //The method for returning the amount
    public String getAmount(){
        return Amount;
    }

    //The method for returning the AccTypeId
    public String getAccTypeId(){

        return AccTypeId;
    }

    //The method for returning the Account Number
    public String getAccountNumber(){

        return AccountNumber;
    }

    public String getBalance(){

        return Balance;
    }

    public String getVAT(){

        return this.Vat;
    }
}
