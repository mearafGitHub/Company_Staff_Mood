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
        Context uContext;
        List<UserMoodModel> userMoodModelList;

    public UserMoodAdapter(Context context, List<UserMoodModel> userMoodModelList) {
        this.uContext = context;
        this.userMoodModelList = userMoodModelList;
    }

    public Context getContext() {
        return uContext;
    }

    public void setContext(Context context) {
        this.uContext = context;
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
        layout = LayoutInflater.from(uContext).inflate(R.layout.user_mood_card, parent, false);
        return new UserMoodViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {

        holder.emoji.setAnimation(AnimationUtils.loadAnimation(uContext, R.anim.list_fade_anim));
       // holder.userMoodContainer.setAnimation(AnimationUtils.loadAnimation(uContext, R.anim.list_fade_anim));

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
