package com.example.abvn237.myapplication;

/**
 * Created by ABVN237 on 4/5/2016.
 */
public class User {

    String UserId;
    String username;
    String password;

    public User(){


    }
    public User(String username, String password){

      //  this.UserId = userId;
        this.username = username;
        this.password = password;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId(){

        return UserId;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){

        return this.password;
    }

}
