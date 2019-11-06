package com.example.gebeya_mood;

import android.app.Application;

import androidx.room.Room;

import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.repo.GebeyaDatabase;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private Retrofit retrofit;
    private GebeyaDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
        retrofit=new Retrofit.Builder()
                .baseUrl(Const.BASE_URL_HEROKU)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        db = Room.databaseBuilder(this,
                GebeyaDatabase.class,
                Const.DATABASE_NAME
        ).allowMainThreadQueries()
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
    public App getAppRef(){
        return this;
    }
    public GebeyaDatabase getDb() {
        return db;
    }
}
