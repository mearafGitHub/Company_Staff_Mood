package com.example.gebeya_mood.repo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
import com.example.gebeya_mood.models.Mood;


@Database(
    entities = { Mood.class},
    version = 1
)
public abstract class GebeyaDatabase extends RoomDatabase {

    public abstract UserMoodDao moodDao();
}
