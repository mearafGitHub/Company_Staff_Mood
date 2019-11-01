package com.example.gebeya_mood.viewmodels;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodTransformer;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;
import com.example.gebeya_mood.repo.users.UserApiService;
import com.example.gebeya_mood.repo.users.UserDao;
import com.example.gebeya_mood.repo.users.UserDto;
import com.example.gebeya_mood.repo.users.UserTransformer;
import com.example.gebeya_mood.ui.login.LoginActivity;
import com.example.gebeya_mood.views.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserViewModel extends AndroidViewModel {
    private static final String BaseUrl = "https://stark-peak-15799.herokuapp.com/";
    private static UserViewModel userViewModel;
    private static Application application;
    public Retrofit retrofit;
    public UserDao dao;
    public MutableLiveData<List<User>> users;
    public  Response<UserDto> res;


    public UserViewModel(@NonNull Application application) {
        super(application);
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       users = new MutableLiveData<>(new ArrayList<>());

        //loadUserMoods();
    }

    public UserViewModel() {
        super(application);
    }

    private void loadUser(){
        List<User> usersDb = dao.getAll();
        if (usersDb.isEmpty()){
            userFromApi();
        }
        else{
            users.setValue(usersDb);
        }
    }

    private void userFromApi(){

        UserApiService userApiService = retrofit.create(UserApiService.class);
        userApiService.getMoods().enqueue(new Callback<List<UserDto>>() {
            @Override
            public void onResponse(Call<List<UserDto>> call, Response<List<UserDto>> response) {
                List<User> usersApi = UserTransformer.ListDtoToUserList(response.body());
                dao.addUsers(usersApi);
                users.setValue(usersApi);
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }

    public static synchronized UserViewModel getInstance(){
        if(userViewModel == null){
            userViewModel = new UserViewModel(application);
        }
        return userViewModel;
    }

    public UserApiService getUserService(){
        return retrofit.create(UserApiService.class);
    }


    public Response<UserDto> signUp(String email, String username, String gender, String team, String password){

        Call<UserDto> callSignUp = UserViewModel.getInstance()
                .getUserService()
                .signUp(email, username, gender, team, password);

        callSignUp.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {

                try {
                    res = response;
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });

        return res;
    }

    public Response<UserDto> logIn(String email, String password){

        Call<UserDto> callSignUp = UserViewModel.getInstance()
                .getUserService()
                .logIn(email, password);

        callSignUp.enqueue(new Callback<UserDto>() {
            @Override
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {

                try {
                    res = response;
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                }
            }

            @Override
            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });

        return res;
    }

}
