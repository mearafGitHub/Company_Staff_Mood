package com.example.gebeya_mood.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserPojoHelper")
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


    public User(String username, String email, String team, String gender, String password) {
        this.username = username;
        this.email = email;
        this.team = team;
        this.gender = gender;
        this.password = password;

    }
    @Ignore
    public User( String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Ignore
    public User(){}

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getTeam() {
        return team;
    }

    public void setTeam(@NonNull String team) {
        this.team = team;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
