package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.models.TeamMood;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.TeamMoodPojo;
import com.example.gebeya_mood.pojos.UserMoodGETPojo;
import com.example.gebeya_mood.repo.team_moods_repo.TeamMoodApiService;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamMoodViewModel extends AndroidViewModel {

    private static TeamMoodViewModel teamMoodViewModel;
    private static Application application;
    public static List<TeamMood> oneTeamMoodList;
    public static List<TeamMood> allTeamMoodList;
    public MutableLiveData<List<TeamMoodPojo>> getOneTeamMoodsResponse;
    public MutableLiveData<List<TeamMoodPojo>> getAllTeamMoodsResponse;
/*
   protected String teamId, teamName, emotion, date, teamTotal;
   protected int emoji;*/
   protected Retrofit retrofit;

    public static synchronized TeamMoodViewModel getInstance(){
        if(teamMoodViewModel == null){
            teamMoodViewModel = new TeamMoodViewModel(application);
        }
        return teamMoodViewModel;
    }

     public TeamMoodApiService getTeamMoodService(){
        return  retrofit.create(TeamMoodApiService.class);
    }

    private TeamMoodViewModel(@NonNull Application application){
        super(application);

        getOneTeamMoodsResponse = new MutableLiveData<>(new ArrayList<>());
        getAllTeamMoodsResponse = new MutableLiveData<>(new ArrayList<>());
    }

    public void getAllTeamMood(){
        getTeamMoodService().getAllTeamMoods().enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {
                getAllTeamMoodsResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {

            }
        });
    }


    public void getOneTeamMooReomote(String teamId){

        getTeamMoodService().getOneTeamMoods(teamId).enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {
                getOneTeamMoodsResponse.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {

            }
        });
    }


}
