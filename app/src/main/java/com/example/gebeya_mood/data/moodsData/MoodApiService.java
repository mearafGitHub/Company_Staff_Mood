package com.example.gebeya_mood.data.moodsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface MoodApiService {

    @GET("moods")
    Call<List<MoodsDto>> getMoods();

    @GET("moods{mooId}")
    Call <MoodsDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<MoodsDto>> getUserMood(@Path("userId") String userId);

}
