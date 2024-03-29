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
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.gebeya_mood.GebeyaMoodGeneral.GebeyaGeneralMoodActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.framework.util.Temporary;
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

    @BindView(R.id.promptTitle)
    public TextView promptTitle;

  @BindView(R.id.neutral)
   public LottieAnimationView neutral;
   protected Button go, skip;
   protected ImageButton cancel;
   protected Dialog why;
   protected String moodValue;
   protected String moodReason;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prompt);
        ButterKnife.bind(this);
        promptTitle = findViewById(R.id.promptTitle);
        moodValue = "";
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
        promptTitle.append("user name");

        userMoodViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserMoodViewModel.class);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temporary.USERMOOD = "Happy";
                Toast.makeText(MoodPromptActivity.this, " Glad you're happy.. ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temporary.USERMOOD  = "Sad";
                Toast.makeText(MoodPromptActivity.this, " Sorry you're sad. What happened? ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temporary.USERMOOD = "Content";
                Toast.makeText(MoodPromptActivity.this, " Content, it is! ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temporary.USERMOOD  = "Angry";
                Toast.makeText(MoodPromptActivity.this, " Angry? Oh, what happened? ", Toast.LENGTH_LONG).show();
                openSubmit(null, moodValue );
            }
        });

        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Temporary.USERMOOD = "Neutral";
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
                Intent intent = new Intent(MoodPromptActivity.this, GebeyaGeneralMoodActivity.class);
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
       // intent.putExtra("moodValue", moodValue);
        startActivity(intent);
    }

}
