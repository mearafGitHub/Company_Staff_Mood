package com.example.gebeya_mood.moodhome;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.airbnb.lottie.L;
import com.example.gebeya_mood.data.moodsData.Mood;
import com.example.gebeya_mood.data.moodsData.MoodApiService;
import com.example.gebeya_mood.data.moodsData.MoodDao;
import com.example.gebeya_mood.data.moodsData.MoodTransformer;
import com.example.gebeya_mood.data.moodsData.MoodsDto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MoodViewModel extends AndroidViewModel {
    private Retrofit retrofit;
    private MoodDao dao;
    private MutableLiveData<List<Mood>> moods;


    public MoodViewModel(@NonNull Application application) {
        super(application);

      // retrofit = ((Application) application).getRetrofit();

       // dao = ((Application) application).getDb().moodDao();
        moods = new MutableLiveData<>(new ArrayList<>());

        loadMoods();
    }

    private void loadMoods(){
        List<Mood> moodsDb = dao.getAll();
        if (moodsDb.isEmpty()){
            moodsFromApi();
        }
        else{
            moods.setValue(moodsDb);
        }

    }

    private void moodsFromApi(){

        MoodApiService moodApiService = retrofit.create(MoodApiService.class);
        moodApiService.getMoods().enqueue(new Callback<List<MoodsDto>>() {
            @Override
            public void onResponse(Call<List<MoodsDto>> call, Response<List<MoodsDto>> response) {
                List<Mood> moodsApi = MoodTransformer.ListDtoToMood(response.body());
                dao.addMoods(moodsApi);
                moods.setValue(moodsApi);
            }

            @Override
            public void onFailure(Call<List<MoodsDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<Mood>> getMoods(){
        return moods;
    }
}
