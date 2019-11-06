package com.example.gebeya_mood.Auths;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.Auths.users.UserApiService;
import com.example.gebeya_mood.Auths.users.UserDao;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserViewModel extends AndroidViewModel {
    private static UserViewModel userViewModel;
    public Retrofit retrofit;
    public UserDao dao;
    private MutableLiveData<SingUpPojo> signUpAllResponse;
    private MutableLiveData<UserResponse> signUpRespones;
    public MutableLiveData<List<User>> users;
    public MutableLiveData<UserResponse> loginRespones;
    public static Application application;

    public UserViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        signUpRespones = new MutableLiveData<>();
        loginRespones = new MutableLiveData<>();
    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }

    public synchronized UserViewModel getInstance(){
        if(userViewModel == null){
            userViewModel = new UserViewModel(application);
        }
        return userViewModel;
    }

    public UserApiService getUserService(){
        return retrofit.create(UserApiService.class);
    }

    public void createUser(JsonObject userinfo){
        UserApiService userService = getUserService();
        userService.createUser(userinfo).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                try{
                    signUpRespones.setValue(response.body());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
            }
        });
    }

    public MutableLiveData<UserResponse> getSignUpRespones() {
        return signUpRespones;
    }

    public void loginUser(JsonObject userinfo){
        UserApiService userService=retrofit.create(UserApiService.class);
        userService.logIn(userinfo).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                loginRespones.setValue(response.body());
                Log.e("Login Response", String.valueOf(response.body()));
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
            }
        });
    }

    public MutableLiveData<UserResponse> getLoginRespones() {
        return loginRespones;
    }

}
