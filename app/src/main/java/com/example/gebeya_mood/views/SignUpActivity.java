package com.example.gebeya_mood.views;

//import android.app.KeyguardManager;
import android.content.Intent;
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
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;

import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.viewmodels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class SignUpActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private TextView fp_password_lable;
    private TextView fp_hint_text;
    private Button signup;
    private ImageButton fp_image;

    private ProgressBar signUpProgressBar;
    private EditText email, username, password, confirmpassword;
    private String responseObject , code, error;
    private Response<SingUpPojo> response;
    private String team, gender;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpProgressBar = findViewById(R.id.loading);
        email = findViewById(R.id.email);
        username = findViewById(R.id.screenname);

        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signUp);


        Spinner teamChoice = findViewById(R.id.Team_Select);

        teamChoice.setOnItemSelectedListener(this);
        List<String> teamNames = new ArrayList<String>();
        teamNames.add("Manage");
        teamNames.add("Trainers");
        teamNames.add("Mobile");
        teamNames.add("UI/UX");
        teamNames.add("FrontEnd");
        teamNames.add("BackEnd");
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
        UserViewModel userViewModel = new UserViewModel();

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
        response = userViewModel.signUp(emailVal,usernameVal,gender,team,passwordVal);
        checkResponse();
    }

    protected  void checkResponse(){

        try {
            if (response == null){
                Toast.makeText(SignUpActivity.this, "response: Is Null " + code, Toast.LENGTH_LONG).show();

            }
            else if(! (response == null)){
                responseObject = String.valueOf(response.body());
                d(responseObject);
                if(response.code() == 201){
                    code = String.valueOf(response.code());
                    responseObject = String.valueOf(response.body());
                    Toast.makeText(SignUpActivity.this, "Signed up successfully " + " code:" + code, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                else if(response.code() == 400){
                    responseObject = String.valueOf(response.body());
                    Toast.makeText(SignUpActivity.this, "  NULL Response: "  + responseObject, Toast.LENGTH_LONG).show();
                }
                else{
                    code = String.valueOf(response.code());
                    error = String.valueOf(response.errorBody());
                    Toast.makeText(SignUpActivity.this, "Code: " + code + "  error: " + error, Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {signUpProgressBar.setVisibility(View.GONE);
            Toast.makeText(SignUpActivity.this,  " Sign up to Gebeya Mood", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        }
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