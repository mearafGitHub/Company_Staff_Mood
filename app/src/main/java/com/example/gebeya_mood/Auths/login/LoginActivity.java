package com.example.gebeya_mood.Auths.login;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.Auths.UserResponse;
import com.example.gebeya_mood.Auths.UserViewModel;
import com.example.gebeya_mood.Auths.register.SignUpActivity;
import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.google.gson.JsonObject;

import butterknife.ButterKnife;
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
    public String userRole;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.TOKEN, false);
        if (seen) {
            openPrompt(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.TOKEN, false);
            editor.apply();
            showView(null);
        }
    }
    public void showView(View view){
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
        try{
            userViewModel.loginUser(jsonObject);
            userViewModel.getLoginRespones().observe(this, new Observer<UserResponse>() {
                @Override
                public void onChanged(UserResponse loginUserResponse) {
                    try {
                        checker = String.valueOf(loginUserResponse);
                        if (checker != null) {
                            String role = loginUserResponse.getRole();
                            Const.ROLE = role;
                            Const.TOKEN = "TOKEN";
                            Const.USERNAME = loginUserResponse.getName();
                            Const.TEAM = loginUserResponse.getType();
                            userRole = loginUserResponse.getRole();
                            Log.e("Result: ", loginUserResponse.getRole());
                            Toast.makeText(LoginActivity.this, "Logged in successfuly.",Toast.LENGTH_LONG  ).show();
                            Toast.makeText(LoginActivity.this, loginUserResponse.getName(), Toast.LENGTH_LONG).show();

                            if(role.equals("admin")){
                                openAdmin(null);
                            }else{openPrompt(null);}
                         }
                         else {
                            Toast.makeText(LoginActivity.this, "Sorry, something went wrong.", Toast.LENGTH_LONG).show();
                         }
                     }catch (Exception e){e.printStackTrace();}
                 }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
        loadingLogin.setVisibility(View.GONE);
    }

    protected void openPrompt(View view){
        Intent intent = new Intent(LoginActivity.this, MoodPromptActivity.class);
        startActivity(intent);
    }

    protected void openAdmin(View view){
        Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
        startActivity(intent);
    }

}
