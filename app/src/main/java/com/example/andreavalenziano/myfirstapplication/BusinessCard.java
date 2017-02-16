package com.example.andreavalenziano.myfirstapplication;

/**
 * Created by AndreaValenziano on 15/02/17.
 */

public class BusinessCard {

    String name, email, phoneNumber,course,address;

    public BusinessCard(String name,String email, String phoneNumber,String course,String address){
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



}