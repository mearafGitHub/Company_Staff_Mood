package com.example.gebeya_mood.repo.team_moods_repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TeamMoodApiService {

    // base url: https://stark-peak-15799.herokuapp.com/

    @POST("users")
    Call<TeamMoodsDto> signUp();

    @POST("users/login")
    Call<TeamMoodsDto> logIn();

    @POST("users/profile")
    Call<TeamMoodsDto> userMoodPost();



    @GET("moods")
    Call<List<TeamMoodsDto>> getMoods();

    @GET("moods{mooId}")
    Call <TeamMoodsDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<TeamMoodsDto>> getUserMood(@Path("userId") String userId);


}
