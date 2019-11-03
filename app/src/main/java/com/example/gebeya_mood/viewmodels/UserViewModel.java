package com.example.gebeya_mood.viewmodels;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gebeya_mood.MainActivity;
import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.repo.users.UserApiService;
import com.example.gebeya_mood.repo.users.UserDao;
import com.example.gebeya_mood.repo.users.UserDto;
import com.example.gebeya_mood.repo.users.UserTransformer;
import com.example.gebeya_mood.views.LoginActivity;
import com.example.gebeya_mood.views.SignUpActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserViewModel extends ViewModel {
    private static final String BaseUrl = "https://stark-peak-15799.herokuapp.com/";
    private static UserViewModel userViewModel;
    public Retrofit retrofit;
    public UserDao dao;
    private Response<SingUpPojo> signupResponse;
    public MutableLiveData<List<User>> users;
    public  Response<LoginPojo> loginRespones;
    public  Response<SingUpPojo> signUpRespones;


    public UserViewModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       users = new MutableLiveData<>(new ArrayList<>());

    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }


    // this , i guess keeps the state of the app... make sure
    public static synchronized UserViewModel getInstance(){
        if(userViewModel == null){
            userViewModel = new UserViewModel();
        }
        return userViewModel;
    }

    public UserApiService getUserService(){
        return retrofit.create(UserApiService.class);
    }


    public Response<SingUpPojo> signUp(String email, String username, String gender, String team, String password){

        User user = new User(email, username, gender, team, password);

        Call<SingUpPojo> callSignUp = UserViewModel.getInstance()
                .getUserService()
                .signUp(email, username,team, gender, password);

        callSignUp.enqueue(new Callback<SingUpPojo>() {
            @Override
            public void onResponse(Call<SingUpPojo> call, Response<SingUpPojo> response) {

                try {
                    String log = String.valueOf(response.code());
                    String logBody = String.valueOf(response.body());
                    String logError = String.valueOf(response.errorBody());
                    Log.e("Signup response: ", log);
                    Log.e("Signup response body ", log);
                    Log.e("Signup response error ", log);


                    signUpRespones = response;
                    SignupResponse(response);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                }
            }

            @Override
            public void onFailure(Call<SingUpPojo> call, Throwable t) {
                return;
            }
        });

        return signUpRespones;
    }

    protected Response<SingUpPojo> SignupResponse(Response<SingUpPojo> response){

        try {
            if (response == null){

            }
            else if(! (response == null)){
               String responseObject = String.valueOf(response.body());
                Log.e("response is: ", responseObject);
                // d(responseObject);
               String error = String.valueOf(response.errorBody());
                Log.e("error is: ", error);
                if(response.code() == 201){
                   String code = String.valueOf(response.code());
                    Log.e("response is: ", responseObject);
                }
                else if(response.code() == 400){
                   String code = String.valueOf(response.code());
                    responseObject = String.valueOf(response.body());
                    Log.e("response is: ", responseObject);
                    error = String.valueOf(response.errorBody());
                    Log.e("error is: ", error);
                }
                else{
                    String code = String.valueOf(response.code());
                    error = String.valueOf(response.errorBody());
                    Log.e("error is: ", error);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
        }

        return response;
    }

    public Response<LoginPojo> logIn(String email, String password){

        Call<LoginPojo> callLogin = UserViewModel.getInstance()
                .getUserService()
                .logIn(email, password);

        callLogin.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                try {
                    String log = String.valueOf(response.code());
                    String logBody = String.valueOf(response.body());
                    String logError = String.valueOf(response.errorBody());
                    Log.e("Login response: ", log);
                    Log.e("Login response body ", log);
                    Log.e("Login response error ", log);
                    if(response.body() == null){
                        String loginRes = String.valueOf(response.code());
                        Log.e("response is: ", loginRes);
                    }
                    loginRespones = response;
                    checkLoginResponse(response);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                }
            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

                return;
            }
        });

        return loginRespones;
    }

    protected  Response<LoginPojo> checkLoginResponse(Response<LoginPojo> response){

        try {
            if(response.body() == null){

            }

            if (response.code() == 400){

            }

            if (!(response.isSuccessful())){


            }
            else if(response.isSuccessful()){
                String responseObject = String.valueOf(response.body());
                String code = String.valueOf(response.code());

                if(response.errorBody() != null){
                    String  error = String.valueOf(response.errorBody());

                }

                else if(! (response.body() == null)){
                    responseObject = String.valueOf(response.body());
                    code = String.valueOf(response.code());

                    if(response.code() == 201){

                    }
                    else{
                        code = String.valueOf(response.code());
                        String error = String.valueOf(response.errorBody());

                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }

        return response;
    }

}
