package com.example.gebeya_mood.repo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.gebeya_mood.Auths.User;
import com.example.gebeya_mood.UserMood.UserMood;
import com.example.gebeya_mood.UserMood.UserMoodDao;
import com.example.gebeya_mood.Auths.users.UserDao;


@Database(
    entities = { UserMood.class,User.class},
    version = 1
)

//@Entity(tableName = "UserMood")

public abstract class GebeyaDatabase extends RoomDatabase {

    public abstract UserMoodDao userMoodDAO();
    public abstract UserDao User();

}
