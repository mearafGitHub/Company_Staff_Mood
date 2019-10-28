package com.example.gebeya_mood.moodhome;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gebeya_mood.data.moodsData.Mood;
import com.example.gebeya_mood.moodPrompt.MoodPromptActivity;
import com.example.gebeya_mood.mymoods.MyMoodsActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.admin.AdminActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MoodsHomeActivity extends BaseActivity {
    private RecyclerView moodRecyclerView;
    private MoodsAdapter moodsAdapter;
    private MoodViewModel moodViewModel;
    private List<Mood> moods;

    //moodRecyclerView = findViewById(R.id.homeRecyclerView);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        moods = new ArrayList<>();
        moodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(MoodViewModel.class);


      /*  moodReportItems.add(new MoodViewModel("Managers Team", "Tired", "4", "5", "Oct 18, 2019",R.drawable.ic_emoticon_confused));
        moodReportItems.add(new MoodViewModel("Android Developers", "Cool", "6", "7", "Oct 18, 2019",R.drawable.ic_emoticon_cool));
        moodReportItems.add(new MoodViewModel("Trainers Team", "Normal", "5", "9", "Oct 18, 2019",R.drawable.ic_emoticon_neutral));
        moodReportItems.add(new MoodViewModel("Human Resource", "Unhappy", "2", "3", "Oct 18, 2019",R.drawable.ic_emoticon_sad));
        moodReportItems.add(new MoodViewModel("Back-End Developers", "Excited", "9", "11", "Oct 18, 2019",R.drawable.ic_emoticon_excited));
        moodReportItems.add(new MoodViewModel("Front-End Developers", "Well!", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_happy));
        moodReportItems.add(new MoodViewModel("Consultants Team", "Cool", "3", "4", "Oct 18, 2019",R.drawable.ic_emoticon_cool));

*/
        moodsAdapter = new MoodsAdapter(this, moods );
        moodRecyclerView.setAdapter(moodsAdapter);
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
