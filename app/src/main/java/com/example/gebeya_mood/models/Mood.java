package com.example.gebeya_mood.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "moods")
public class Mood {

    @PrimaryKey
    @NonNull
    public String moodId;

    @NonNull
    public String emotion;

    @NonNull
    public String userId;

    @NonNull
    public String userTeam;

    @NonNull
    public String totalTeam;


    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

    @NonNull
    public String reason;

}
