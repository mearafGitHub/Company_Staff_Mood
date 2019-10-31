package com.example.gebeya_mood.repo.team_moods_repo;

import com.example.gebeya_mood.models.TeamMood;
import com.example.gebeya_mood.models.UserMood;

import java.util.ArrayList;
import java.util.List;

public class TeamMoodTransformer {

    public static TeamMood DtoToMood(TeamMoodsDto teamMoodsDto){

        /*
    @PrimaryKey
    @NonNull
    public String teamId;

    @NonNull
    public String emotion;

    @NonNull
    public String teamName;

    @NonNull
    public String teamTotal; // total number of members

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

*/

        TeamMood teamMood = new TeamMood();
        teamMood.teamId = teamMoodsDto.getTeamId();
        teamMood.emotion = teamMoodsDto.getEmotion();
        teamMood.teamName = teamMoodsDto.getTeamName();
        teamMood.date = teamMoodsDto.getDate();

        return teamMood;
    }


    public static List<TeamMood> ListDtoToMood(List<TeamMoodsDto> listTeamMoosDto){

        List<TeamMood> teamMoods = new ArrayList<TeamMood>();

        for(TeamMoodsDto teamMoodsDto : listTeamMoosDto){

            teamMoods.add(DtoToMood(teamMoodsDto));
        }

        return teamMoods;
    }
}
