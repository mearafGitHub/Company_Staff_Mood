package com.example.gebeya_mood.repo.users;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.UserProfilePojo;
import com.example.gebeya_mood.pojos.UserResponse;
import com.google.gson.JsonObject;

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


    @POST("users")
    Call<UserResponse> createUser(@Body JsonObject object);


    @POST("users")
    Call<SingUpPojo> signUp(@Body JsonObject object);

    @POST("users/login")
    Call<LoginPojo> logIn(@Body JsonObject object);

    @GET("users/profile")
    Call<UserProfilePojo> userProfile();



}
