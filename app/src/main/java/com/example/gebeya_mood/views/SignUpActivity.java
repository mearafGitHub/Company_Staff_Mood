package com.example.gebeya_mood.views;

//import android.app.KeyguardManager;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

import com.example.gebeya_mood.framework.util.Const;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.pojos.UserResponse;
import com.example.gebeya_mood.viewmodels.UserViewModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        prefs = getSharedPreferences(Const.PREFS_NAME, MODE_PRIVATE);
        boolean seen = prefs.getBoolean(Const.SEEN_INTRO, false);
        if (seen) {
            openLogin(null);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Const.SEEN_INTRO, true);
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

        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signUp);

        Spinner teamChoice = findViewById(R.id.Team_Select);

        userViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(UserViewModel.class);

        teamChoice.setOnItemSelectedListener(this);
        List<String> teamNames = new ArrayList<String>();
        teamNames.add("Staff");
        teamNames.add("Talent");
        teamNames.add("Contractor");
        teamNames.add("Student");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamChoice.setAdapter(dataAdapter);

        // gender spinner
        Spinner genderChoice = findViewById(R.id.Gender_Select);

        genderChoice.setOnItemSelectedListener(this);
        List<String> genderNames = new ArrayList<String>();
        genderNames.add("Female");
        genderNames.add("Male");

        ArrayAdapter<String> dataAdapterGender = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderNames);
        dataAdapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderChoice.setAdapter(dataAdapterGender);

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
                checker = String.valueOf(createUserResponse);
               // if(checker != null){
                    TextView result = findViewById(R.id.response);
                    result.append("ID\t:"+createUserResponse.getId());
                    result.append("\nname\t:"+createUserResponse.getName());
                    result.append("\nemail\t:"+createUserResponse.getEmail());
                    result.append("\nTeam\t:"+createUserResponse.getType());
                    result.append("\nGender\t:"+createUserResponse.getSex());
                    result.append("\nUser Role\t:"+createUserResponse.getRole());
                    Toast.makeText(SignUpActivity.this ,createUserResponse.getRole(), Toast.LENGTH_LONG).show();
                    // TODO: save this to local db

                    Intent intentOne = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intentOne);
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