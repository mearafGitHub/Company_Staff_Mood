package com.example.gebeya_mood.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gebeya_mood.R;

public class AdminViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    OnTeamMoodListener moodListener;
    TextView team, mood, totalMembers;

    public AdminViewHolder(@NonNull View itemView, OnTeamMoodListener moodListener) {
        super(itemView);
        this.team = itemView.findViewById(R.id.admin_data_TeamName);
        this.mood = itemView.findViewById(R.id.admin_data_EMOTION_text);
        this.totalMembers = itemView.findViewById(R.id.admin_data_totalMembers);
        this.moodListener = moodListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OnTeamMoodListener.onMoodClick(getAdapterPosition());
    }


    public interface OnTeamMoodListener{

        static void onMoodClick(int position) {

        }
    }
}
