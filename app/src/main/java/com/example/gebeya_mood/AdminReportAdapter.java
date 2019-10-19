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

public class AdminReportAdapter extends RecyclerView.Adapter<AdminReportAdapter.AdminReportView>{
    Context aContext;
    List<AdminReportModel> aReports;

    public AdminReportAdapter(Context aContext, List<AdminReportModel> aReports) {
        this.aContext = aContext;
        this.aReports = aReports;
    }

    public Context getaContext() {
        return aContext;
    }

    public void setaContext(Context aContext) {
        this.aContext = aContext;
    }

    public List<AdminReportModel> getaReports() {
        return aReports;
    }

    public void setaReports(List<AdminReportModel> aReports) {
        this.aReports = aReports;
    }

    @NonNull
    @Override
    public AdminReportView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(aContext).inflate(R.layout.admin_moods_data_card, parent, false);
        return new AdminReportView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminReportView holder, int position) {
        holder.moodEmoji.setAnimation(AnimationUtils.loadAnimation(aContext, R.anim.list_fade_anim));
        holder.reportContainer.setAnimation(AnimationUtils.loadAnimation(aContext, R.anim.list_fade_anim));

        holder.reportDate.setText(aReports.get(position).getReportDate());
        holder.staffGroupName.setText(aReports.get(position).getStaffGroupName());
        holder.totalMembers.setText(aReports.get(position).getTotalMembers());
        holder.moodEmoji.setImageResource(aReports.get(position).getEmoji());
        holder.inMood.setText(aReports.get(position).getInMood());
       // holder.dataSetIcon.setImageResource(aReports.get(position).getDataset());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdminReportView extends RecyclerView.ViewHolder{

        public RelativeLayout reportContainer;
        TextView staffGroupName,totalMembers, moodType, inMood, reportDate;
        ImageView moodEmoji, dataSetIcon;
        public AdminReportView(@NonNull View itemView) {
            super(itemView);

        staffGroupName = itemView.findViewById(R.id.admin_data_TeamName);
        totalMembers = itemView.findViewById(R.id.admin_data_totalMembers);
        moodType = itemView.findViewById(R.id.admin_data_EMOTION_text);
        inMood = itemView.findViewById(R.id.admin_data_inMoodText);
        moodEmoji = itemView.findViewById(R.id.admin_data_EMOJI);
        reportDate = itemView.findViewById(R.id.admin_data_mood_DATE);
        reportContainer = itemView.findViewById(R.id.relativeLayoutAdmin);
        //dataSetIcon = itemView.findViewById(R.id.admin_DATASET_icon);

        }
    }

}
