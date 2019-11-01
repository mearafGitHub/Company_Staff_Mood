package com.example.gebeya_mood.views;

import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.repo.users.UserDto;
import com.example.gebeya_mood.ui.login.LoginActivity;
import com.example.gebeya_mood.viewmodels.UserViewModel;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends BaseActivity {

    private TextView fp_password_lable;
    private TextView fp_hint_text;
    private Button signup;
    private ImageButton fp_image;
    private FingerprintManager fp_manager;
    private KeyguardManager keyguardManager;

    private EditText email, username, gender, team, password, confirmpassword;
    private  String responseObject , code, error;
    private  Response<UserDto> response;


   // @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        email = findViewById(R.id.email);
        username = findViewById(R.id.screenname);
        gender = findViewById(R.id.gender);
        team = findViewById(R.id.team);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);

        signup = findViewById(R.id.signUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp(){
        UserViewModel userViewModel = new UserViewModel();

        String emailVal = email.getText().toString().trim();
        String usernameVal = username.getText().toString().trim();
        String genderVal = gender.getText().toString().trim();
        String teamVal = team.getText().toString().trim();
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
        if(genderVal.isEmpty()){
            gender.setError("Select is gender *");
            gender.requestFocus();
            return;
        }
        if(teamVal.isEmpty()){
            team.setError("Team is required *");
            team.requestFocus();
            return;
        }
        if(passwordVal.isEmpty()){
            password.setError("Email required");
            password.requestFocus();
            return;
        }
        if(confirmPWVal.isEmpty()){
            confirmpassword.setError("Confirm required");
            confirmpassword.requestFocus();
            return;
        }

        if(!passwordVal.equals(confirmPWVal)){
            password.setError("passwords must match with confirmed password ");
            confirmpassword.requestFocus();
            confirmpassword.setError("Confirmed password must match with password!");
        }
        response = userViewModel.signUp(emailVal,usernameVal,genderVal,teamVal,passwordVal);

        try {
            if (response == null){
                Toast.makeText(SignUpActivity.this, "response: Null " + code, Toast.LENGTH_LONG).show();
            }

            else if(! (response == null)){

             if(response.code() == 201){
                    code = String.valueOf(response.code());
                    responseObject = String.valueOf(response.body());

                    Toast.makeText(SignUpActivity.this, "response: " + responseObject + " code:" + code, Toast.LENGTH_LONG).show();

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

                // JSON Parsing here
                try {
                    JSONObject jsonObject = new JSONObject(responseObject);
                } catch (JSONException e){
                    e.printStackTrace();
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //Toast.makeText(SignUpActivity.this,  " Sign up to Gebeya Mood", Toast.LENGTH_LONG).show();
        }
    }

    }


