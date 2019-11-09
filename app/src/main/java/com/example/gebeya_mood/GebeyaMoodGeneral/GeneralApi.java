package com.example.gebeya_mood.GebeyaMoodGeneral;

import com.example.gebeya_mood.Mood.MoodsCountPojo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GeneralApi {

    @GET("moods/count")
    Call<MoodsCountPojo> getGeneralMood();

}
