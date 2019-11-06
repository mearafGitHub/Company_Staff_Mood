package com.example.gebeya_mood.UserMood;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gebeya_mood.UserMood.UserMood;

import java.util.List;

@Dao
public interface UserMoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMoods(List<UserMood> userMoods);

    @Query("SELECT * FROM UserMood")
    List<UserMood> getUserMoods();

    @Query("SELECT * FROM UserMood WHERE userId = :userId" )
    List<UserMood> getUserMood(String userId);

  //  @Query("SELECT * FROM UserMood WHERE userId = :userId")
  //  UserMood getOneUserMood(String userId);

}

