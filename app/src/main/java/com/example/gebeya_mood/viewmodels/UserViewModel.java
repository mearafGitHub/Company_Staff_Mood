package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.UserResponse;
import com.example.gebeya_mood.repo.users.UserApiService;
import com.example.gebeya_mood.repo.users.UserDao;
import com.google.gson.JsonObject;

import java.util.ArrayList;
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
    public MutableLiveData<LoginPojo> loginRespones;
    public Application application;


    public UserViewModel(@NonNull Application application) {
        super(application);

        retrofit =((App)application).getRetrofit();
        signUpRespones = new MutableLiveData<>();
        signUpAllResponse = new MutableLiveData<>();

        users = new MutableLiveData<>(new ArrayList<>());

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
                signUpRespones.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    public void createUserAll(JsonObject userinfo){
        UserApiService userService = getUserService();
        userService.signUp(userinfo).enqueue(new Callback<SingUpPojo>() {
            @Override
            public void onResponse(Call<SingUpPojo> call, Response<SingUpPojo> response) {
                signUpAllResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SingUpPojo> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<UserResponse> getSignUpRespones() {
        return signUpRespones;
    }

    public MutableLiveData<SingUpPojo> getSignUpAllRespones() {
        return signUpAllResponse;
    }

    public MutableLiveData<UserResponse> processSignupResponse(MutableLiveData<UserResponse> response){

        try {

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
        }

        return response;
    }

    public void loginUser(JsonObject userinfo){
        UserApiService userService=retrofit.create(UserApiService.class);
        userService.logIn(userinfo).enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                loginRespones.setValue(response.body());
            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<LoginPojo> getLoginRespones() {
        return loginRespones;
    }

    protected  MutableLiveData<LoginPojo> processLoginResponse(MutableLiveData<LoginPojo> response){

        try {

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }

        return response;
    }

}
