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

    @FormUrlEncoded
    @POST("users")
    Call<SingUpPojo> signUp(@Body User user);
   /* Call<SingUpPojo> signUp(
            @Field("username")String username,
            @Field("email")String email,
            @Field("password")String password,
            @Field("type")String type,
            @Field("sex")String sex
    );*/

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginPojo> logIn(
            @Field("email")String email,
            @Field("password")String password
    );

    @GET("users/profile")
    Call<UserProfilePojo> userProfile();

    @GET("moods")
    Call<List<UserDto>> getMoods();

    @GET("moods{mooId}")
    Call <UserDto> getMood(@Path("moodId") String moodId);

    @GET("moods{userId}")
    Call <List<UserDto>> getUserMood(@Path("userId") String userId);


}
