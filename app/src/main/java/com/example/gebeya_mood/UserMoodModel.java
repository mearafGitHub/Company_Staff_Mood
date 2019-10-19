package com.example.gebeya_mood;

public class UserMoodModel {

    String userId, userName, emotion, date, team;
    int emoji;

    public UserMoodModel(String userId, String userName, String emotion, String date, int emoji, String team) {
        this.userId = userId;
        this.userName = userName;
        this.emotion = emotion;
        this.date = date;
        this.emoji = emoji;
        this.team = team;
    }

    public UserMoodModel(String emotion, String date, String team, int emoji) {
        this.emotion = emotion;
        this.date = date;
        this.team = team;
        this.emoji = emoji;
    }


    public int getEmoji() {
        return emoji;
    }

    public void setEmoji(int emoji) {
        this.emoji = emoji;
    }

    public String getUserId() {
        return userId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
