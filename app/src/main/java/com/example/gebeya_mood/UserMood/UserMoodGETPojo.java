package com.example.gebeya_mood.UserMood;


import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserMoodGETPojo implements Serializable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("userPojoHelper")
    @Expose
    private UserPojoHelper userPojoHelper;
    @SerializedName("reason")
    @Expose
    private Reason reason;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    private final static long serialVersionUID = -274912712243468621L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserMoodGETPojo withId(String id) {
        this.id = id;
        return this;
    }

    public UserPojoHelper getUserPojoHelper() {
        return userPojoHelper;
    }

    public void setUserPojoHelper(UserPojoHelper userPojoHelper) {
        this.userPojoHelper = userPojoHelper;
    }

    public UserMoodGETPojo withUser(UserPojoHelper userPojoHelper) {
        this.userPojoHelper = userPojoHelper;
        return this;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public UserMoodGETPojo withReason(Reason reason) {
        this.reason = reason;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserMoodGETPojo withValue(String value) {
        this.value = value;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserMoodGETPojo withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public UserMoodGETPojo withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

}