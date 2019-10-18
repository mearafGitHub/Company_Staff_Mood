package com.example.gebeya_mood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyMoodsActivity extends AppCompatActivity {

    @SerializedName("name")
    TextView userInfo;
    ConnectApi connectApi;
    TextView emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moods);

        userInfo = findViewById(R.id.username);
        emotion = findViewById(R.id.emotion);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        connectApi = retrofit.create(ConnectApi.class);


        // Get Users from API
        getUsersCall();

        // Moods Here
        getMoodsCall();
    }

    private void getUsersCall() {

        Call<List<User>> call = connectApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    userInfo.setText("result: " + response.code());
                    return;
                }

                /*============= users fetched here ===============*/
                List<User> users = response.body();
                for(User user : users){
                    String content = "";
                    content += "ID: " + user.getId() + "\n";
                    content += "Name: " + user.getUsername() + "\n";
                    content += "Email: " + user.getEmail() + "\n";
                    content += "Team: " + user.getTeam() + "\n\n";

                    userInfo.setText(content);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });

    }

    private void getMoodsCall() {

        Call<List<Mood>> call = connectApi.getMoods();
        call.enqueue(new Callback<List<Mood>>() {
            @Override
            public void onResponse(Call<List<Mood>> call, Response<List<Mood>> response) {
                if(!response.isSuccessful()){
                    emotion.setText("result: " + response.code());
                    return;
                }

                /*============= users fetched here ===============*/
                List<Mood> moods = response.body();
                for(Mood mood : moods){
                    String content = "";
                    content += "ID: " + mood.getUserId() + "\n";
                    content += "Name: " + mood.getEmotion() + "\n";
                    content += "Email: " + mood.getDate() + "\n\n";

                    emotion.setText(content);
                }

            }

            @Override
            public void onFailure(Call<List<Mood>> call, Throwable t) {

            }
        });

    }


}
