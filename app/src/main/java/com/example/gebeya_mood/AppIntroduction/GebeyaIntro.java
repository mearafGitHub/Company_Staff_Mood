package com.example.gebeya_mood.AppIntroduction;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.google.android.material.tabs.TabLayout;

public class GebeyaIntro extends BaseActivity {
   private ViewPager viewPager;
   private IntroViewPageAdapter introPageAdapter;
   private TabLayout tab;
   private Button buttonGo;
   private int position;
   private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_intro);

        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.SEEN_INTRO, false);
        if (seen) {
        showViews(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.SEEN_INTRO, true);
            editor.apply();
            showViews(null);
        }
    }

    protected void showViews(View view){
        buttonGo = findViewById(R.id.GoButton);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.screen_Pager);
        introPageAdapter = new IntroViewPageAdapter(this, Const.IntroContent());
        viewPager.setAdapter(introPageAdapter);
        tab.setupWithViewPager(viewPager);

        buttonGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAuth(null);
            }
        });
    }
   protected void openAuth(View view){
       Intent intent = new Intent(GebeyaIntro.this, MainActivity.class);
       startActivity(intent);
       finish();
    }
}
