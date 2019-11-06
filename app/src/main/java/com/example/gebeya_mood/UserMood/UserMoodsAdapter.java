package com.example.gebeya_mood.UserMood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

import java.util.ArrayList;
import java.util.List;

public class UserMoodsAdapter extends RecyclerView.Adapter<UserMoodViewHolder> {

    Context context;
    List<UserMood> moodsList = new ArrayList<>();
    LayoutInflater inflater;

    public UserMoodsAdapter(Context context, List<UserMood> moodsList) {

        this.context = context;
        moodsList = moodsList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = inflater.inflate(R.layout.user_mood_item_card, parent, false);
        return new UserMoodViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {
        UserMood userMood = moodsList.get(position);

        holder.Username.setText(userMood.username);
        holder.team_name.setText(userMood.team_name);
        holder.user_emotion.setText(userMood.user_emotion);
        holder.user_mood_date.setText(userMood.date);
       // holder.user_EMOJI.setText(userMood.user_EMOJI);

    }

    @Override
    public int getItemCount() {
        return moodsList.size();
    }
}
