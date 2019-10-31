package com.example.gebeya_mood.repo.user_moods_repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserMoodApiService {

    // base url: https://stark-peak-15799.herokuapp.com/

    @POST("users")
    Call<UserMoodsDto> signUp();

    @POST("users/login")
    Call<UserMoodsDto> logIn();

    @POST("users/profile")
    Call<UserMoodsDto> userMoodPost();



    @GET("moods")
    Call<List<UserMoodsDto>> getMoods();

    @GET("moods{mooId}")
    Call <UserMoodsDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<UserMoodsDto>> getUserMood(@Path("userId") String userId);


}
