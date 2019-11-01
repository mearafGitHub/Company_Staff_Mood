package com.example.gebeya_mood.repo.users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApiService {

    // base url: https://stark-peak-15799.herokuapp.com/

    @FormUrlEncoded
    @POST("users")
    Call<UserDto> signUp(
            @Field("username")String username,
            @Field("email")String email,
            @Field("password")String password,
            @Field("type")String team,
            @Field("sex")String gender
    );

    @FormUrlEncoded
    @POST("users/login")
    Call<UserDto> logIn(
            @Field("email")String email,
            @Field("password")String password
    );

    @POST("users/profile")
    Call<UserDto> userMoodPost();

    @GET("moods")
    Call<List<UserDto>> getMoods();

    @GET("moods{mooId}")
    Call <UserDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<UserDto>> getUserMood(@Path("userId") String userId);


}
