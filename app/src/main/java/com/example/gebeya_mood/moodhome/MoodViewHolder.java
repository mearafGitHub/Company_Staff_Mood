package com.example.gebeya_mood.moodhome;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoodViewHolder extends RecyclerView.ViewHolder {
    public RelativeLayout reportContainer;

    @BindView(R.id.staffTeamText)
    TextView staffGroupName;

    @BindView(R.id.totalMembers)
    TextView totalMembers;

    @BindView(R.id.moodType)
    TextView moodType;

    @BindView(R.id.inMoodText)
    TextView inMood;

    @BindView(R.id.dateText)
    TextView reportDate;

    @BindView(R.id.emoji)
    ImageView moodEmoji;

    public MoodViewHolder(@NonNull View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);
        staffGroupName = itemView.findViewById(R.id.staffTeamText);
        totalMembers = itemView.findViewById(R.id.totalMembers);
        moodType = itemView.findViewById(R.id.moodType);
        inMood = itemView.findViewById(R.id.inMoodText);
        moodEmoji = itemView.findViewById(R.id.emoji);
        reportDate = itemView.findViewById(R.id.dateText);
        reportContainer = itemView.findViewById(R.id.relativeLayoutMoodsReport);
        }
}
