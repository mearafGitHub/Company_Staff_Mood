package com.example.gebeya_mood.views;

import androidx.annotation.NonNull;
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
import com.example.gebeya_mood.adapters.AdminViewAdapter;
import com.example.gebeya_mood.adapters.AdminViewHolder;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.models.TeamMood;
import com.example.gebeya_mood.viewmodels.TeamMoodViewModel;

import java.util.List;

public class AdminActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, AdminViewHolder.OnTeamMoodListener {
    Context context;
    int activityNum = 2;
    RecyclerView adminRecyclerView;
    AdminViewAdapter adminAdapter;
    List<TeamMood> teamMoods;
    TeamMoodViewModel teamMoodViewModel;

    private String filterByDate, filterByTeam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Spinner filterMood = findViewById(R.id.mood_filter);
        Spinner teamFilter = findViewById(R.id.team_filter);
        adminRecyclerView = findViewById(R.id.adminRecycler);

        teamMoodViewModel.getInstance().getAllTeamMood();
        // TODO: OBSERVER

// Spinners
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
    }

    private void initRecycler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adminRecyclerView.setLayoutManager(linearLayoutManager);
        adminAdapter = new AdminViewAdapter(this, teamMoods);
        adminRecyclerView.setAdapter(adminAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        // send and filter by choice to api and display result
        switch (choice){
            case "Week" :
                filterByDate = choice;
                break;
            case "day":
                filterByDate = choice;
                break;
            case "Month":
                filterByDate = choice;
            case "Year" :
                filterByDate = choice;
                break;
            case "Staff" :
                filterByTeam = choice;
                break;
            case "Talent":
                filterByTeam = choice;
            case "Student" :
                filterByTeam = choice;
                break;
            case "Contractor":
                filterByTeam = choice;
                break;
            case "Investor" :
                filterByTeam = choice;
                break;
             default:
                 break;
        }
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
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
                Intent intentAdminView = new Intent(AdminActivity.this, GebeyaAllTeamMoodsActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public AdminViewAdapter getAdminAdapter() {
        return adminAdapter;
    }


}
