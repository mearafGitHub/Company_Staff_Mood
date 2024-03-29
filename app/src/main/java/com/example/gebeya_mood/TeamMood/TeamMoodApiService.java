package com.example.gebeya_mood.TeamMood;

import com.example.gebeya_mood.Mood.MoodsCountPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeamMoodApiService {

    // POST https://stark-peak-15799.herokuapp.com/team-moods

    // GET https://stark-peak-15799.herokuapp.com/team-moods/search

    // PUT https://stark-peak-15799.herokuapp.com/team-moods/:id
    // GET https://stark-peak-15799.herokuapp.com/moods/count

    @GET("team-moods")
    Call<List<TeamMoodPojo>> getAllTeamMoods();

    @GET("team-moods/search{team}{date}")
    Call<List<TeamMoodPojo>> getAllTeamMoodsFilterd(@Path("teamId") String team,@Path("teamId") String date );

    @GET("team-moods{teamId}")
    Call <List<TeamMoodPojo>> getOneTeamMoods(@Path("teamId") String teamId);


}