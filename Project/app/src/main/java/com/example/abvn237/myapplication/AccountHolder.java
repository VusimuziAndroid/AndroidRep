package com.example.abvn237.myapplication;

/**
 * Created by ABVN237 on 4/4/2016.
 */
//The method for setting and returning values from the database
public class AccountHolder {

    //declaring the variables for the class
    private String AccountHolderId;
    private String AccountHolderName;
    private String AccountHolderSurname;
    private String Address;
    private String IDNumber;
    private String AccountNumber;
    private String UserId;

    //The constructor method for the Account Holder class

  /*  public AccountHolder(String accountHolderId,String accountHolderName, String accountHolderSurname, String address, String idNumber, String accountNumber, String userId){

        this.AccountHolderId=accountHolderId;
        this.AccountHolderName=accountHolderName;
        this.AccountHolderSurname=accountHolderSurname;
        this.Address=address;
        this.IDNumber=idNumber;
        this.AccountNumber=accountNumber;
        this.UserId=userId;
    }*/


    //The method for setting the values for the Account Holder class
    public AccountHolder()
    {


    }

    //The method for setting the values for the Account Holder class
    public AccountHolder(String AccHolderId,String accountHolderName, String accountHolderSurname, String address, String idNumber,String accNr)
    {

        this.AccountHolderId=AccHolderId;
        this.AccountHolderName=accountHolderName;
        this.AccountHolderSurname=accountHolderSurname;
        this.Address=address;
        this.IDNumber=idNumber;
        this.AccountNumber=accNr;

    }

    public void setAccountHolderName(String accountHolderName){

        this.AccountHolderName=accountHolderName;
    }

    public void setAccountNumber(String accountNumber){

        this.AccountNumber = accountNumber;
    }

    public void setAccountHolderSurname(String accountHolderSurname){

        this.AccountHolderSurname=accountHolderSurname;
    }

    public void setAddress(String address){
        this.Address = address;
    }

    public void setIDNumber(String idNumber){
       this.IDNumber = idNumber;
    }

    //The method for returning the Account Holder Id
    public String getAccountHolderId(){

        return this.AccountHolderId;
    }

    //The method for returning the Account Holder name
    public String getAccountHolderName()
    {
        return this.AccountHolderName;
    }

    //The method for returning the Account Holder Surname
    public String getAccountHolderSurname()
    {
        return this.AccountHolderSurname;
    }

    public String getAddress()
    {
        return this.Address;
    }

    public String getIDNumber()
    {
        return this.IDNumber;
    }
    public String getAccountNumber()
    {
        return this.AccountNumber;
    }
    public String UserId()
    {
        return this.UserId;
    }

}
