package com.example.gebeya_mood.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gebeya_mood.data.moodsData.MoodDao;
import com.example.gebeya_mood.data.moodsData.Mood;


@Database(
    entities = { Mood.class},
    version = 1
)
public abstract class GebeyaDatabase extends RoomDatabase {

    public abstract MoodDao moodDao();
}
