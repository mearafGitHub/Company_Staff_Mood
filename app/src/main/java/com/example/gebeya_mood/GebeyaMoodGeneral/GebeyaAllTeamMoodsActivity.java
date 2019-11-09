package com.example.gebeya_mood.GebeyaMoodGeneral;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodAdapter;
import com.example.gebeya_mood.TeamMood.TeamMoodDao;
import com.example.gebeya_mood.TeamMood.TeamMoodPojo;
import com.example.gebeya_mood.TeamMood.TeamMoodTransformer;
import com.example.gebeya_mood.TeamMood.TeamMoodViewModel;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
import com.example.gebeya_mood.UserMood.UserMoodsActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GebeyaAllTeamMoodsActivity extends BaseActivity {
    private RecyclerView teamMoodRecyclerView;
    private TeamMoodAdapter teamMoodsAdapter;
    public TeamMoodViewModel teamMoodViewModel;
    private List<TeamMood> teamMoods;
    private Context context;
    public TeamMoodDao teamMoodDao;

    @BindView(R.id.mood_filter_byDate)
    public Spinner filterByDate;

    String filterValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_all_team_mood);
        ButterKnife.bind(this);
        teamMoodViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(TeamMoodViewModel.class);
        filterByDate = findViewById(R.id.mood_filter_byDate);

        ArrayAdapter<CharSequence> byDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.general_date_filter,
                android.R.layout.simple_spinner_item);
        byDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterByDate.setAdapter(byDateAdapter);

        try{
            teamMoodViewModel.getAllTeamMood().observe(this, new Observer<List<TeamMoodPojo>>() {
                @Override
                public void onChanged(List<TeamMoodPojo> teamMoodPojos) {
                    List<TeamMood> teamMoods = TeamMoodTransformer.toTeamModelList(teamMoodPojos);
                    teamMoodDao.addMoods(teamMoods);
                }
            });

        } catch(Exception e){
            e.printStackTrace();
        }
        //initRecycler();
    }

    private void initRecycler() {
        teamMoodsAdapter = new TeamMoodAdapter(this, teamMoods);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        teamMoodRecyclerView.setLayoutManager(linearLayoutManager);
        teamMoodsAdapter = new TeamMoodAdapter(this, teamMoods);
        teamMoodRecyclerView.setAdapter(teamMoodsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mood_promt_menu, menu);
        getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        getMenuInflater().inflate(R.menu.admin_data_set, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.moodsPromptIcon:
                Intent intentPrompt = new Intent(GebeyaAllTeamMoodsActivity.this, MoodPromptActivity.class);
                startActivity(intentPrompt);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(GebeyaAllTeamMoodsActivity.this, UserMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            case R.id.adminDataSetIcon:
                Intent intentAdminView = new Intent(GebeyaAllTeamMoodsActivity.this, AdminActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
