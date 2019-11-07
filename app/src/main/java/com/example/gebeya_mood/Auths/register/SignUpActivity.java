package com.example.gebeya_mood.Auths.register;

//import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gebeya_mood.Auths.login.LoginActivity;
import com.example.gebeya_mood.Auths.UserResponse;
import com.example.gebeya_mood.Auths.UserViewModel;
import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

import com.example.gebeya_mood.framework.util.Const;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import retrofit2.Response;

public class SignUpActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private TextView fp_password_lable;
    private TextView fp_hint_text;
    private Button signup;
    private ImageButton fp_image;

    private Timer timer;
    private ProgressBar signUpProgressBar;
    private EditText email, username, password, confirmpassword;
    private String responseObject , code, error;
    private Response<SingUpPojo> response;
    private String team, gender;
    private UserViewModel userViewModel;
    private String checker;
    private SharedPreferences prefs;

    @BindView(R.id.linkToLogin)
    public TextView linkToLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.TOKEN, false);
        if (seen) {
            openLogin(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.TOKEN, false);
            editor.apply();
            showViews(null);
        }
    }

    protected void openLogin(View view){
        Intent intentOne = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intentOne);
    }

    protected void showViews(View view) {
        signUpProgressBar = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        username = findViewById(R.id.screenname);
        linkToLogin = findViewById(R.id.linkToLogin);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signUp);

        Spinner teamChoice = findViewById(R.id.Team_Select);
        userViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserViewModel.class);

        teamChoice.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Const.TeamName());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamChoice.setAdapter(dataAdapter);

        Spinner genderChoice = findViewById(R.id.Gender_Select);
        genderChoice.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapterGender = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Const.Gender());
        dataAdapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderChoice.setAdapter(dataAdapterGender);

        linkToLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp(){

        String emailVal = email.getText().toString();
        String usernameVal = username.getText().toString();
        String passwordVal = password.getText().toString();
        String confirmPWVal = confirmpassword.getText().toString();

        if(emailVal.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }
        if(usernameVal.isEmpty()){
            username.setError("Username is required *");
            username.requestFocus();
            return;
        }
        if(passwordVal.isEmpty()){
            password.setError("Password required *");
            password.requestFocus();
            return;
        }
        if(confirmPWVal.isEmpty()){
            confirmpassword.setError("Confirm password required *");
            confirmpassword.requestFocus();
            return;
        }
        if(!passwordVal.equals(confirmPWVal)){
            password.setError("passwords must match with confirmed password ");
            confirmpassword.requestFocus();
            confirmpassword.setError("Confirmed password must match with password!");
        }
        signUpProgressBar.setVisibility(View.VISIBLE);

        JsonObject userJson = new JsonObject();
        userJson.addProperty("name",usernameVal);
        userJson.addProperty("email",emailVal);
        userJson.addProperty("password",passwordVal);
        userJson.addProperty("team",team);
        userJson.addProperty("sex",gender);

        userViewModel.createUser(userJson);
        userViewModel.getSignUpRespones().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse createUserResponse) {
                try {
                    checker = String.valueOf(createUserResponse);
                    if (checker != null) {
                        String role = createUserResponse.getRole();
                        Const.ROLE = role;
                        Const.USERNAME = createUserResponse.getName();
                        Const.TEAM = createUserResponse.getType();
                        Toast.makeText(SignUpActivity.this, "Sign up successful! Welcome" + createUserResponse.getName(), Toast.LENGTH_LONG).show();
                        Intent intentOne = new Intent(SignUpActivity.this, MainActivity.class);
                        startActivity(intentOne);
                    } else {
                        Toast.makeText(SignUpActivity.this, "Sorry, something went wrong.", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){e.printStackTrace();}
            }
            });

        signUpProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        if (choice.equals("Female") || choice.equals("Male")){
            gender = choice;
        }
        else{
            team = choice;
        }
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}