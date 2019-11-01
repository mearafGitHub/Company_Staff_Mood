package com.example.gebeya_mood.repo.user_moods_repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserMoodApiService {

    // base url: https://stark-peak-15799.herokuapp.com/

    @FormUrlEncoded
    @POST("users")
    Call<UserMoodsDto> signUp(
            @Field("email")String email,
            @Field("password")String password,
            @Field("username")String username,
            @Field("team")String team,
            @Field("gender")String gender
            );

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
