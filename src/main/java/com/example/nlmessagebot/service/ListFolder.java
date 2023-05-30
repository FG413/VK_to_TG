package com.example.nlmessagebot.service;

public class ListFolder {
    private String text;
    private int date;
    private String name;

    public ListFolder(String text, String name, int date){
        this.text=text;
        this.name=name;
        this.date=date;
    }

    public String getText() {
        return text;
    }



    public String getName() {
        return name;
    }
    public int getDate() {
        return date;
    }



}
