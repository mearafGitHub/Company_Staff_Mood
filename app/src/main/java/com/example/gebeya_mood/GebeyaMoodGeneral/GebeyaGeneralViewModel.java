package com.example.gebeya_mood.GebeyaMoodGeneral;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gebeya_mood.Mood.MoodsCountPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GebeyaGeneralViewModel extends AndroidViewModel {
    GebeyaGeneralViewModel thisViewModel;
    public MutableLiveData<MoodsCountPojo> generalMoods;
    public Application application;
    public Retrofit retrofit;

    public GebeyaGeneralViewModel(@NonNull Application application) {
        super(application);
    }
    public synchronized GebeyaGeneralViewModel getInstance(){
        if(thisViewModel == null){
            thisViewModel = new GebeyaGeneralViewModel(application);
        }
        return thisViewModel;
    }

    public GeneralApi getGeneralMoodService(){return retrofit.create(GeneralApi.class); }


    public void getGenerealMood(){

        getGeneralMoodService().getGeneralMood().enqueue(new Callback<MoodsCountPojo>() {
            @Override
            public void onResponse(Call<MoodsCountPojo> call, Response<MoodsCountPojo> response) {
                generalMoods.setValue(response.body());
            }

            @Override
            public void onFailure(Call<MoodsCountPojo> call, Throwable t) {
                Log.e("General mood Failed:", t.toString() );
            }
        });
    }
}
