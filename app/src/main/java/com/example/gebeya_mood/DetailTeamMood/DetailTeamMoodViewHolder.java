package com.example.gebeya_mood.DetailTeamMood;

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
    @BindView(R.id.detail_teamMood_relativeLayoutReport)
    public RelativeLayout detail_teamMood_relativeLayoutReport;

    @BindView(R.id.detail_teamMood_EMOTION_text)
    public TextView detail_teamMood_EMOTION_text;

    @BindView(R.id.detail_teamMood_DATE)
    public TextView detail_teamMood_DATE;

    @BindView(R.id.detail_teamMood_inMoodText)
    public TextView detail_teamMood_inMoodText;

    @BindView(R.id.detail_teamMood_EMOJI)
    public ImageView detail_teamMood_EMOJI;

    @BindView(R.id.detail_teamMood_graph_icon)
    public ImageView detail_teamMood_graph_icon;


    public DetailTeamMoodViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        detail_teamMood_graph_icon= itemView.findViewById(R.id.detail_teamMood_graph_icon);
        detail_teamMood_inMoodText = itemView.findViewById(R.id.detail_teamMood_inMoodText);
        detail_teamMood_EMOTION_text = itemView.findViewById(R.id.detail_teamMood_EMOTION_text);
        detail_teamMood_DATE = itemView.findViewById(R.id.detail_teamMood_DATE);
        detail_teamMood_EMOJI = itemView.findViewById(R.id.detail_teamMood_EMOJI);
        detail_teamMood_relativeLayoutReport = itemView.findViewById(R.id.relativeLayoutDETAILReport);
    }
}
