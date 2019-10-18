package com.example.gebeya_mood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersFromApi {

    @GET("users")
    Call<List<User>> getUsers();
}
