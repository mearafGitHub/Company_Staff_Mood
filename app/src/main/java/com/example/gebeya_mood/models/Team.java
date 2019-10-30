package com.example.gebeya_mood.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Team {

    @PrimaryKey
    @NonNull
    public String mood;

    @NonNull
    public String emotion;

    @NonNull
    public String teamId;

    @NonNull
    public String teamName;

    @NonNull
    public String teamTotal;


    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;


}
