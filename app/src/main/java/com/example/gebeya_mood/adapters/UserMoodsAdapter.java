package com.example.gebeya_mood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.models.Mood;
import com.example.gebeya_mood.views.UserMoodViewHolder;

import java.util.ArrayList;
import java.util.List;

public class UserMoodsAdapter extends RecyclerView.Adapter<UserMoodViewHolder> {

    Context context;
    List<Mood> moodsList;
    LayoutInflater inflater;

    public UserMoodsAdapter(Context context, List<Mood> moodsList) {

        this.context = context;
        moodsList = new ArrayList<>(moodsList);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = inflater.inflate(R.layout.mood_show_card, parent, false);
        return new UserMoodViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {
        Mood mood = moodsList.get(position);
        holder.moodType.setText(mood.emotion);
        holder.staffGroupName.setText(mood.userTeam);
        holder.inMood.setText(mood.reason);
        holder.reportDate.setText(mood.date);
        holder.totalMembers.setText(mood.totalTeam);

    }

    @Override
    public int getItemCount() {
        return moodsList.size();
    }
}
