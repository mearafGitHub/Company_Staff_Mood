package com.example.gebeya_mood.views;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gebeya_mood.models.Mood;
import com.example.gebeya_mood.viewmodels.UserMoodViewModel;
import com.example.gebeya_mood.adapters.UserMoodsAdapter;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MoodsHomeActivity extends BaseActivity {
    private RecyclerView moodRecyclerView;
    private UserMoodsAdapter userMoodsAdapter;
    private UserMoodViewModel userMoodViewModel;
    private List<Mood> moods;

    //moodRecyclerView = findViewById(R.id.homeRecyclerView);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        moods = new ArrayList<>();
        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);


      /*  moodReportItems.add(new UserMoodViewModel("Managers Team", "Tired", "4", "5", "Oct 18, 2019",R.drawable.ic_emoticon_confused));
        moodReportItems.add(new UserMoodViewModel("Android Developers", "Cool", "6", "7", "Oct 18, 2019",R.drawable.ic_emoticon_cool));
        moodReportItems.add(new UserMoodViewModel("Trainers Team", "Normal", "5", "9", "Oct 18, 2019",R.drawable.ic_emoticon_neutral));
        moodReportItems.add(new UserMoodViewModel("Human Resource", "Unhappy", "2", "3", "Oct 18, 2019",R.drawable.ic_emoticon_sad));
        moodReportItems.add(new UserMoodViewModel("Back-End Developers", "Excited", "9", "11", "Oct 18, 2019",R.drawable.ic_emoticon_excited));
        moodReportItems.add(new UserMoodViewModel("Front-End Developers", "Well!", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_happy));
        moodReportItems.add(new UserMoodViewModel("Consultants Team", "Cool", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_cool));

*/
        userMoodsAdapter = new UserMoodsAdapter(this, moods );
        moodRecyclerView.setAdapter(userMoodsAdapter);
        moodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                Intent intentPrompt = new Intent(MoodsHomeActivity.this, MoodPromptActivity.class);
                startActivity(intentPrompt);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(MoodsHomeActivity.this, MyMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            case R.id.adminDataSetIcon:
                Intent intentAdminView = new Intent(MoodsHomeActivity.this, AdminActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
