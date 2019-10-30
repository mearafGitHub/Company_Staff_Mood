package com.example.gebeya_mood.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.models.Mood;
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

public class UserMoodViewModel extends AndroidViewModel {
    public Retrofit retrofit;
    public UserMoodDao dao;
    public MutableLiveData<List<Mood>> moods;


    public UserMoodViewModel(@NonNull Application application) {
        super(application);

   /*   retrofit = ((Application) application).getRetrofit();
        dao = ((Application) application).getDb().moodDao();*/
        moods = new MutableLiveData<>(new ArrayList<>());

        loadUserMoods();
    }

    private void loadUserMoods(){
        List<Mood> moodsDb = dao.getAll();
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
                List<Mood> moodsApi = UserMoodTransformer.ListDtoToMood(response.body());
                dao.addMoods(moodsApi);
                moods.setValue(moodsApi);
            }

            @Override
            public void onFailure(Call<List<UserMoodsDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<Mood>> getMoods(){
        return moods;
    }
}
