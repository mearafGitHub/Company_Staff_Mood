package com.example.gebeya_mood.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class  User {

    @PrimaryKey
    @NonNull
    public String userId;

    @NonNull
    public String username;

    @NonNull
    public String email;

    @NonNull
    public String team;  // type on api

    @NonNull
    public String gender;

    @NonNull
    public String password;


   /* public User(String username, String email, String team, String gender, String password) {
        this.username = username;
        this.email = email;
        this.team = team;
        this.gender = gender;
        this.password = password;
    }*/

}
