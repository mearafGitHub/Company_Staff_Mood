package com.example.gebeya_mood.repo.team_moods_repo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gebeya_mood.models.UserMood;

import java.util.List;

@Dao
public interface TeamMoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMoods(List<UserMood> userMoods);

    @Query("SELECT * FROM UserMood")
    List<UserMood> getAll();

  //  @Query("SELECT * FROM UserMood WHERE userId = :userId")
  //  UserMood getOneUserMood(String userId);




}

