package com.example.gebeya_mood;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserMoodAdapter extends RecyclerView.Adapter<UserMoodAdapter.UserMoodViewHolder> {


    @NonNull
    @Override
    public UserMoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserMoodViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserMoodViewHolder extends RecyclerView.ViewHolder {


        public UserMoodViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
