package com.example.gebeya_mood.moods;

public class Mood {
    String emotion, date, userId;

    public Mood(){}

    public Mood(String emotion, String date, String userId) {
        this.emotion = emotion;
        this.date = date;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
