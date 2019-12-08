
package com.example.gebeya_mood.UserMood;

import android.app.Application;

        import androidx.annotation.NonNull;
        import androidx.lifecycle.AndroidViewModel;
        import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.App;

import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;

public class MyMoodsViewModel extends AndroidViewModel {
    public Retrofit retrofit;
    public UserMoodDao dao;
    public static Application application;
    public List<UserMood> userMoodList;
    public MutableLiveData<List<UserMoodGETPojo>> getOneUserMoods;


    public MyMoodsViewModel(@NonNull Application application) {
        super(application);
        getOneUserMoods = new MutableLiveData<>(new ArrayList<>());
    }

    public UserMoodApiService getUserMoodService(){
        return retrofit.create(UserMoodApiService.class);
    }

    private void getOneUserMoodsLocal (String userId){
        List<UserMood> tempo = ((App)application).getDb().userMoodDAO().getUserMood(userId);
        if (tempo.isEmpty()){
            getOneUserMoodsReomote(userId);
        }
        else{
            userMoodList = ((App)application).getDb().userMoodDAO().getUserMood(userId);
        }
    }

    public void getOneUserMoodsReomote(String userId){
        getUserMoodService().getOneUserMoods(userId).enqueue(new Callback<List<UserMoodGETPojo>>() {
            @Override
            public void onResponse(Call<List<UserMoodGETPojo>> call, Response<List<UserMoodGETPojo>> response) {
                try{
                    getOneUserMoods.setValue(response.body());

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<UserMoodGETPojo>> call, Throwable t) {
                // TODO:  use this method
            }
        });
    }

    public MutableLiveData<List<UserMoodGETPojo>> getThisUserMoods(){
        return getOneUserMoods;
    }
}
