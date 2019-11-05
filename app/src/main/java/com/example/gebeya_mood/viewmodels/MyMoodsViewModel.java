
package com.example.gebeya_mood.viewmodels;

import android.app.Application;

        import androidx.annotation.NonNull;
        import androidx.lifecycle.AndroidViewModel;
        import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gebeya_mood.App;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.pojos.UserMoodGETPojo;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodApiService;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodTransformer;
        import com.example.gebeya_mood.repo.user_moods_repo.UserMoodsDto;

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
    public MutableLiveData<UserMoodGETPojo> postMoodPojoResponse;
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
            getOneUserMooReomote(userId);
        }
        else{
            userMoodList = ((App)application).getDb().userMoodDAO().getUserMood(userId);
        }

    }

    public void getOneUserMooReomote(String userId){
        // TODO:  finish it
        getUserMoodService().getOneUserMoods(userId).enqueue(new Callback<List<UserMoodGETPojo>>() {
            @Override
            public void onResponse(Call<List<UserMoodGETPojo>> call, Response<List<UserMoodGETPojo>> response) {
                getOneUserMoods.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserMoodGETPojo>> call, Throwable t) {

            }
        });
    }


    public MutableLiveData<List<UserMoodGETPojo>> getthisUserMoods(){
        return getOneUserMoods;
    }
}
