package com.example.gebeya_mood.TeamMood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gebeya_mood.Admin.AdminViewAdapter;
import com.example.gebeya_mood.Admin.AdminViewHolder;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDetailActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, AdminViewHolder.OnTeamMoodListener {
    public ImageView imageView;
    public String teamName;
    Context context;
    int activityNum = 2;
    RecyclerView adminRecyclerView;
    AdminViewAdapter adminAdapter;
    List<TeamMood> teamMoods;
    TeamMoodDao teamMoodDao;
    MutableLiveData<List<TeamMoodPojo>> teamMoodResponse;
    TeamMoodViewModel teamMoodViewModel;
    TeamMoodAdapter teamMoodAdapter;
    private String filterByDateString;
    int listSize;
    public int happyN, contentN, angryN, sadN, neutralN;
    @BindView(R.id.team_nameTD)
    TextView team_nameTD;

    @BindView(R.id.by_date_filter)
    Spinner filterByDate;
    @BindView(R.id.admin_grahp_icon_DETAIL)
    ImageButton graph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        team_nameTD = findViewById(R.id.team_nameTD);
        team_nameTD.setText(Const.TEAMNAMEOFDETAIL);
        graph = findViewById(R.id.admin_grahp_icon_DETAIL);
        Spinner filterByDate = findViewById(R.id.by_date_filter);
        adminRecyclerView = findViewById(R.id.teamDetailRecycler);
        teamMoodAdapter = new TeamMoodAdapter(this, new ArrayList<>());

        ArrayAdapter<CharSequence> filterByDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        filterByDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterByDate.setAdapter(filterByDateAdapter);
        filterByDate.setOnItemSelectedListener(this);

        try{
            teamMoodViewModel.getInstance().getOneTeamMooReomote(Const.TEAMNAMEOFDETAIL);
            teamMoodViewModel.getAllTeamMoodsResponseM().observe(this, new Observer<List<TeamMoodPojo>>() {
                @Override
                public void onChanged(List<TeamMoodPojo> teamMoodPojo) {
                    teamMoods = TeamMoodTransformer.toTeamModelList(teamMoodPojo);
                    teamMoodAdapter.setTeamMoodModelList(teamMoods);
                    teamMoodAdapter.notifyDataSetChanged();
                    teamMoodDao.addMoods(teamMoods);
                    listSize = teamMoodPojo.size();
                }
            });
        }catch (Exception e){ e.printStackTrace();}
        initRecycler();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initRecycler() {
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adminAdapter = new AdminViewAdapter(this,teamMoods);
        adminRecyclerView.setAdapter(adminAdapter);
    }
}
