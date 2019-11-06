package com.example.gebeya_mood.TeamMood;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamMoodViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout teamMoodContainer;

    @BindView(R.id.team_name)
    public TextView team_name;

    @BindView(R.id.teamEmotion)
    public TextView team_emotion;

    @BindView(R.id.teamDate)
    public TextView team_mood_date;

    @BindView(R.id.teamEmoji)
    public ImageView teamEmoji;

    @BindView(R.id.totalMembers)
    public TextView totalMembers;

    public TeamMoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        team_name = itemView.findViewById(R.id.team_name);
        team_emotion = itemView.findViewById(R.id.teamEmotion);
        team_mood_date = itemView.findViewById(R.id.teamDate);
        totalMembers = itemView.findViewById(R.id.totalMembers);
        teamEmoji = itemView.findViewById(R.id.teamEmoji);
        teamMoodContainer = itemView.findViewById(R.id.teamMoodContainer);
    }
}
