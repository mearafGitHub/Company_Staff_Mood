package com.example.gebeya_mood.views;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
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
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.models.UserMood;
import com.example.gebeya_mood.pojos.UserMoodGETPojo;
import com.example.gebeya_mood.viewmodels.UserMoodViewModel;
import com.example.gebeya_mood.viewmodels.UserViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MoodPromptActivity extends BaseActivity {
    private UserMoodViewModel  userMoodViewModel;

    //@BindView(R.id.happy)
    public LottieAnimationView happy;

  // @BindView(R.id.sad)
   public LottieAnimationView sad;

    //@BindView(R.id.content)
    public LottieAnimationView content;

  //  @BindView(R.id.angry)
    public LottieAnimationView angry;

   //@BindView(R.id.neutral)
   public LottieAnimationView neutral;

   // lottie

    //@BindView(R.id.money)
    public LottieAnimationView money;

   // @BindView(R.id.staff)
    public LottieAnimationView staff;

    //@BindView(R.id.deal)
    public LottieAnimationView deal;

   // @BindView(R.id.helth)
    public LottieAnimationView health;

    //@BindView(R.id.weather)
    public LottieAnimationView weather;

   // @BindView(R.id.work)
    public LottieAnimationView work;

    public Dialog modalDalogue;

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
        // anim buttons
      //  why =  findViewById(R.layout.activity_mood_submit);
        happy = findViewById(R.id.happy);
        sad = findViewById(R.id.sad);
        angry = findViewById(R.id.angry);
        neutral = findViewById(R.id.neutral);
        content = findViewById(R.id.content);

        happy.setEnabled(true);
        sad.setEnabled(true);
        angry.setEnabled(true);
        neutral.setEnabled(true);
        content.setEnabled(true);

        health = findViewById(R.id.helth);
        work = findViewById(R.id.work);
        staff = findViewById(R.id.staff);
        money = findViewById(R.id.money);
        weather = findViewById(R.id.weather);
        deal = findViewById(R.id.deal);

        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Happy";
              //  moodDialogAlert("Happy");
                Toast.makeText(MoodPromptActivity.this, " Glad you're happy.. ", Toast.LENGTH_LONG).show();
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Sad";
                moodDialogAlert("Sad");
                Toast.makeText(MoodPromptActivity.this, " Sorry you're sad. What happened? ", Toast.LENGTH_LONG).show();
            }
        });

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Content";
              //  moodDialogAlert("Content");
                Toast.makeText(MoodPromptActivity.this, " Content, it is! ", Toast.LENGTH_LONG).show();
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Angry";
               // moodDialogAlert("Angry");
                Toast.makeText(MoodPromptActivity.this, " Angry? Oh, what happened? ", Toast.LENGTH_LONG).show();
            }
        });

        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Neutral";
               // moodDialogAlert("Neutral");
                Toast.makeText(MoodPromptActivity.this, " Ok, you're neutral about something. ", Toast.LENGTH_LONG).show();
            }
        });

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodValue = "Content";
                // moodDialogAlert(moodValue);
                Toast.makeText(MoodPromptActivity.this, " Content.. ", Toast.LENGTH_LONG).show();
            }
        });

        stickBottomNav();

    }
    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    public void moodDialogAlert(String mood){
        why = new Dialog(this);
        why.setContentView(R.layout.activity_mood_submit);
        why.setTitle(mood);

        go = why.findViewById(R.id.goModalButton);
        skip = why.findViewById(R.id.skipModalButton);
        cancel = why.findViewById(R.id.cancelModalButton);

        go.setEnabled(true);
        skip.setEnabled(true);
        cancel.setEnabled(true);
        why.show();

//        health.setEnabled(true);
       // work.setEnabled(true);
       // staff.setEnabled(true);
       // money.setEnabled(true);
      //  weather.setEnabled(true);
       // deal.setEnabled(true);

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "health";
                Toast.makeText(MoodPromptActivity.this, " Health.. ", Toast.LENGTH_LONG).show();
            }
        });


        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "work";
                Toast.makeText(MoodPromptActivity.this, " Job is done ! ", Toast.LENGTH_LONG).show();
            }
        });

        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "Deal";
                Toast.makeText(MoodPromptActivity.this, " About an important Deal ! ", Toast.LENGTH_LONG).show();
            }
        });

        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "Money";
                Toast.makeText(MoodPromptActivity.this, "Got Paid", Toast.LENGTH_LONG).show();
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "Weather";
                Toast.makeText(MoodPromptActivity.this, "Angry? What's it?", Toast.LENGTH_LONG).show();
            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodReson = "Staff";
                Toast.makeText(MoodPromptActivity.this, " A staff Member.. ", Toast.LENGTH_LONG).show();
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObject newUesrMood = new JsonObject();
                newUesrMood.addProperty("id","id");
                newUesrMood.addProperty("name", "name");
                newUesrMood.addProperty("mood", "mood");
                newUesrMood.addProperty("reason", "reson");

                userMoodViewModel.postUserMood(newUesrMood);
                observeData();
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

                userMoodViewModel.postUserMood(newUesrMood);
                observeData();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                why.cancel();
            }
        });

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

   protected void observeData(){
        userMoodViewModel.postUserMoodResponse().observe(this, new Observer<UserMoodGETPojo>() {
            @Override
            public void onChanged(UserMoodGETPojo userMoodGETPojo) {
                String check = String.valueOf(userMoodGETPojo);
                Toast.makeText(MoodPromptActivity.this, "Sent mood successfully.", Toast.LENGTH_LONG).show();
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

}
