package com.example.gebeya_mood.Auths.register;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.Auths.users.UserResponse;
import com.example.gebeya_mood.Auths.users.User;
import com.example.gebeya_mood.Auths.users.UserApiService;
import com.example.gebeya_mood.Auths.users.UserDao;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SingUpViewModel extends AndroidViewModel {
    private static SingUpViewModel singUpViewModel;
    public Retrofit retrofit;
    public UserDao dao;
    private MutableLiveData<SingUpPojo> signUpAllResponse;
    private MutableLiveData<UserResponse> signUpRespones;
    public MutableLiveData<List<User>> users;

    public static Application application;

    public SingUpViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        signUpRespones = new MutableLiveData<>();
    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }

    public synchronized SingUpViewModel getInstance(){
        if(singUpViewModel == null){
            singUpViewModel = new SingUpViewModel(application);
        }
        return singUpViewModel;
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

}
