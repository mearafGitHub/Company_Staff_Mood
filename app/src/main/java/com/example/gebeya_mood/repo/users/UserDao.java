package com.example.gebeya_mood.repo.users;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.models.UserMood;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUsers(List<User> users);

    @Query("SELECT * FROM User")
    List<User> getAll();

  //  @Query("SELECT * FROM UserMood WHERE userId = :userId")
   // UserMood getOneUserMood(String userId);




}

