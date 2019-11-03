package com.example.gebeya_mood.repo.team_moods_repo;

import com.example.gebeya_mood.models.TeamMood;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.pojos.TeamMoodPojo;

import java.util.ArrayList;
import java.util.List;

public class TeamMoodTransformer {

    public static TeamMood toTeamModel(TeamMoodPojo teamPojo){

        TeamMood teamMood = new TeamMood();
        teamMood.teamId = teamPojo.getId();
        teamMood.emotion = teamPojo.getMood();
        teamMood.teamName = teamPojo.getName();
        teamMood.date = teamPojo.getDateModified();

        return teamMood;
    }


    public static List<TeamMood> toTeamModelList(List<TeamMoodPojo> listTeamPojo){

        List<TeamMood> teamMoods = new ArrayList<TeamMood>();

        for(TeamMoodPojo singleTeamPojo : listTeamPojo){

            teamMoods.add(toTeamModel(singleTeamPojo));
        }

        return teamMoods;
    }
}
