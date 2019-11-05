package com.example.gebeya_mood.views;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.UserResponse;
import com.example.gebeya_mood.viewmodels.UserViewModel;
import com.google.gson.JsonObject;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    protected Response<LoginPojo> response;
    private static Application application;
    private String responseObject, code, error;
    private Button login;
    private EditText email;
    private EditText password;
    private ProgressBar loadingLogin;
    private String checker;
    private UserViewModel userViewModel;
    private SharedPreferences prefs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.SEEN_INTRO, false);
        if (seen) {
            openPromt(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.SEEN_INTRO, true);
            editor.apply();
            showView(null);
        }


    }

    protected void  login(){

        String emailVal = email.getText().toString().trim();
        String passwordVal = password.getText().toString();

        if(emailVal.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(passwordVal.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        loadingLogin.setVisibility(View.VISIBLE);
        JsonObject jsonObject=new JsonObject();;
        jsonObject.addProperty("email",emailVal);
        jsonObject.addProperty("password",passwordVal);

        userViewModel.loginUser(jsonObject);

        userViewModel.getLoginRespones().observe(this, new Observer<LoginPojo>() {
            @Override
            public void onChanged(LoginPojo loginUserResponse) {

                    Toast.makeText(LoginActivity.this, "Logged is successfuly.",Toast.LENGTH_LONG  ).show();
                    TextView result=findViewById(R.id.responseLogin);
                    checker = String.valueOf(loginUserResponse);
                    result.append("Message\t:"+loginUserResponse.getMessage());
                    result.append("\nToken\t:"+loginUserResponse.getToken());
                    result.append("\nUser object\t:"+loginUserResponse.getUser());
                 //     Log.e("Result: ", loginUserResponse.getToken());
                     Toast.makeText(LoginActivity.this ,loginUserResponse.getMessage(), Toast.LENGTH_LONG).show();
                    // TODO: Save token to the local db

                    Intent intent = new Intent(LoginActivity.this, MoodPromptActivity.class);
                    startActivity(intent);


            }
        });

        loadingLogin.setVisibility(View.GONE);

    }

    protected void openPromt(View view){

        Intent intent = new Intent(LoginActivity.this, MoodPromptActivity.class);
        startActivity(intent);
    }

    protected void showView(View view){
        userViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserViewModel.class);

        login = findViewById(R.id.login);
        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        loadingLogin = findViewById(R.id.loadingLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


}
