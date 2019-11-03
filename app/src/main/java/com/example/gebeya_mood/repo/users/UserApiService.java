package com.example.gebeya_mood.repo.users;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.UserProfilePojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApiService {

    //GET https://stark-peak-15799.herokuapp.com/users/profile

    // POST https://stark-peak-15799.herokuapp.com/users/login

    // PUT https://stark-peak-15799.herokuapp.com/users/profile

    // POST https://stark-peak-15799.herokuapp.com/users

    // GET https://stark-peak-15799.herokuapp.com/users/types

    // GET https://stark-peak-15799.herokuapp.com/users/search

    // GET https://stark-peak-15799.herokuapp.com/users/:id

    // GET https://stark-peak-15799.herokuapp.com/moods/my-logs

    // GET https://stark-peak-15799.herokuapp.com/moods/my-mood-count



    @FormUrlEncoded
    @POST("users")
    Call<SingUpPojo> signUp(
            @Field("name")String name,
            @Field("email")String email,
            @Field("password")String password,
            @Field("team")String team,
            @Field("sex")String gender
    );

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginPojo> logIn(
            @Field("email")String email,
            @Field("password")String password
    );

    @GET("users/profile")
    Call<UserProfilePojo> userProfile();



}
