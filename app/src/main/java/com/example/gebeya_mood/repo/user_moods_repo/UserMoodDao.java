package com.example.gebeya_mood.repo.user_moods_repo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gebeya_mood.models.Mood;

import java.util.List;

@Dao
public interface UserMoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMoods(List<Mood> moods);

    @Query("SELECT * FROM moods")
    List<Mood> getAll();

    @Query("SELECT * FROM moods WHERE userId = :userId")
    Mood getOne(String userId);

    @Query("SELECT * FROM moods WHERE moodId = :moodId")
    Mood getOneMood(String moodId);



}

