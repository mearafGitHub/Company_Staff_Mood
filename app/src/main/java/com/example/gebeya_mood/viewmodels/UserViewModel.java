package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodTransformer;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;
import com.example.gebeya_mood.repo.users.UserApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserViewModel extends AndroidViewModel {
    private static final String BaseUrl = "https://stark-peak-15799.herokuapp.com/";
    private static UserViewModel userMoodViewModel;
    private static Application application;
    public Retrofit retrofit;
    public UserMoodDao dao;
    public MutableLiveData<List<UserMood>> moods;



    public UserViewModel(@NonNull Application application) {
        super(application);
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moods = new MutableLiveData<>(new ArrayList<>());

        //loadUserMoods();
    }

    private void loadUserMoods(){
        List<UserMood> moodsDb = dao.getAll();
        if (moodsDb.isEmpty()){
            userMoodsFromApi();
        }
        else{
            moods.setValue(moodsDb);
        }
    }

    private void userMoodsFromApi(){

        UserMoodApiService userMoodApiService = retrofit.create(UserMoodApiService.class);
        userMoodApiService.getMoods().enqueue(new Callback<List<UserMoodsDto>>() {
            @Override
            public void onResponse(Call<List<UserMoodsDto>> call, Response<List<UserMoodsDto>> response) {
                List<UserMood> moodsApi = UserMoodTransformer.ListDtoToMood(response.body());
                dao.addMoods(moodsApi);
                moods.setValue(moodsApi);
            }

            @Override
            public void onFailure(Call<List<UserMoodsDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<UserMood>> getMoods(){
        return moods;
    }

    public static synchronized UserViewModel getInstance(){
        if(userMoodViewModel == null){
            userMoodViewModel = new UserViewModel(application);
        }
        return userMoodViewModel;
    }

    public UserApiService getUserService(){
        return retrofit.create(UserApiService.class);
    }
}
