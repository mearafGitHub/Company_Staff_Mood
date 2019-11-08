package com.example.gebeya_mood.TeamMood;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.gebeya_mood.App;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TeamMoodViewModel extends AndroidViewModel {

    private static TeamMoodViewModel teamMoodViewModel;
    private  Application application;
    public static List<TeamMood> oneTeamMoodList;
    public static List<TeamMood> allTeamMoodList;
    public MutableLiveData<List<TeamMoodPojo>> getOneTeamMoodsResponse;
    public MutableLiveData<List<TeamMoodPojo>> getAllTeamMoodsResponse;
    protected Retrofit retrofit;

    public TeamMoodViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        getOneTeamMoodsResponse = new MutableLiveData<>();
        getAllTeamMoodsResponse = new MutableLiveData<>();
    }

    public synchronized TeamMoodViewModel getInstance(){
        if(teamMoodViewModel == null){
            teamMoodViewModel = new TeamMoodViewModel(application);
        }
        return teamMoodViewModel;
    }

     public TeamMoodApiService getTeamMoodService(){
        return  retrofit.create(TeamMoodApiService.class);
    }

    public MutableLiveData<List<TeamMoodPojo>> getAllTeamMood(){
        getTeamMoodService().getAllTeamMoods().enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {
                try{
                    getAllTeamMoodsResponse.setValue(response.body());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {

            }
        });
        return getAllTeamMoodsResponse;
    }

    public MutableLiveData<List<TeamMoodPojo>> getOneTeamMooReomote(String teamId){

        getTeamMoodService().getOneTeamMoods(teamId).enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {
                try{
                    getOneTeamMoodsResponse.setValue(response.body());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {
                Log.e("ON-FAILURE",String.valueOf(t));
            }
        });
        return getOneTeamMoodsResponse;
    }

    public void getAllTeamMooFilterd(String team,String date){
        try{
        getTeamMoodService().getAllTeamMoodsFilterd(team,date).enqueue(new Callback<List<TeamMoodPojo>>() {
            @Override
            public void onResponse(Call<List<TeamMoodPojo>> call, Response<List<TeamMoodPojo>> response) {
                try{
                    getOneTeamMoodsResponse.setValue(response.body());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<List<TeamMoodPojo>> call, Throwable t) {
                Log.e("ON-FAILURE",String.valueOf(t));
            }
        });
    }catch (Exception e){ e.printStackTrace();}
    }

    public MutableLiveData<List<TeamMoodPojo>> getOneTeamMoodResponse() {
        return getOneTeamMoodsResponse;
    }

    public MutableLiveData<List<TeamMoodPojo>> getAllTeamMoodsResponseM() {
        return getAllTeamMoodsResponse;
    }

    public MutableLiveData<List<TeamMoodPojo>> filteredTeamMoods(){
        return getOneTeamMoodsResponse;
    }

}
