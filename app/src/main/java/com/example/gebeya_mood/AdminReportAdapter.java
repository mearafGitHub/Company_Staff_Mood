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

public class AdminReportAdapter extends RecyclerView.Adapter<AdminReportAdapter.AdminReportViewHolder> {

    Context mContext;
    List<MoodReportItemModel> mReports;

    public AdminReportAdapter(Context mContext, List<MoodReportItemModel> mReports) {

        this.mContext = mContext;
        this.mReports = mReports;
    }

    public Context getmContext() {
        return mContext;
    }

    public List<MoodReportItemModel> getmReports() {
        return mReports;
    }


    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void setmReports(List<MoodReportItemModel> mReports) {
        this.mReports = mReports;
    }

    @NonNull
    @Override
    public AdminReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.admin_moods_data_card, parent, false);
        return new AdminReportViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminReportAdapter.AdminReportViewHolder holder, int position) {


        holder.moodEmoji.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.list_fade_anim));
        holder.reportContainer.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.list_fade_anim));

        holder.staffGroupName.setText(mReports.get(position).getStaffGroupName());
        holder.inMood.setText(mReports.get(position).getInMood());
        holder.totalMembers.setText(mReports.get(position).getTotalMembers());
        holder.moodType.setText(mReports.get(position).getMoodType());
        holder.reportDate.setText(mReports.get(position).getReportDate());
        holder.moodEmoji.setImageResource(mReports.get(position).getEmoji());

    }

    @Override
    public int getItemCount() {
        return mReports.size();
    }



    public class AdminReportViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout reportContainer;
        TextView staffGroupName,totalMembers, moodType, inMood, reportDate;
        ImageView moodEmoji;

        public AdminReportViewHolder(@NonNull View itemView) {
            super(itemView);

            staffGroupName = itemView.findViewById(R.id.staffTeamText);
            totalMembers = itemView.findViewById(R.id.totalMembers);
            moodType = itemView.findViewById(R.id.moodType);
            inMood = itemView.findViewById(R.id.inMoodText);
            moodEmoji = itemView.findViewById(R.id.emoji);
            reportDate = itemView.findViewById(R.id.dateText);
            reportContainer = itemView.findViewById(R.id.relativeLayoutMoodsReport);
        }
    }
}
