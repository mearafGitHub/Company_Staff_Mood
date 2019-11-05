package com.example.gebeya_mood.views;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
            public void onChanged(LoginPojo createUserResponse) {
                if(checker != null){
                    Toast.makeText(LoginActivity.this, "Logged is successfuly.",Toast.LENGTH_LONG  ).show();
                    TextView result=findViewById(R.id.responseLogin);
                    checker = String.valueOf(createUserResponse);
                    result.append("ID\t:"+createUserResponse.getMessage());
                    result.append("\nname\t:"+createUserResponse.getToken());
                    result.append("\nemail\t:"+createUserResponse.getUser());

                     Toast.makeText(LoginActivity.this ,createUserResponse.getMessage(), Toast.LENGTH_LONG).show();
                    // TODO: Save token to the local db

                    Intent intent = new Intent(LoginActivity.this, MoodPromptActivity.class);
                    startActivity(intent);
                }
                else{
                   Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this ,"Oops! Something went wrong.", Toast.LENGTH_LONG).show();

                        }
                    },2500);
                }

            }
        });

        loadingLogin.setVisibility(View.GONE);

    }

}
