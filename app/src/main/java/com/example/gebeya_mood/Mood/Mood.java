package com.example.gebeya_mood.Mood;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class Mood implements Serializable
{

    @SerializedName("Happy")
    @Expose
    private Integer happy;
    @SerializedName("Content")
    @Expose
    private Integer content;
    @SerializedName("Neutral")
    @Expose
    private Integer neutral;
    @SerializedName("Sad")
    @Expose
    private Integer sad;
    @SerializedName("Angry")
    @Expose
    private Integer angry;
    private final static long serialVersionUID = -9188099835435061668L;

    public Integer getHappy() {
        return happy;
    }

    public void setHappy(Integer happy) {
        this.happy = happy;
    }

    public Mood withHappy(Integer happy) {
        this.happy = happy;
        return this;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Mood withContent(Integer content) {
        this.content = content;
        return this;
    }

    public Integer getNeutral() {
        return neutral;
    }

    public void setNeutral(Integer neutral) {
        this.neutral = neutral;
    }

    public Mood withNeutral(Integer neutral) {
        this.neutral = neutral;
        return this;
    }

    public Integer getSad() {
        return sad;
    }

    public void setSad(Integer sad) {
        this.sad = sad;
    }

    public Mood withSad(Integer sad) {
        this.sad = sad;
        return this;
    }

    public Integer getAngry() {
        return angry;
    }

    public void setAngry(Integer angry) {
        this.angry = angry;
    }

    public Mood withAngry(Integer angry) {
        this.angry = angry;
        return this;
    }

}