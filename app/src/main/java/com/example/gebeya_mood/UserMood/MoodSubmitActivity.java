package com.example.gebeya_mood.UserMood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoodSubmitActivity extends BaseActivity {

    @BindView(R.id.money)
    public LottieAnimationView money;

    @BindView(R.id.staff)
    public LottieAnimationView staff;

    @BindView(R.id.deal)
    public LottieAnimationView deal;

    @BindView(R.id.helth)
    public LottieAnimationView health;

    @BindView(R.id.done)
    public LottieAnimationView done;

    @BindView(R.id.bubble)
    public LottieAnimationView bubble;
/*

    @BindView(R.id.dashBoard)
    public LottieAnimationView dashBoard;
*/

    @BindView(R.id.weather)
    public LottieAnimationView weather;

   /* @BindView(R.id.work)
    public LottieAnimationView work;*/

    @BindView(R.id.goModalButton)
    public Button go;

    @BindView(R.id.skipModalButton)
    public Button skip;

    @BindView(R.id.moodText)
    public TextView moodText;

    protected String moodValue;
    protected String moodReason;
    private UserMoodViewModel userMoodViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_submit);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        moodValue = intent.getExtras().getString("moodValue");
        moodReason = "";
        go = findViewById(R.id.goModalButton);
        skip = findViewById(R.id.skipModalButton);
        go.setEnabled(true);
        skip.setEnabled(true);
        health = findViewById(R.id.helth);
       // work = findViewById(R.id.work);
        staff = findViewById(R.id.staff);
       // dashBoard = findViewById(R.id.dashBoard);
        bubble = findViewById(R.id.bubble);
        done = findViewById(R.id.done);
        money = findViewById(R.id.money);
        weather = findViewById(R.id.weather);
        deal = findViewById(R.id.deal);
        moodText = findViewById(R.id.moodText);
        moodText.setText(moodValue);

        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "health";
                Toast.makeText(MoodSubmitActivity.this, " Health.. ", Toast.LENGTH_LONG).show();
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "work";
                Toast.makeText(MoodSubmitActivity.this, " Job is done ! ", Toast.LENGTH_LONG).show();
            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "work";
                Toast.makeText(MoodSubmitActivity.this, " You got paid! ", Toast.LENGTH_LONG).show();
            }
        });



        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Deal";
                Toast.makeText(MoodSubmitActivity.this, " About an important Deal ! ", Toast.LENGTH_LONG).show();
            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Money";
                Toast.makeText(MoodSubmitActivity.this, "Got Paid", Toast.LENGTH_LONG).show();
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Weather";
                Toast.makeText(MoodSubmitActivity.this, "Got paid, right?!", Toast.LENGTH_LONG).show();
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Staff";
                Toast.makeText(MoodSubmitActivity.this, " A staff Member.. ", Toast.LENGTH_LONG).show();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject newUserMood = new JsonObject();
                newUserMood.addProperty("id","id");
                newUserMood.addProperty("name", "name");
                newUserMood.addProperty("mood", "mood");
                newUserMood.addProperty("reason", "reson");
                try {
                    userMoodViewModel.postUserMood(newUserMood);
                    observeData();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject newUesrMood = new JsonObject();
                newUesrMood.addProperty("id","id");
                newUesrMood.addProperty("name", "name");
                newUesrMood.addProperty("mood", "mood");
                newUesrMood.addProperty("reason", "unsaid");
                sendMoodtoApi(newUesrMood);
            }
        });
    }

    protected void observeData(){
        userMoodViewModel.postUserMoodResponse().observe(this, new Observer<UserMoodGETPojo>() {
            @Override
            public void onChanged(UserMoodGETPojo userMoodGETPojo) {
                String check = String.valueOf(userMoodGETPojo);
                Log.i("post mood response", check);
            }
        });
    }

   void sendMoodtoApi(JsonObject newUesrMood){
            try {
                userMoodViewModel.postUserMood(newUesrMood);
                observeData();
                Toast.makeText(MoodSubmitActivity.this, "Sent mood successfully.", Toast.LENGTH_LONG).show();
            }
            catch(Exception e){
                e.printStackTrace();
                Toast.makeText(MoodSubmitActivity.this, "Oops! Something went wrong.", Toast.LENGTH_LONG).show();
            }
    }

}
