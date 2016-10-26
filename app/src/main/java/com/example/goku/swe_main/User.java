package com.example.goku.swe_main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

/**
 * Created by goku on 24/10/16.
 */

public class User {
   private String name;
    private String password;
    private String email;
    private String username ;

    SharedPreferences sharedpreferences;

    public User(Context context) {
        sharedpreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        sharedpreferences.edit().putString("email",email);
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return sharedpreferences.getString("username",null);
        //return username;
    }

    public void setUsername(String username) {
        sharedpreferences.edit().putString("username", username).commit();
        //this.username = username;
    }





}
