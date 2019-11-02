package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

public class OAuthActivity extends BaseActivity {

    private Button gebeyaSignUp;
    private Button googleSignUp;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oauth);
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
}
