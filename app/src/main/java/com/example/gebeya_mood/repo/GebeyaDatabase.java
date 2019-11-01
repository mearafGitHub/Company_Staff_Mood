package com.example.gebeya_mood.repo;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.repo.user_moods_repo.UserMoodDao;
import com.example.gebeya_mood.repo.users.UserDao;


@Database(
    entities = { UserMood.class,User.class},
    version = 1
)

@Entity(tableName = "UserMood")
public abstract class GebeyaDatabase extends RoomDatabase {

    public abstract UserMoodDao UserMood();
    public abstract UserDao User();
}
