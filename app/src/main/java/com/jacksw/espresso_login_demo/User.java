package com.jacksw.espresso_login_demo;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    String username;
    @SerializedName("password")
    String password;

    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
