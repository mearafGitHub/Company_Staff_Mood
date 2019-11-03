package com.example.gebeya_mood.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.views.AdminActivity;
import com.example.gebeya_mood.views.TeamDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdminViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    OnTeamMoodListener moodListener;
    public RelativeLayout relativeLayoutADMINReport;
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


    public AdminViewHolder(@NonNull View itemView, OnTeamMoodListener moodListener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.team_name = itemView.findViewById(R.id.admin_data_TeamName);
        this.team_emotion = itemView.findViewById(R.id.admin_data_EMOTION_text);
        this.totalMembers = itemView.findViewById(R.id.admin_data_totalMembers);
        this.moodListener = moodListener;
        team_mood_date = itemView.findViewById(R.id.teamDate);
        teamEmoji = itemView.findViewById(R.id.admin_data_EMOJI);
        relativeLayoutADMINReport = itemView.findViewById(R.id.relativeLayoutADMINReport);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OnTeamMoodListener.onTeamClick(getAdapterPosition());
    }


    public interface OnTeamMoodListener{

        static void onTeamClick(int position) {
        }
    }
}


