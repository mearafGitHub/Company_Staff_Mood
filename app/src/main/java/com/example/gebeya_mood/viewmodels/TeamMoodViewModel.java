package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.TeamMoodPojo;
import com.example.gebeya_mood.repo.team_moods_repo.TeamMoodApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamMoodViewModel extends AndroidViewModel {

    private static TeamMoodViewModel teamMoodViewModel;
    private static Application application;
    private List< MutableLiveData<TeamMoodPojo>> getTeamMoodsResponse;
    MutableLiveData<SingUpPojo> signUpRespones;

    String teamId, teamName, emotion, date, teamTotal;
    int emoji;
    Retrofit retrofit;

    public static synchronized TeamMoodViewModel getInstance(){
        if(teamMoodViewModel == null){
            teamMoodViewModel = new TeamMoodViewModel(application);
        }
        return teamMoodViewModel;
    }


    private TeamMoodViewModel(@NonNull Application application){
        super(application);

        retrofit=((App)application).getRetrofit();
    }


    public void getTeamMood(){
        TeamMoodApiService teamService = retrofit.create(TeamMoodApiService.class);
        teamService.getTeamMoods().enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {


            }

            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {

            }
        });
    }


}
