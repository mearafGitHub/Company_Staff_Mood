package com.example.gebeya_mood.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserMoodViewHolder extends RecyclerView.ViewHolder {
    public RelativeLayout reportContainer;

    @BindView(R.id.Username)
    public TextView Username;

    @BindView(R.id.team_name)
    public TextView team_name;

    @BindView(R.id.user_emotion)
    public TextView user_emotion;

    @BindView(R.id.user_mood_date)
    public TextView user_mood_date;

    @BindView(R.id.user_EMOJI)
    public ImageView user_EMOJI;

    public UserMoodViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
        Username = itemView.findViewById(R.id.Username);
        team_name = itemView.findViewById(R.id.team_name);
        user_emotion = itemView.findViewById(R.id.user_emotion);
        user_mood_date = itemView.findViewById(R.id.user_mood_date);
        user_EMOJI = itemView.findViewById(R.id.user_EMOJI);
        reportContainer = itemView.findViewById(R.id.relativeLayoutMoodsReport);
        }
}
