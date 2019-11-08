package com.example.gebeya_mood.Auths.login;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.users.UserResponse;
import com.example.gebeya_mood.users.UserApiService;
import com.example.gebeya_mood.users.UserDao;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginUserViewModel extends AndroidViewModel {
    public MutableLiveData<UserResponse> loginRespones;
    public Retrofit retrofit;
    public UserDao dao;
    private String checker;
    public String userRole;
    public static Application application;
    public LoginUserViewModel loginUserViewModel;
    public LoginUserViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        loginRespones = new MutableLiveData<>();
    }

    public synchronized LoginUserViewModel getInstance(){
        if(loginUserViewModel == null){
            loginUserViewModel = new LoginUserViewModel(application);
        }
        return loginUserViewModel;
    }

    public  void userInputs(String email, String password){

        JsonObject jsonObject=new JsonObject();;
        jsonObject.addProperty("email",email);
        jsonObject.addProperty("password",password);
        loginUser(jsonObject);


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
