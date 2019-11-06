package com.example.gebeya_mood.UserMood;


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
    public String username;

    @NonNull
    public String team_name;
    @NonNull
    public String user_emotion; // mood

    @NonNull
    public int user_EMOJI;  // the android will be taking care of it

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

    @NonNull
    public String reason;

    public UserMood(@NonNull String userId, @NonNull String username, @NonNull String team_name, @NonNull String user_emotion, int user_EMOJI, @NonNull String date, @NonNull String reason) {
        this.userId = userId;
        this.username = username;
        this.team_name = team_name;
        this.user_emotion = user_emotion;
        this.user_EMOJI = user_EMOJI;
        this.date = date;
        this.reason = reason;
    }
}
