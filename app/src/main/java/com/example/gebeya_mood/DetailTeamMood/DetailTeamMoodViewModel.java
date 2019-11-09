package com.example.gebeya_mood.DetailTeamMood;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodApiService;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailTeamMoodViewModel extends AndroidViewModel {

    private static DetailTeamMoodViewModel detailTeamMoodViewModel;
    private  Application application;
    public static List<TeamMood> oneTeamMoodList;
    public static List<TeamMood> allTeamMoodList;
    public MutableLiveData<List<TeamMoodPojo>> getOneTeamMoodsResponse;
    public MutableLiveData<List<TeamMoodPojo>> getAllTeamMoodsResponse;
    protected Retrofit retrofit;


    public DetailTeamMoodViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        getOneTeamMoodsResponse = new MutableLiveData<>();
        getAllTeamMoodsResponse = new MutableLiveData<>();
    }

    public synchronized DetailTeamMoodViewModel getInstance(){
        if(detailTeamMoodViewModel == null){
            detailTeamMoodViewModel = new DetailTeamMoodViewModel(application);
        }
        return detailTeamMoodViewModel;
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


    public void getMoodCount(String team,String date){
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

}
