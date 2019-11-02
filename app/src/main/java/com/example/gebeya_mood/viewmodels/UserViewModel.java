package com.example.gebeya_mood.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gebeya_mood.models.User;
import com.example.gebeya_mood.pojos.LoginPojo;
import com.example.gebeya_mood.pojos.SingUpPojo;
import com.example.gebeya_mood.repo.users.UserApiService;
import com.example.gebeya_mood.repo.users.UserDao;
import com.example.gebeya_mood.repo.users.UserDto;
import com.example.gebeya_mood.repo.users.UserTransformer;

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
    public MutableLiveData<List<User>> users;
    public  Response<LoginPojo> loginRespones;
    public  Response<SingUpPojo> signUpRespones;


    public UserViewModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       users = new MutableLiveData<>(new ArrayList<>());
        //loadUserMoods();
    }

    private void loadUser(){
        List<User> usersDb = dao.getAll();
        if (usersDb.isEmpty()){
            userFromApi();
        }
        else{
            users.setValue(usersDb);
        }
    }

    private void userFromApi(){

        UserApiService userApiService = retrofit.create(UserApiService.class);
        userApiService.getMoods().enqueue(new Callback<List<UserDto>>() {
            @Override
            public void onResponse(Call<List<UserDto>> call, Response<List<UserDto>> response) {
                List<User> usersApi = UserTransformer.ListDtoToUserList(response.body());
                dao.addUsers(usersApi);
                users.setValue(usersApi);
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<User>> getUsers(){
        return users;
    }

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
                .signUp(user);

        callSignUp.enqueue(new Callback<SingUpPojo>() {
            @Override
            public void onResponse(Call<SingUpPojo> call, Response<SingUpPojo> response) {

                try {
                    signUpRespones = response;
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

    public Response<LoginPojo> logIn(String email, String password){

        Call<LoginPojo> callLogin = UserViewModel.getInstance()
                .getUserService()
                .logIn(email, password);

        callLogin.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                try {
                    loginRespones = response;
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

}
