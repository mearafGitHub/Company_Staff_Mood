package com.example.gebeya_mood;

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

import java.util.List;

public class UserMoodAdapter extends RecyclerView.Adapter<UserMoodAdapter.UserMoodViewHolder> {
        Context context;
        List<UserMoodModel> userMoodModelList;

    public UserMoodAdapter(Context context, List<UserMoodModel> userMoodModelList) {
        this.context = context;
        this.userMoodModelList = userMoodModelList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<UserMoodModel> getUserMoodModelList() {
        return userMoodModelList;
    }

    public void setUserMoodModelList(List<UserMoodModel> userMoodModelList) {
        this.userMoodModelList = userMoodModelList;
    }

    @NonNull
    @Override
    public UserMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(context).inflate(R.layout.mood_show_card, parent, false);

        return new UserMoodViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {


        holder.emoji.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));
        holder.listContainer.setAnimation(AnimationUtils.loadAnimation(context, R.anim.list_fade_anim));

        holder.team.setText(userMoodModelList.get(position).getTeam());
        holder.date.setText(userMoodModelList.get(position).getDate());
        holder.emotion.setText(userMoodModelList.get(position).getEmotion());
        holder.emoji.setImageResource(userMoodModelList.get(position).getEmoji());

    }

    @Override
    public int getItemCount() {
        return userMoodModelList.size();
    }

    // VIEW HOLDER CLASS

    public class UserMoodViewHolder extends RecyclerView.ViewHolder {

        TextView username, date, team, emotion;
        ImageView emoji;
        RelativeLayout listContainer;

        public UserMoodViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            date = itemView.findViewById(R.id.dateText);
            emoji = itemView.findViewById(R.id.emoji);
            team = itemView.findViewById(R.id.inMoodText);
            listContainer = itemView.findViewById(R.id.relativeLayoutMoodsReport);
            emotion = itemView.findViewById(R.id.happyMood);
        }
    }
}
