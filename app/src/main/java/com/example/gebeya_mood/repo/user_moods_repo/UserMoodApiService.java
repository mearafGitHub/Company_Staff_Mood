package com.example.gebeya_mood.repo.user_moods_repo;

import com.example.gebeya_mood.pojos.MoodPojo;
import com.example.gebeya_mood.pojos.TeamMoodPojo;
import com.example.gebeya_mood.pojos.UserMoodGETPojo;
import com.example.gebeya_mood.pojos.UserResponse;
import com.example.gebeya_mood.repo.users.UserDto;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserMoodApiService {

    // base url:

    // GET https://stark-peak-15799.herokuapp.com/moods/choices

    // POST https://stark-peak-15799.herokuapp.com/moods

    //GET https://stark-peak-15799.herokuapp.com/moods/my-mood-count

    // GET https://stark-peak-15799.herokuapp.com/moods/count

    //GET https://stark-peak-15799.herokuapp.com/moods/search

    // GET https://stark-peak-15799.herokuapp.com/moods/my-logs

    @POST("moods")
    Call<UserMoodGETPojo> postUserMood(@Body JsonObject userMood);



    @GET("moods")
    Call<List<MoodPojo>> getMoods();

    @GET("moods/my-logs{userId}")
    Call <List<UserMoodGETPojo>> getOneUserMoods(@Path("moodId") String moodId);

    @GET("moods")
    Call<List<UserMoodGETPojo>> getAllUsersMoods();


}
