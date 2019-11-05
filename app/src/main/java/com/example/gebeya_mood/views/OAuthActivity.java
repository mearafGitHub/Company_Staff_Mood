package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;

import java.util.ArrayList;
import java.util.List;

public class OAuthActivity extends BaseActivity {

    private Button gebeyaSignUp;
    private Button googleSignUp;

    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oauth);

        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.SEEN_INTRO, false);
        if (seen) {
            openSignUp(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.SEEN_INTRO, true);
            editor.apply();
            showViews();
        }


    }

    protected void showViews(){

        gebeyaSignUp = findViewById(R.id.gebeyaSignUp);
        googleSignUp = findViewById(R.id.googleSignUp);

        gebeyaSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OAuthActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void openSignUp(View view){

        Intent intent = new Intent(OAuthActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();



    }
}
