package com.example.mobileapp.sharedpreferencepb4;

/**
 * Created by Mobile App on 2/17/2018.
 */

public class User {
    private String userEmail;
    private String userPassword;

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
