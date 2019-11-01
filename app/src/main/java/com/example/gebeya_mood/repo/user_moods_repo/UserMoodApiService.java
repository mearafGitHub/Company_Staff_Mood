package com.example.gebeya_mood.repo.user_moods_repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserMoodApiService {

    // base url:

    @POST("users")
    Call<UserMoodsDto> createUser();

    @GET("moods")
    Call<List<UserMoodsDto>> getMoods();

    @GET("moods{mooId}")
    Call <UserMoodsDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<UserMoodsDto>> getUserMood(@Path("userId") String userId);

}
