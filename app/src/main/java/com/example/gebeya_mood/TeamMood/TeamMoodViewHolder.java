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
    @BindView(R.id.teamMoodContainerTC)
    public RelativeLayout teamMoodContainerTC;

    @BindView(R.id.teamNameTC)
    public TextView team_name;

    @BindView(R.id.teamEmotionTC)
    public TextView team_emotion;

    @BindView(R.id.teamDateTC)
    public TextView team_mood_date;

    @BindView(R.id.teamEmojiTC)
    public ImageView teamEmoji;

    @BindView(R.id.totalMembersTC)
    public TextView totalMembers;

    public TeamMoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        team_name = itemView.findViewById(R.id.team_name);
        team_emotion = itemView.findViewById(R.id.teamEmotionTC);
        team_mood_date = itemView.findViewById(R.id.teamDateTC);
        totalMembers = itemView.findViewById(R.id.totalMembersTC);
        teamEmoji = itemView.findViewById(R.id.teamEmojiTC);
        teamMoodContainerTC = itemView.findViewById(R.id.teamMoodContainerTC);
    }
}
