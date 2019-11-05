package com.example.gebeya_mood.views;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

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
            openAuth(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.SEEN_INTRO, true);
            editor.apply();
            showViews();
        }
    }

    protected void showViews(){

        buttonGo = findViewById(R.id.GoButton);
        tab = findViewById(R.id.tab);

        List<IntroScreenItem> screens = new ArrayList<>();
        screens.add(new IntroScreenItem("Gebeaya Mood", "Made for and by Gebeya Inc. We care about how you feel about everything in Gebeya Inc. Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.ic_undraw_winners_ao2o));
        screens.add(new IntroScreenItem("Hi! Nice to meet you.", "We will check on you to see how you are feeling. Here We will record you emotions so that you can remember your moods a while ago.", R.drawable.ic_undraw_smiley_face_lmgm));
        screens.add(new IntroScreenItem("Team mood.", "In the common screen you can see your colleagues teams mood. Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.ic_undraw_celebration_0jvk));
        screens.add(new IntroScreenItem("Team mood.", "In the common screen you can see your colleagues teams mood.Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.ic_undraw_welcoming_xvuq));
        screens.add(new IntroScreenItem("Team mood.", "In the common screen you can see your colleagues teams mood.Feel free to share your moods. At Gebeya we are in the same team. ", R.drawable.gebeya_logo_light_trasparent));

        viewPager = findViewById(R.id.screen_Pager);

        introPageAdapter = new IntroViewPageAdapter(this, screens);
        viewPager.setAdapter(introPageAdapter);
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
   protected void openAuth(View view){
       Intent intent = new Intent(GebeyaIntro.this, OAuthActivity.class);
       startActivity(intent);
       finish();
    }

}
