package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.R;

public class OAuthActivity extends AppCompatActivity {

    private Button gebeyaSignUp;
    private Button googleSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oauth);
    gebeyaSignUp = findViewById(R.id.gebeyaSignUp);


    gebeyaSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(OAuthActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    });

    gebeyaSignUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(OAuthActivity.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }
    });


    }
}
