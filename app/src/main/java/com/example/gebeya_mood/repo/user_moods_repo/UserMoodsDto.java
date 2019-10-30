package com.example.gebeya_mood.repo.user_moods_repo;

import com.google.gson.annotations.Expose;

public class UserMoodsDto {

    @Expose
    public String emotion;

    @Expose
    public String moodId;

    @Expose
    public String date;

    @Expose
    public String userId;

    @Expose
    public String reason;


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
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
