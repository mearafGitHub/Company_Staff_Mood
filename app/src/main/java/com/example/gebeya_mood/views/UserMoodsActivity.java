package com.example.gebeya_mood.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.adapters.UserMoodsAdapter;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.adapters.TeamMoodAdapter;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.viewmodels.TeamMoodViewModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserMoodsActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
   public static final int activityNum = 1;
    public RecyclerView userMoodRecycler;
    public UserMoodsAdapter userMoodAdapter;
    public List<UserMood> userMoodItems;
    private Context context;

    @SerializedName("name")
    TextView userName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moods);

        userMoodRecycler = findViewById(R.id.userMoodRecycler);
        userMoodItems = new ArrayList<>();


        Spinner filterMood = findViewById(R.id.mood_filter);

        userName = findViewById(R.id.my_user_name);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterMood.setAdapter(arrayAdapter);
        filterMood.setOnItemSelectedListener(this);


        userMoodAdapter = new UserMoodsAdapter(this, userMoodItems);
        userMoodRecycler.setAdapter(userMoodAdapter);
        userMoodRecycler.setLayoutManager(new LinearLayoutManager(this));


        // TODO: API CONNECTION USERMOOD-VIEWMODEL

        // TODO: Get UserPojoHelper from LOCAL DB / API
        /*   getUsersCall();

        //  TODO: Get USER Moods Here
                getMoodsCall();
         */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        //TODO: FILTER THE DISPLAY DUE TO THE FILTER OPTION CHOSEN
        // filter by choice to api and display result
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
