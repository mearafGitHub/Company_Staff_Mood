package com.example.gebeya_mood.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.viewmodels.UserViewModel;

import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    private Response<LoginPojo> response;
    private String responseObject, code, error;
    private Button login;
    private EditText email;
    private EditText password;
    private ProgressBar loadingLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        loadingLogin = findViewById(R.id.loadingLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  login();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
        checkLoginResponse();
    }

    protected  void checkLoginResponse(){

        try {
            if (!(response.isSuccessful())){
                Toast.makeText(LoginActivity.this, " Not Successful." + code, Toast.LENGTH_LONG).show();
            }
            else if(response.isSuccessful()){
                Toast.makeText(LoginActivity.this, " Successful !!! " + code, Toast.LENGTH_LONG).show();


                if(response.errorBody() != null){
                    error = String.valueOf(response.errorBody());
                    Toast.makeText(LoginActivity.this, "Error: Null " + error + "Code:" + code, Toast.LENGTH_LONG).show();
                    d(error);
                }

                else if(! (response.body() == null)){
                    responseObject = String.valueOf(response.body());
                    d(responseObject);
                    code = String.valueOf(response.code());
                    Toast.makeText(LoginActivity.this, "Response:  "  + responseObject, Toast.LENGTH_LONG).show();

                    if(response.code() == 201){
                        Toast.makeText(LoginActivity.this, "Logged in successfully " + " code:" + code, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        code = String.valueOf(response.code());
                        error = String.valueOf(response.errorBody());
                        Toast.makeText(LoginActivity.this, "Code: " + code + "  error: " + error, Toast.LENGTH_LONG).show();
                    }
            }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {loadingLogin.setVisibility(View.GONE);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
