package com.example.gebeya_mood.models;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserMood")
public class UserMood {

      /*
        Username = itemView.findViewById(R.id.Username);
        team_name = itemView.findViewById(R.id.team_name);
        user_emotion = itemView.findViewById(R.id.user_emotion);
        user_mood_date = itemView.findViewById(R.id.user_mood_date);
        user_EMOJI = itemView.findViewById(R.id.user_EMOJI);*/

    @PrimaryKey
    @NonNull
    public String userId;


    @NonNull
    public String user_emotion;

    @NonNull
    public String Username;


    @NonNull
    public String team_name;

    @NonNull
    public String totalTeam;


    @NonNull
    public int user_EMOJI;

    @NonNull
    @ColumnInfo(name = "created_at")
    public String date;

    @NonNull
    public String reason;

}
