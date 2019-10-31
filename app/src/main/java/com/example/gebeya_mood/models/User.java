package com.example.gebeya_mood.models;

public class  User {
    public String userId;
    public String username;
    public String email;
    public String team;  // type on api
    public String gender;




    public User(String username, String email, String team, String gender) {
        this.username = username;
        this.email = email;
        this.team = team;
        this.gender = gender;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
