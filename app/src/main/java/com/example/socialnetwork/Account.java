package com.example.socialnetwork;
public class Account {
    public String email,fullName,birthDay,gender,uID;

    public Account(String email, String fullName, String birthDay, String gender, String uID) {
        this.email = email;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.uID = uID;
    }

    public Account() {
    }
}
