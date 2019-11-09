package com.example.gebeya_mood.TeamMood;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailTeamMoodViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.teamMoodContainerTC)
    public RelativeLayout detailteamMoodContainer;

    @BindView(R.id.admin_data_TeamNameDETAIL)
    public TextView team_name;

    @BindView(R.id.admin_data_EMOTION_DETAIL)
    public TextView team_emotion;

    @BindView(R.id.admin_date_mood_DATEDETAIL)
    public TextView team_mood_date;

    @BindView(R.id.admin_data_totalMembers_DETAIL)
    public ImageView teamEmoji;

    @BindView(R.id.admin_data_totalMembers_DETAIL)
    public TextView totalMembers;

    public DetailTeamMoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        team_name = itemView.findViewById(R.id.admin_data_TeamNameDETAIL);
        team_emotion = itemView.findViewById(R.id.admin_data_EMOTION_DETAIL);
        team_mood_date = itemView.findViewById(R.id.admin_data_totalMembers_DETAIL);
        totalMembers = itemView.findViewById(R.id.admin_data_totalMembers_DETAIL);
        teamEmoji = itemView.findViewById(R.id.admin_data_totalMembers_DETAIL);
        detailteamMoodContainer = itemView.findViewById(R.id.relativeLayoutDETAILReport);
    }
}
