package com.example.gebeya_mood;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.views.OAuthActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class GebeyaIntro extends BaseActivity {

   private ViewPager viewPager;
   private IntroViewPageAdapter introPageAdapter;
   private TabLayout tab;
   private Button buttonGo;
   private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_intro);
        buttonGo = findViewById(R.id.GoButton);
        tab = findViewById(R.id.tab);

        // populate the list of screens here

        List<IntroScreenItem> screens = new ArrayList<>();
        screens.add(new IntroScreenItem("Gebeaya Mood", "Made for and by Gebeya Inc. We care about how you feel about everything in Gebeya. Enjoy sharing your mood while working with your colleagues at Gebeya Inc. ", R.drawable.gebeya1));
        screens.add(new IntroScreenItem("Hi! I'm Chad. Nice to meet you.", "I will check on you to see how you are feeling. I also will record you emotions so that you can remember your moods a while ago.", R.drawable.gebeya3));
        screens.add(new IntroScreenItem("Sign Up to use", "Sign up to meet Chad. Your finger print will be required as a password. Please note that your moods will be reviewed by a person in charge to see closely what to improve about Gebeya to make you comfortable at Gebeya.", R.drawable.ic_fp_big));
        screens.add(new IntroScreenItem("Team mood.", "In the common screen you can see your colleagues teams mood.", R.drawable.gebeya2));

        // here hood the viewpager
        viewPager = findViewById(R.id.screen_Pager);
        introPageAdapter = new IntroViewPageAdapter(this, screens);
        viewPager.setAdapter(introPageAdapter);

        // hook up with the view pager
        tab.setupWithViewPager(viewPager);

        buttonGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(GebeyaIntro.this, OAuthActivity.class);
            startActivity(intent);
            finish();

            }
        });
    }
}
