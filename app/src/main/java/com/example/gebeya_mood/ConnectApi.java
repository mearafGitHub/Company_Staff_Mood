package com.example.gebeya_mood;

import com.example.gebeya_mood.data.moodsData.Mood;
import com.example.gebeya_mood.data.users.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectApi {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("moods")
    Call<List<Mood>> getMoods();
}
