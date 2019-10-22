package com.example.gebeya_mood.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gebeya_mood.moodhome.MoodReportItemModel;
import com.example.gebeya_mood.moodhome.MoodsReportAdapter;
import com.example.gebeya_mood.R;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    RecyclerView adminRecyclerView;
    MoodsReportAdapter moodsReportAdapter;
    List<MoodReportItemModel> moodReportItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Spinner filterMood = findViewById(R.id.mood_filter);
        Spinner teamFilter = findViewById(R.id.team_filter);

        adminRecyclerView = findViewById(R.id.adminRecycler);
        moodReportItems = new ArrayList<>();

        moodReportItems.add(new MoodReportItemModel("Managers Team", "Tired", "4", "5", "Oct 18, 2019",R.drawable.ic_emoticon_confused));
        moodReportItems.add(new MoodReportItemModel("Android Developers", "Cool", "6", "7", "Oct 18, 2019",R.drawable.ic_emoticon_cool));
        moodReportItems.add(new MoodReportItemModel("Trainers Team", "Normal", "5", "9", "Oct 18, 2019",R.drawable.ic_emoticon_neutral));
        moodReportItems.add(new MoodReportItemModel("Human Resource", "Unhappy", "2", "3", "Oct 18, 2019",R.drawable.ic_emoticon_sad));
        moodReportItems.add(new MoodReportItemModel("Back-End Developers", "Excited", "9", "11", "Oct 18, 2019",R.drawable.ic_emoticon_excited));
        moodReportItems.add(new MoodReportItemModel("Front-End Developers", "Well!", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_happy));
        moodReportItems.add(new MoodReportItemModel("Consultants Team", "Cool", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_cool));


        moodsReportAdapter = new MoodsReportAdapter(this, moodReportItems);
        adminRecyclerView.setAdapter(moodsReportAdapter);
        adminRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        // send and filter by choice to api and display result
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
        switch(item.getItemId()){
            case R.id.adminLisIcon:
                Intent intentAdminView = new Intent(AdminActivity.this, AdminActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
