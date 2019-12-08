package com.example.gebeya_mood.UserMood;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserMoodViewModel extends AndroidViewModel {
    private static UserMoodViewModel userMoodViewModel;
    private static Application application;
    public Retrofit retrofit;
    public UserMoodDao userMoodDao;
    public static List<UserMood> userMoodList;
    public static List<UserMood> allUsersMoodList;
    public MutableLiveData<UserMoodGETPojo> postMoodPojoResponse;
    public MutableLiveData<List<UserMoodGETPojo>> getOneUserMoods;
    public MutableLiveData<List<UserMoodGETPojo>> getAllUsersMoods;
    private MutableLiveData<List<UserMood>> usermoodsRemote;

    public UserMoodViewModel(@NonNull Application application) {
        super(application);
        retrofit =((App)application).getRetrofit();
        getOneUserMoods = new MutableLiveData<>();
        getAllUsersMoods = new MutableLiveData<>(new ArrayList<>());
        postMoodPojoResponse = new MutableLiveData<>();
        usermoodsRemote = new MutableLiveData<>(new ArrayList<>());
        userMoodList = new ArrayList<>();
        userMoodList = new ArrayList<>();
        allUsersMoodList = new ArrayList<>();
    }

    public UserMoodApiService getUserMoodService(){
        return retrofit.create(UserMoodApiService.class);
    }

    public  static List<UserMood> getOneUserMoodsLocal(String userId){
        userMoodList = ((App)application).getDb().userMoodDAO().getUserMood(userId);
        return userMoodList;
    }



    public void getOneUserMooRemote(String userId){
        // TODO:  finish it
             getUserMoodService().getOneUserMoods(userId).enqueue(new Callback<List<UserMoodGETPojo>>() {
            @Override
            public void onResponse(Call<List<UserMoodGETPojo>> call, Response<List<UserMoodGETPojo>> response) {
                try{
                    getOneUserMoods.setValue(response.body());
                    //TODO: USER TRANSFORMRER AND CHANGE THE MUTABLE.. MTD TO RETURN MODEL CALSS TYPE LIST OBJECT
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<UserMoodGETPojo>> call, Throwable t) {

            }
        });
    }

    public  static List<UserMood> getAllUsersMoodsLocal(String id){
        allUsersMoodList = ((App)application).getDb().userMoodDAO().getUserMood(id);
        return allUsersMoodList;
    }

    public List<UserMood> getAllUsersMoodsRemote(){
        getUserMoodService().getAllUsersMoods().enqueue(new Callback<List<UserMoodGETPojo>>() {
            @Override
            public void onResponse(Call<List<UserMoodGETPojo>> call, Response<List<UserMoodGETPojo>> response) {

                try{
                    getAllUsersMoods.setValue(response.body());
                    //TODO: USER TRANSFORMRER AND CHANGE THE MUTABLE.. MTD TO RETURN MODEL CALSS TYPE LIST OBJECT
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<UserMoodGETPojo>> call, Throwable t) {

            }
        });

        return null;
    }

    public static synchronized UserMoodViewModel getInstance(){
        if(userMoodViewModel == null){
            userMoodViewModel = new UserMoodViewModel(application);
        }
        return userMoodViewModel;
    }

    //  POST REQUEST
    public void postUserMood(JsonObject newUserMood){
        getUserMoodService().postUserMood(newUserMood).enqueue(new Callback<UserMoodGETPojo>() {
            @Override
            public void onResponse(Call<UserMoodGETPojo> call, Response<UserMoodGETPojo> response) {

                try{
                    postMoodPojoResponse.setValue(response.body());
                    //TODO: USER TRANSFORMRER AND CHANGE THE MUTABLE.. MTD TO RETURN MODEL CALSS TYPE LIST OBJECT
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<UserMoodGETPojo> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<UserMoodGETPojo> postUserMoodResponse() {
        return postMoodPojoResponse;
    }

    public MutableLiveData<List<UserMoodGETPojo>> getThisUserMoodResponse() {
        return getOneUserMoods;
    }


}
