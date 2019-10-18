package com.example.gebeya_mood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersConnectApi {

    @GET("users")
    Call<List<User>> getUsers();
}
