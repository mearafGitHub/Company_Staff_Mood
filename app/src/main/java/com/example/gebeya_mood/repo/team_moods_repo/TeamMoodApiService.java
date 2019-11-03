package com.example.gebeya_mood.repo.team_moods_repo;

import com.example.gebeya_mood.pojos.TeamMoodPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeamMoodApiService {

    // base url: https://stark-peak-15799.herokuapp.com/

    // POST https://stark-peak-15799.herokuapp.com/team-moods

    // GET https://stark-peak-15799.herokuapp.com/team-moods/search

    // PUT https://stark-peak-15799.herokuapp.com/team-moods/:id

    @GET("team-moods")
    Call<List<TeamMoodPojo>> getTeamMoods();

    @GET("moods{mooId}")
    Call <TeamMoodsDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<TeamMoodsDto>> getUserMood(@Path("userId") String userId);


}
