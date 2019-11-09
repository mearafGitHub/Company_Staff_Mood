package com.example.gebeya_mood.Admin;

// https://www.scichart.com/getting-started/    chart drawer (paid)
// Admin Credentials: email: "admin@gebeyamood.com", password: "admin_pass"
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
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
import com.example.gebeya_mood.UserMood.MoodSubmitActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodDao;
import com.example.gebeya_mood.TeamMood.TeamMoodTransformer;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;
import com.example.gebeya_mood.TeamMood.GebeyaAllTeamMoodsActivity;
import com.example.gebeya_mood.framework.util.Const;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, AdminViewHolder.OnTeamMoodListener {
    Context context;
    int activityNum = 2;
    RecyclerView adminRecyclerView;
    AdminViewAdapter adminAdapter;
    List<TeamMood> teamMoods;
    TeamMoodDao teamMoodDao;
    MutableLiveData<List<TeamMoodPojo>> teamMoodResponse;
    TeamMoodViewModel teamMoodViewModel;
    TeamMoodAdapter teamMoodAdapter;
    private String filterByDate, filterByTeam;
    int listSize;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Spinner filterMood = findViewById(R.id.mood_filter);
        Spinner teamFilter = findViewById(R.id.team_filter);
        adminRecyclerView = findViewById(R.id.adminRecycler);
        teamMoodAdapter = new TeamMoodAdapter(this, new ArrayList<>());

        ArrayAdapter<CharSequence> byDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        byDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterMood.setAdapter(byDateAdapter);
        filterMood.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> byTeamAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.team_filter,
                android.R.layout.simple_spinner_item);
        byTeamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamFilter.setAdapter(byTeamAdapter);
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
                    listSize = teamMoodPojo.size();
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
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}
                break;
            case "Month":
                filterByDate = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

            case "Staff" :
                filterByTeam = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

            case "Talent":
                filterByTeam = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

            case "Trainee" :
                filterByTeam = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

            case "Year" :
                filterByDate = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

            case "Investor" :
                filterByTeam = choice;
                try{
                teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                }catch (Exception e){e.printStackTrace();}

             default:
                 try{
                 teamMoodViewModel.getAllTeamMooFilterd(filterByTeam, filterByDate);
                 teamMoodResponse = teamMoodViewModel.filteredTeamMoods();
                 }catch (Exception e){e.printStackTrace();}

        }
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
        try{
        teamMoodResponse.observe(this, new Observer<List<TeamMoodPojo>>() {
            @Override
            public void onChanged(List<TeamMoodPojo> teamMoodPojo) {
                teamMoods = TeamMoodTransformer.toTeamModelList(teamMoodPojo);
                teamMoodAdapter.setTeamMoodModelList(teamMoods);
                teamMoodAdapter.notifyDataSetChanged();
                teamMoodDao.addMoods(teamMoods);
            }
        });
        }catch (Exception e){e.printStackTrace();}
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
                //put the clicked item team name in the constants class
                Const.TEAMNAMEOFDETAIL = filterByTeam;
                Intent intentDetail= new Intent(AdminActivity.this, TeamDetailActivity.class);
                startActivity(intentDetail);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void initRecycler() {
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adminAdapter = new AdminViewAdapter(this,teamMoods);
        adminRecyclerView.setAdapter(adminAdapter);
    }

}
