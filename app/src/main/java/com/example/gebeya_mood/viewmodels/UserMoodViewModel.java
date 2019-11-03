package com.example.gebeya_mood.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.pojos.MoodPojo;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserMoodViewModel extends ViewModel {
    private static final String BaseUrl = "https://stark-peak-15799.herokuapp.com/";
    private static UserMoodViewModel userMoodViewModel;
    private static Application application;
    public Retrofit retrofit;
    public UserMoodDao dao;
    protected UserMoodApiService userMoodApiService;
    public Response<MoodPojo> moodPojoResponse;
    public MutableLiveData<List<UserMood>> moods;


    public UserMoodViewModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userMoodApiService = getUserService();
        moods = new MutableLiveData<>(new ArrayList<>());
    }

    // this , i guess keeps/ hold on to the state of the app... make sure
    public static synchronized UserMoodViewModel getInstance(){
        if(userMoodViewModel == null){
            userMoodViewModel = new UserMoodViewModel();
        }
        return userMoodViewModel;
    }

    public UserMoodApiService getUserService(){
        return retrofit.create(UserMoodApiService.class);
    }


    //  POST REQUEST
    public String postUserMood(UserMood userMood){
        userMoodApiService.postMood().enqueue(new Callback<MoodPojo>() {
            @Override
            public void onResponse(Call<MoodPojo> call, Response<MoodPojo> response) {
                moodPojoResponse = response;
                try{
                    if(response.body() != null){
                        String res = String.valueOf(response.body());
                        String err = String.valueOf(response.errorBody());
                        String code = String.valueOf(response.code());
                        Log.e("MoodApi Response: ",res );
                        Log.e("MoodApi CODE: ",code );
                        Log.e("MoodApi ERROR: ",err );

                    }
                }catch (Exception e){e.printStackTrace();}
            }

            @Override
            public void onFailure(Call<MoodPojo> call, Throwable t) {

            }
        });

       return String.valueOf(moodPojoResponse.body());
    }


}
