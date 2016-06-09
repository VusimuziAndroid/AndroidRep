package com.example.abvn237.myapplication;

/**
 * Created by Vusi Ngwenya on 4/6/2016.
 */
public class ChatMessages {

    private String Chat_Id;
    private String Chat_Message;
    private String Chat_Date;
    private String Username;

    public ChatMessages(String ChatMessage, String ChatDate){

    //    this.Chat_Id=ChatId=ChatId;
        this.Chat_Message=ChatMessage;
        this.Chat_Date=ChatDate;
      //  this.Username =userName;

    }

    public String getChatId(){

        return Chat_Id;
    }

    public String getChatMessage(){

        return Chat_Message;
    }

    public String getChatDate(){

        return Chat_Date;
    }

    public String getUsername(){

        return Username;
    }


}
