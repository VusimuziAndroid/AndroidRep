package com.example.abvn237.myapplication;

import java.util.Date;

/**
 * Created by ABVN237 on 4/4/2016.
 */

//The class for receiving values from the Accounts table
public class Account {

    //declaring variables

    private String AccountNr;
    private String CardNumber;
    private String PinNumber;
    private String DateOpened;
    private String AccTypeId;
    private String IDNumber;


    //The constructor
  /*  public Account(String accountNr,String cardNumber, String pinNumber,String dateOpened){

        this.AccountNr = accountNr;
        this.CardNumber = cardNumber;
        this.PinNumber = pinNumber;
        this.DateOpened = dateOpened;

    }*/

    //The method for setting values
    public void setAccount(String accountNr, String cardNr, String pinNumber, String DateOpened, String accTypeId){

        this.AccountNr = accountNr;
        this.CardNumber = cardNr;
        this.PinNumber = pinNumber;
        this.DateOpened = DateOpened;
        this.AccTypeId = accTypeId;


      //  DateOpened = dateOpened;
    }

    public void setAccountNr(String accountNr){

        this.AccountNr = accountNr;
    }

    public void setCardNumber(String cardNumber){
        this.CardNumber = cardNumber;
    }

    public void setPinNumber(String pinNumber){
        this.PinNumber = pinNumber;
    }

    public void setDateOpened(String dateOpened){
        this.DateOpened = dateOpened;
    }

    public void setAccTypeId(String accTypeId){
        this.AccTypeId = accTypeId;
    }

    public void setIDNumber(String IdNumber){
        this.IDNumber = IdNumber;
    }

    //The method for returning the Account Number
    public String getAccountNr(){
        return this.AccountNr;
    }


    //The method for returning the Card Number
    public String getCardNumber(){

        return CardNumber;
    }

    //The method for returning the Pin Number
    public String getPinNumber(){
        return this.PinNumber;
    }


    //The method for returning the Date Opened
    public String getDateOpened(){
        return DateOpened;
    }

    public String getAccTypeId() { return AccTypeId; }

    public String getIDNumber(){
        return IDNumber;
    }


}
