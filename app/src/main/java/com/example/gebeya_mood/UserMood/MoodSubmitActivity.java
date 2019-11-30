package com.example.gebeya_mood.UserMood;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.framework.util.Temporary;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoodSubmitActivity extends BaseActivity {

    @BindView(R.id.money)
    public ImageButton money;

    @BindView(R.id.staff)
    public ImageButton staff;

    @BindView(R.id.deal)
    public ImageButton deal;

    @BindView(R.id.helth)
    public ImageButton health;

    @BindView(R.id.done)
    public ImageButton done;

    @BindView(R.id.internet)
    public ImageButton internet;

    @BindView(R.id.bubble)
    public ImageButton bubble;

    @BindView(R.id.weather)
    public ImageButton weather;

    @BindView(R.id.goModalButton)
    public Button go;

    @BindView(R.id.meeting)
    public ImageButton meeting;

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
       // moodValue = intent.getExtras().getString("moodValue");
        moodReason = "unsaid";
        //moodValue = "not given";
        meeting = findViewById(R.id.meeting);
        internet = findViewById(R.id.internet);
        go = findViewById(R.id.goModalButton);
        skip = findViewById(R.id.skipModalButton);
        go.setEnabled(true);
        skip.setEnabled(true);
        health = findViewById(R.id.helth);;
        staff = findViewById(R.id.staff);
        bubble = findViewById(R.id.bubble);
        done = findViewById(R.id.done);
        money = findViewById(R.id.money);
        weather = findViewById(R.id.weather);
        deal = findViewById(R.id.deal);
        moodText = findViewById(R.id.moodText);
        moodText.setText(Temporary.USERMOOD );

        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "internet";
                Toast.makeText(MoodSubmitActivity.this, " Internet connection ", Toast.LENGTH_LONG).show();
            }
        });

        meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "meeting";
                Toast.makeText(MoodSubmitActivity.this, " Meeting ", Toast.LENGTH_LONG).show();
            }
        });

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
                moodReason = "Money";
                Toast.makeText(MoodSubmitActivity.this, "Money", Toast.LENGTH_LONG).show();
            }
        });

        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Deal";
                Toast.makeText(MoodSubmitActivity.this, "Deal", Toast.LENGTH_LONG).show();
            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Money";
                Toast.makeText(MoodSubmitActivity.this, "Money", Toast.LENGTH_LONG).show();
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReason = "Weather";
                Toast.makeText(MoodSubmitActivity.this, "Weather", Toast.LENGTH_LONG).show();
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
                JsonObject newUserMood = new JsonObject();
                newUserMood.addProperty("id",Const.USER_ID);
                newUserMood.addProperty("name", Const.USERNAME);
                newUserMood.addProperty("mood", moodValue);
                newUserMood.addProperty("reason", moodReason);
                sendMoodtoApi(newUserMood);
            }
        });
    }

    protected void observeData(){
        try {
            userMoodViewModel.postUserMoodResponse().observe(this, new Observer<UserMoodGETPojo>() {
                @Override
                public void onChanged(UserMoodGETPojo userMoodGETPojo) {
                    String check = String.valueOf(userMoodGETPojo);
                    Log.i("post mood response", check);
                    if(check != null) {
                        Toast.makeText(MoodSubmitActivity.this, "Sent your mood successfully.", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MoodSubmitActivity.this, "Oops! Something went wrong.", Toast.LENGTH_LONG).show();
                    }
                }

            });
        }
        catch(Exception e){ e.printStackTrace();}
    }

   void sendMoodtoApi(JsonObject newUserMood){
            try {
                userMoodViewModel.postUserMood(newUserMood);
                observeData();
            }
            catch(Exception e){
                e.printStackTrace();
                Toast.makeText(MoodSubmitActivity.this, "Oops! Something went wrong.", Toast.LENGTH_LONG).show();
            }
    }

}
