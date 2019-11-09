package com.example.gebeya_mood.DetailTeamMood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodViewHolder;

import java.util.List;

public class DetailTeamMoodAdapter extends RecyclerView.Adapter<DetailTeamMoodViewHolder> {
        Context context;
        List<TeamMood> teamMoodlList;

    public DetailTeamMoodAdapter(Context context, List<TeamMood> teamMoodlList) {
        this.context = context;
        this.teamMoodlList = teamMoodlList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<TeamMood> getTeamMoodModelList() {
        return teamMoodlList;
    }

    public void setTeamMoodModelList(List<TeamMood> teamMoodModelList) {
        this.teamMoodlList = teamMoodModelList;
    }

    @NonNull
    @Override
    public DetailTeamMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.detail_team_moods_data_card, parent, false);
        return new DetailTeamMoodViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailTeamMoodViewHolder holder, int position) {
        TeamMood teamMood = new TeamMood();
        //TeamMood teamMood = teamMoodlList.get(position);
        holder.detail_teamMood_EMOJI.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
      //  holder.detail_teamMood_relativeLayoutReport.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
        holder.detail_teamMood_graph_icon.setImageResource(R.drawable.graph);
        holder.detail_teamMood_EMOJI.setImageResource(R.drawable.ic_emoticon_happy);
        holder.detail_teamMood_EMOTION_text.setText(teamMood.emotion);
        holder.detail_teamMood_DATE.setText(teamMood.date);

    }

    @Override
    public int getItemCount() {
        return 30;
    }

}
