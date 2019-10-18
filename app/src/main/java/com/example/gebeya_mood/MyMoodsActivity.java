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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moods);

        userInfo = findViewById(R.id.username);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UsersConnectApi usersFromApi = retrofit.create(UsersConnectApi.class);

        Call<List<User>> call = usersFromApi.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    userInfo.setText("result: " + response.code());
                    return;
                }

    /*================== users fetched here ===========================*/
                List<User> users = response.body();
                for(User user : users){
                    String content = "";
                    content += "ID: " + user.getId() + "\n";
                    content += "Name: " + user.getUsername() + "\n";
                    content += "Email: " + user.getEmail() + "\n";
                    content += "Team: " + user.getTeam() + "\n\n";

                    userInfo.append(content);
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }


}
