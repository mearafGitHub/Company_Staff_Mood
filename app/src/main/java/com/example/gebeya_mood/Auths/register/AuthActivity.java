package com.example.gebeya_mood.Auths.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gebeya_mood.Auths.login.LoginActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthActivity extends BaseActivity {
    private Button gebeyaSignUp;
    private Button googleSignUp;
    private SharedPreferences prefs;

    @BindView(R.id.linkToLogin)
    public TextView linkToLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oauth);

        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.TOKEN, false);
        if (seen) {
            openSignUp(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.TOKEN, false);
            editor.apply();
            showViews(null);
        }
    }

    protected void showViews(View view){
        ButterKnife.bind(this);
        gebeyaSignUp = findViewById(R.id.gebeyaSignUp);
        googleSignUp = findViewById(R.id.googleSignUp);
        linkToLogin = findViewById(R.id.linkToLogin);
        gebeyaSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        googleSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthActivity.this, GoogleAuth.class);
                startActivity(intent);
            }
        });

        linkToLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(AuthActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void openSignUp(View view){
        Intent intent = new Intent(AuthActivity.this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }
}
