package com.example.gebeya_mood.Auths.users;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
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
    public String teamname;  // type on api

    @NonNull
    public String gender;

    @NonNull
    public String password;
    @NonNull

    public String role;

    @Ignore
    public User(String username, String email, String teamname, String gender, String password, String role) {
        this.username = username;
        this.email = email;
        this.teamname = teamname;
        this.gender = gender;
        this.password = password;
        this.role = role;
    }


    public User(){
        this.username = username;
        this.email = email;
        this.teamname = teamname;
        this.gender = gender;
        this.password = password;
        this.role = role;
    }

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
    public String getTeamName() {
        return teamname;
    }

    public void setTeamName(@NonNull String team) {
        this.teamname = team;
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

    @NonNull
    public String getRole() {
        return role;
    }

    public void setRole(@NonNull String role) {
        this.role = role;
    }
}
