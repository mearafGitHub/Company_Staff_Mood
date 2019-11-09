package com.example.gebeya_mood.UserMood;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.gebeya_mood.GebeyaMoodGeneral.GebeyaAllTeamMoodsActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoodPromptActivity extends BaseActivity {
    private UserMoodViewModel  userMoodViewModel;

    @BindView(R.id.happy)
    public LottieAnimationView happy;

    @BindView(R.id.sad)
    public LottieAnimationView sad;

    @BindView(R.id.content)
    public LottieAnimationView content;

    @BindView(R.id.angry)
    public LottieAnimationView angry;

  @BindView(R.id.neutral)
   public LottieAnimationView neutral;
   protected Button go, skip;
   protected ImageButton cancel;
   protected Dialog why;
   protected String moodValue;
   protected String moodReson;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prompt);
        ButterKnife.bind(this);
        moodValue = "";
        happy = findViewById(R.id.happy);
        sad = findViewById(R.id.sad);
        angry = findViewById(R.id.angry);
        neutral = findViewById(R.id.neutral);
        content = findViewById(R.id.content);
        stickBottomNav();
        happy.setEnabled(true);
        sad.setEnabled(true);
        angry.setEnabled(true);
        neutral.setEnabled(true);
        content.setEnabled(true);

        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Happy";
                Toast.makeText(MoodPromptActivity.this, " Glad you're happy.. ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Sad";
                Toast.makeText(MoodPromptActivity.this, " Sorry you're sad. What happened? ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Content";
                Toast.makeText(MoodPromptActivity.this, " Content, it is! ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Angry";
                Toast.makeText(MoodPromptActivity.this, " Angry? Oh, what happened? ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Neutral";
                Toast.makeText(MoodPromptActivity.this, " Ok, you're neutral about something. ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    public void stickBottomNav(){

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_nav:
                        Intent intent = new Intent(MoodPromptActivity.this, GebeyaAllTeamMoodsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.info_nav:
                        Intent intentI = new Intent(MoodPromptActivity.this, AdminActivity.class);
                        startActivity(intentI);
                        break;
                    case R.id.my_moods_nav:
                        Intent intentM = new Intent(MoodPromptActivity.this, UserMoodsActivity.class);
                        startActivity(intentM);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mood_list, menu);
        getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.listIcon:
                Intent intent = new Intent(MoodPromptActivity.this, GebeyaAllTeamMoodsActivity.class);
                startActivity(intent);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(MoodPromptActivity.this, UserMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void openSubmit(View v, String moodValue){
        Intent intent = new Intent(this, MoodSubmitActivity.class);
        intent.putExtra("moodValue", moodValue);
        startActivity(intent);
    }

}
