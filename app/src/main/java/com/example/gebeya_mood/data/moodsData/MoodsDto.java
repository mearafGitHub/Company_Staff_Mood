package com.example.gebeya_mood.data.moodsData;

import com.google.gson.annotations.Expose;

public class MoodsDto {

    @Expose
    private String emotion;

    @Expose
    private String moodId;

    @Expose
    private String date;

    @Expose
    private String userId;


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
