package com.example.gebeya_mood.TeamMood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import java.util.List;

public class TeamMoodAdapter extends RecyclerView.Adapter<TeamMoodViewHolder> {
        Context context;
        List<TeamMood> teamMoodlList;

    public TeamMoodAdapter(Context context, List<TeamMood> teamMoodlList) {
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
    public TeamMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.team_mood_item_card, parent, false);
        return new TeamMoodViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamMoodViewHolder holder, int position) {
        TeamMood teamMood = new TeamMood();
        //TeamMood teamMood = teamMoodlList.get(position);
        holder.teamEmoji.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
        holder.teamMoodContainerTC.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
        holder.team_name.setText(teamMood.teamName);
        holder.teamEmoji.setImageResource(teamMood.teamEmoji);
        holder.team_emotion.setText(teamMood.emotion);
        holder.team_mood_date.setText(teamMood.date);
        holder.totalMembers.setText(teamMood.totalMembers);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

}
