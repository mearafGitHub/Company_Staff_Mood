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
import com.example.gebeya_mood.viewmodels.TeamMoodViewModel;

import java.util.List;

public class TeamMoodAdapter extends RecyclerView.Adapter<TeamMoodAdapter.UserMoodViewHolder> {
        Context uContext;
        List<TeamMoodViewModel> teamMoodModelList;

    public TeamMoodAdapter(Context context, List<TeamMoodViewModel> teamMoodModelList) {
        this.uContext = context;
        this.teamMoodModelList = teamMoodModelList;
    }

    public Context getContext() {
        return uContext;
    }

    public void setContext(Context context) {
        this.uContext = context;
    }

    public List<TeamMoodViewModel> getTeamMoodModelList() {
        return teamMoodModelList;
    }

    public void setTeamMoodModelList(List<TeamMoodViewModel> teamMoodModelList) {
        this.teamMoodModelList = teamMoodModelList;
    }

    @NonNull
    @Override
    public UserMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(uContext).inflate(R.layout.less_item_card, parent, false);
        return new UserMoodViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {

        holder.emoji.setAnimation(AnimationUtils.loadAnimation(uContext, R.anim.list_fade_anim));
       // holder.userMoodContainer.setAnimation(AnimationUtils.loadAnimation(uContext, R.anim.list_fade_anim));

        holder.date.setText(teamMoodModelList.get(position).getDate());
        holder.emotion.setText(teamMoodModelList.get(position).getEmotion());
        holder.emoji.setImageResource(teamMoodModelList.get(position).getEmoji());
    }

    @Override
    public int getItemCount() {
        return teamMoodModelList.size();
    }

    // VIEW HOLDER CLASS

    public class UserMoodViewHolder extends RecyclerView.ViewHolder {

        TextView date, team, emotion;
        ImageView emoji;
        RelativeLayout userMoodContainer;

        public UserMoodViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date_usermood);
            emoji = itemView.findViewById(R.id.user_emoji);
            emotion = itemView.findViewById(R.id.emotion);
            userMoodContainer = itemView.findViewById(R.id.userMoodRelativeLayout);
        }
    }
}
