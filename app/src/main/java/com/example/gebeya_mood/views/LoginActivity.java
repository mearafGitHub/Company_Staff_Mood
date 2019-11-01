package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.viewmodels.UserViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Response response;
    private String responseObject, code, error;
    private Button login;
    private EditText email;
    private EditText password;
    private ProgressBar loadingLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        loadingLogin = findViewById(R.id.loadingLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                Intent intent = new Intent(LoginActivity.this, MoodPromptActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void  login(){
        UserViewModel userViewModel = new UserViewModel();

        String emailVal = email.getText().toString().trim();
        String passwordVal = password.getText().toString();

        if(emailVal.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        if(passwordVal.isEmpty()){
            password.setError("Email required");
            password.requestFocus();
            return;
        }

        loadingLogin.setVisibility(View.VISIBLE);
        response = userViewModel.logIn(emailVal, passwordVal);
        checkResponse();
    }

    protected  void checkResponse(){

        try {
            if (response == null){
                Toast.makeText(LoginActivity.this, "response: Null " + code, Toast.LENGTH_LONG).show();
            }
            else if(! (response == null)){

                if(response.code() == 201){
                    code = String.valueOf(response.code());
                    responseObject = String.valueOf(response.body());
                    Toast.makeText(LoginActivity.this, "Signed up succussfully " + " code:" + code, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, com.example.gebeya_mood.ui.login.LoginActivity.class);
                    startActivity(intent);
                }
                else if(response.code() == 400){
                    responseObject = String.valueOf(response.body());
                    Toast.makeText(LoginActivity.this, "  NULL Response: "  + responseObject, Toast.LENGTH_LONG).show();
                }
                else{
                    code = String.valueOf(response.code());
                    error = String.valueOf(response.errorBody());
                    Toast.makeText(LoginActivity.this, "Code: " + code + "  error: " + error, Toast.LENGTH_LONG).show();

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
        finally {loadingLogin.setVisibility(View.GONE);
            //Toast.makeText(SignUpActivity.this,  " Sign up to Gebeya Mood", Toast.LENGTH_LONG).show();
        }
    }

}
