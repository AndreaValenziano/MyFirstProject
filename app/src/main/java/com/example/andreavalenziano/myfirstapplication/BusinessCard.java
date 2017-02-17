package com.example.andreavalenziano.myfirstapplication;

/**
 * Created by AndreaValenziano on 15/02/17.
 */

public class BusinessCard {

    String name, email, phoneNumber,course,address;
    static int id=0;

    public BusinessCard(String name,String email, String phoneNumber,String course,String address){
        id++;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.course = course;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCourse() {
        return course;
    }

    public String getAddress() {
        return address;
    }

    public int getId(){return id;}


    public void setName(String name) {
        this.name = name;
    }
}