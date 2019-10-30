package com.example.gebeya_mood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.models.Team;
import com.example.gebeya_mood.viewmodels.TeamMoodViewModel;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class AdminViewAdapter extends RecyclerView.Adapter<AdminViewHolder> {
    private AdminViewHolder.OnTeamMoodListener moodListener;
    List<TeamMoodViewModel> teamMood = new ArrayList<>();

    public AdminViewAdapter(AdminViewHolder.OnTeamMoodListener moodListener, List<TeamMoodViewModel> teamMood) {
        this.moodListener = moodListener;
        this.teamMood = teamMood;
    }

    @NonNull
    @Override
    public AdminViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_moods_data_card, parent, false);
        return new AdminViewHolder(view, moodListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewHolder holder, int position) {
        holder.totalMembers.setText(teamMood.get(position).getTeamTotal());
        holder.team.setText(teamMood.get(position).getTeamName());
        holder.mood.setText(teamMood.get(position).getEmotion());

    }

    @Override
    public int getItemCount() {
        return teamMood.size();
    }


}

