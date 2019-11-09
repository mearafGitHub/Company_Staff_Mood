package com.example.gebeya_mood.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamMood;

import java.util.List;

public class AdminViewAdapter extends RecyclerView.Adapter<AdminViewHolder> {
    private AdminViewHolder.OnTeamMoodListener moodListener;
    private Context context;
    private List<TeamMood> teamMoods;

    public AdminViewAdapter(Context context, List<TeamMood> teamMoods) {
        this.moodListener = moodListener;
        this.teamMoods = teamMoods;
        this.context = context;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<TeamMood> getTeamMoodModes() {
        return teamMoods;
    }

    public void setTeamMoodModes(List<TeamMood> teamMoodModelList) {
        this.teamMoods = teamMoodModelList;
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_moods_data_card, parent, false);
        return new AdminViewHolder(view, moodListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewHolder holder, int position) {
        TeamMood teamMood = new TeamMood();

//        holder.teamEmoji.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
 //       holder.relativeLayoutADMINReport.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
        holder.team_name.setText(teamMood.teamName);
        holder.teamEmoji.setImageResource(teamMood.teamEmoji);
        holder.team_emotion.setText(teamMood.emotion);
        holder.team_mood_date.setText(teamMood.date);
        holder.totalMembers.setText(teamMood.totalMembers);
    }

    @Override
    public int getItemCount() {
        return 20;
    }


}

