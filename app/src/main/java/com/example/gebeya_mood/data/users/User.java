package com.example.gebeya_mood.data.users;

public class  User {

    public String username;
    public String email;
    public String id;
    public String team;
    public String gender;
    public String mood;

   public User(){}

    public User(String username, String email, String id, String team, String gender, String mood) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.team = team;
        this.gender = gender;
        this.mood = mood;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
