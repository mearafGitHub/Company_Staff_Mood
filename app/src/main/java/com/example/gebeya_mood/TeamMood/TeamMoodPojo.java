
package com.example.gebeya_mood.TeamMood;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamMoodPojo implements Serializable
{
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("mood")
    @Expose
    private String mood;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    private final static long serialVersionUID = 4715277001752200738L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TeamMoodPojo withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamMoodPojo withName(String name) {
        this.name = name;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public TeamMoodPojo withTotal(String total) {
        this.total = total;
        return this;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public TeamMoodPojo withMood(String mood) {
        this.mood = mood;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TeamMoodPojo withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public TeamMoodPojo withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

}