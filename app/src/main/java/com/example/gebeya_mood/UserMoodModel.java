package com.example.gebeya_mood;

public class UserMoodModel {

    String userId, userName, emotion, date;

    public UserMoodModel(String userId, String userName, String emotion, String date) {
        this.userId = userId;
        this.userName = userName;
        this.emotion = emotion;
        this.date = date;
    }

    public String getUserId() {
        return userId;
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
