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
import com.example.gebeya_mood.Mood.Mood;
import com.example.gebeya_mood.Mood.MoodTranfromer;
import com.example.gebeya_mood.Mood.MoodsCountPojo;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GebeyaAllTeamMoodsActivity extends BaseActivity {
    @BindView(R.id.generalRecyclerView)
    public RecyclerView teamMoodRecyclerView;
    private TeamMoodAdapter teamMoodsAdapter;
    public GebeyaGeneralViewModel gebeyaGeneralViewModel;
    private List<TeamMood> teamMoods;
    private Context context;
    Mood generalMoods;

    @BindView(R.id.mood_filter_byDate)
    public Spinner filterByDate;

    String filterValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_all_team_mood);
        ButterKnife.bind(this);
        teamMoods = new ArrayList<>();
        teamMoodRecyclerView = findViewById(R.id.generalRecyclerView);
        gebeyaGeneralViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(GebeyaGeneralViewModel.class);
        filterByDate = findViewById(R.id.mood_filter_byDate);

        ArrayAdapter<CharSequence> byDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.general_date_filter,
                android.R.layout.simple_spinner_item);
        byDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterByDate.setAdapter(byDateAdapter);

        try{
            gebeyaGeneralViewModel.getGeneralMoods().observe(this, new Observer<MoodsCountPojo>() {
                @Override
                public void onChanged(MoodsCountPojo moodsCount) {
                    generalMoods = MoodTranfromer.toMood(moodsCount);
                }
            });

        } catch(Exception e){
            e.printStackTrace();
        }
        initRecycler();
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

    private void initRecycler() {
        teamMoodsAdapter = new TeamMoodAdapter(this, teamMoods);
        teamMoodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamMoodsAdapter = new TeamMoodAdapter(this, teamMoods);
        teamMoodRecyclerView.setAdapter(teamMoodsAdapter);
    }

}
