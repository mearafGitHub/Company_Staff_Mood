package com.example.gebeya_mood.data.moodsData;


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

    public String userId;

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

    @NonNull
    public String reason;

}
