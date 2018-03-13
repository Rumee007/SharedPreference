package com.example.mobileapp.sharedpreferencepb4;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Mobile App on 2/17/2018.
 */

public class UserPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static final String USER_EMAIL = "user_email";
    private static final String USER_PASSWORD = "user_password";
    private static final String DEFAULT = "no record found";

    public UserPreferences(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("user_info",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String saveUserInfo(String email, String pass){
        editor.putString(USER_EMAIL,email);
        editor.putString(USER_PASSWORD,pass);
        editor.commit();
        return "info saved";
    }

    public String getUserEmail(){
        return sharedPreferences.getString(USER_EMAIL,DEFAULT);
    }
    public String getUserPassword(){
        return sharedPreferences.getString(USER_PASSWORD,DEFAULT);
    }
    public String resetUserInfo(){
        editor.clear();
        editor.commit();
        return "info cleared";
    }

    public String saveUserObject(User user){
        Gson gson = new Gson();
        String userString = gson.toJson(user);
        editor.putString("user",userString);
        editor.commit();
        return "saved";
    }

    public User getUserObject(){
        Gson gson = new Gson();
        String userString = sharedPreferences.getString("user","no user record found");
        return gson.fromJson(userString,User.class);
    }
}
