package com.example.gebeya_mood.Admin;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamDetailActivity;
import com.example.gebeya_mood.TeamMood.TeamMoodAdapter;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodDao;
import com.example.gebeya_mood.TeamMood.TeamMoodTransformer;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;
import com.example.gebeya_mood.TeamMood.GebeyaAllTeamMoodsActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, AdminViewHolder.OnTeamMoodListener {
    Context context;
    int activityNum = 2;
    RecyclerView adminRecyclerView;
    AdminViewAdapter adminAdapter;
    List<TeamMood> teamMoods;
    TeamMoodDao teamMoodDao;
    TeamMoodViewModel teamMoodViewModel;
    TeamMoodAdapter teamMoodAdapter;
    private String filterByDate, filterByTeam;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Spinner filterMood = findViewById(R.id.mood_filter);
        Spinner teamFilter = findViewById(R.id.team_filter);
        adminRecyclerView = findViewById(R.id.adminRecycler);
        teamMoodAdapter = new TeamMoodAdapter(this, new ArrayList<>());

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterMood.setAdapter(arrayAdapter);
        filterMood.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> teamArrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.team_filter,
                android.R.layout.simple_spinner_item);

        teamArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamFilter.setAdapter(teamArrayAdapter);
        teamFilter.setOnItemSelectedListener(this);

        try{
            teamMoodViewModel.getInstance().getAllTeamMood();
            teamMoodViewModel.getAllTeamMoodsResponseM().observe(this, new Observer<List<TeamMoodPojo>>() {
                @Override
                public void onChanged(List<TeamMoodPojo> teamMoodPojo) {
                    teamMoods = TeamMoodTransformer.toTeamModelList(teamMoodPojo);
                    teamMoodAdapter.setTeamMoodModelList(teamMoods);
                    teamMoodAdapter.notifyDataSetChanged();
                    teamMoodDao.addMoods(teamMoods);
                }
            });
        }catch (Exception e){ e.printStackTrace();}
        initRecycler();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        switch (choice){
            case "day":
                filterByDate = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                break;
            case "Month":
                filterByDate = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
            case "Staff" :
                filterByTeam = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                break;
            case "Talent":
                filterByTeam = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
            case "Trainee" :
                filterByTeam = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                break;
            case "Year" :
                filterByDate = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                break;
            case "Investor" :
                filterByTeam = choice;
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                break;
             default:
                 teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                 break;
        }
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
        teamMoodViewModel.filteredTeamMoods().observe(this, new Observer<List<TeamMoodPojo>>() {
            @Override
            public void onChanged(List<TeamMoodPojo> teamMoodPojo) {
                teamMoods= TeamMoodTransformer.toTeamModelList(teamMoodPojo);
                teamMoodAdapter.setTeamMoodModelList(teamMoods);
                teamMoodAdapter.notifyDataSetChanged();
                teamMoodDao.addMoods(teamMoods);
            }
        });
        initRecycler();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.adminLisIcon:
                Intent intentAdminView = new Intent(AdminActivity.this, TeamDetailActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initRecycler() {
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adminAdapter = new AdminViewAdapter(this, teamMoods);
        adminRecyclerView.setAdapter(adminAdapter);
    }

    public AdminViewAdapter getAdminAdapter() {
        return adminAdapter;
    }
}
