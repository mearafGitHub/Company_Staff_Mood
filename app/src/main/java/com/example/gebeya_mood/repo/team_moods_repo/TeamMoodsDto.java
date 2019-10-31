package com.example.gebeya_mood.repo.team_moods_repo;

import com.google.gson.annotations.Expose;

public class TeamMoodsDto {

    @Expose
    public String teamId;

    @Expose
    public String emotion;

    @Expose
    public String teamName;

    @Expose
    public String teamTotal;

    @Expose
    public String date;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamTotal() {
        return teamTotal;
    }

    public void setTeamTotal(String teamTotal) {
        this.teamTotal = teamTotal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
