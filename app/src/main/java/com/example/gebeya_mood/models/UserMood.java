package com.example.gebeya_mood.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserMood")
public class UserMood {

    @PrimaryKey
    @NonNull
    public String userId;

    @NonNull
    public String user_emotion; // mood

    @NonNull
    public int user_EMOJI;  // the android will be taking care of it

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

    @NonNull
    public String reason;

}
