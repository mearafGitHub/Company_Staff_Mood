package com.example.gebeya_mood.DetailTeamMood;

import androidx.annotation.NonNull;
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
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodAdapter;
import com.example.gebeya_mood.TeamMood.TeamMoodDao;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodTransformer;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
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
    RecyclerView detailRecyclerView;
    DetailTeamMoodAdapter detailTeamMoodAdapter;
    List<TeamMood> teamMoods;
    TeamMoodDao teamMoodDao;
    MutableLiveData<List<TeamMoodPojo>> teamMoodResponse;
    DetailTeamMoodViewModel detailTeamMoodViewModel;

    private String filterByDateString;
    int listSize;
    public int happyN, contentN, angryN, sadN, neutralN;
    @BindView(R.id.team_nameTD)
    TextView team_nameTD;

    @BindView(R.id.by_date_filter)
    Spinner filterByDate;
   /*
    @BindView(R.id.detail_teamMood_graph_icon)
    ImageButton graph;*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);
        team_nameTD = findViewById(R.id.team_nameTD);
        team_nameTD.setText(Const.TEAMNAMEOFDETAIL);
        //graph = findViewById(R.id.detail_teamMood_graph_icon);
        Spinner filterByDate = findViewById(R.id.by_date_filter);
        detailRecyclerView = findViewById(R.id.teamDetailRecycler);
      ButterKnife.bind(this);
        detailTeamMoodAdapter = new DetailTeamMoodAdapter(this, new ArrayList<>());

        ArrayAdapter<CharSequence> filterByDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        filterByDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterByDate.setAdapter(filterByDateAdapter);
        filterByDate.setOnItemSelectedListener(this);

        try{
            detailTeamMoodViewModel.getInstance().getOneTeamMooReomote(Const.TEAMNAMEOFDETAIL);
            detailTeamMoodViewModel.getOneTeamMoodResponse().observe(this, new Observer<List<TeamMoodPojo>>() {
                @Override
                public void onChanged(List<TeamMoodPojo> teamMoodPojo) {
                    teamMoods = TeamMoodTransformer.toTeamModelList(teamMoodPojo);
                    detailTeamMoodAdapter.setTeamMoodModelList(teamMoods);
                    detailTeamMoodAdapter.notifyDataSetChanged();
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
        detailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailTeamMoodAdapter = new DetailTeamMoodAdapter(this,teamMoods);
        detailRecyclerView.setAdapter(detailTeamMoodAdapter);
    }

   void openDepictGraph(View view, String team_nameTD ){
        Const.TEAMNAMEDEPICTGRAPH = team_nameTD;
        Intent intent = new Intent(TeamDetailActivity.this, GraphActivity.class);
        startActivity(intent);
    }
}
