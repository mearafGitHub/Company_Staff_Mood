package com.example.gebeya_mood.AppIntroduction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gebeya_mood.Auths.register.SignUpActivity;
import com.example.gebeya_mood.GebeyaMoodGeneral.GebeyaGeneralMoodActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.framework.util.Temporary;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(Const.ROLE.equals("admin")){
                    openForAdmin();
                }
                else{
                    openForBasicUser();
                }
                finish();
            }
        },3000);
    }

    void openForAdmin(){
        Intent intent = new Intent(MainActivity.this, GebeyaGeneralMoodActivity.class);
        startActivity(intent);
    }
    void openForBasicUser(){
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}