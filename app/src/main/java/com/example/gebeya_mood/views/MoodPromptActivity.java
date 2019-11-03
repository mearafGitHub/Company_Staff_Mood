package com.example.gebeya_mood.views;

import androidx.annotation.NonNull;

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
import com.example.gebeya_mood.viewmodels.UserMoodViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MoodPromptActivity extends BaseActivity {

    //@BindView(R.id.happyMood)
    private ImageButton happyMood;
   // @BindView(R.id.sadMood)
    private ImageButton sadMood;
   // @BindView(R.id.mehMood)
    private ImageButton contentMood;
   // @BindView(R.id.angryMood)
    private ImageButton angryMood;
  //  @BindView(R.id.whateverMood)
    private ImageButton neutralMood;

    private LottieAnimationView money;
    private LottieAnimationView staff;
    private LottieAnimationView deal;
    private LottieAnimationView health;
    private LottieAnimationView weather;
    private LottieAnimationView work;

   protected Button go, skip;
   protected ImageButton cancel;
   protected Dialog why;

   protected String moodValue;
   protected String moodReson;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prompt);

        happyMood = findViewById(R.id.happyMood);
        sadMood = findViewById(R.id.sadMood);
        contentMood = findViewById(R.id.mehMood);
        angryMood = findViewById(R.id.disappointedMood);
        neutralMood = findViewById(R.id.neutral);

        health = findViewById(R.id.helth);
        work = findViewById(R.id.work);
        staff = findViewById(R.id.staff);
        money = findViewById(R.id.money);
        weather = findViewById(R.id.weather);
        deal = findViewById(R.id.deal);


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

    public void moodDialogAlert(String mood){
        why = new Dialog(MoodPromptActivity.this);
        why.setContentView(R.layout.activity_mood_submit);
        why.setTitle(mood);

        go = why.findViewById(R.id.goModalButton);
        skip = why.findViewById(R.id.skipModalButton);
        cancel = why.findViewById(R.id.cancelModalButton);

        go.setEnabled(true);
        skip.setEnabled(true);
        cancel.setEnabled(true);

        health.setEnabled(true);
        work.setEnabled(true);
        staff.setEnabled(true);
        money.setEnabled(true);
        weather.setEnabled(true);
        deal.setEnabled(true);
        /*

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
*/

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //send to api
              /*  UserMood userMood = new UserMood(
                        "userId",
                        "UserPojoHelper Name",
                        "Team Name",
                        moodValue,
                        123,
                        "01,11,2019",
                        moodReson)*/;

               // String postMoodRes = UserMoodViewModel.getInstance().postUserMood(userMood);
              //  Toast.makeText(MoodPromptActivity.this, postMoodRes, Toast.LENGTH_LONG).show();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // make a toast & send the emoji to api
            /*    UserMood userMood = new UserMood(
                        "userId",
                        "UserPojoHelper Name",
                        "Team Name",
                        moodValue,
                        123,
                        "01,11,2019",
                        null);
*/
                // String postMoodRes = UserMoodViewModel.getInstance().postUserMood(userMood);
                // Toast.makeText(MoodPromptActivity.this, postMoodRes, Toast.LENGTH_LONG).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                why.cancel();
            }
        });

        why.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mood_list, menu);
        getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
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
