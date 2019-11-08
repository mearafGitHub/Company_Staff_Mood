package com.example.gebeya_mood.Auths.users;

import com.example.gebeya_mood.Auths.UserProfilePojo;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

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


    @POST("users")
    Call<UserResponse> createUser(@Body JsonObject object);

    @POST("users/login")
    Call<UserResponse> logIn(@Body JsonObject object);

    @GET("users/profile")
    Call<UserProfilePojo> userProfile();



}
