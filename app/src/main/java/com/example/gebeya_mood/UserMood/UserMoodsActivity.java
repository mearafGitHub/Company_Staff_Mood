package com.example.gebeya_mood.UserMood;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gebeya_mood.Admin.AdminViewAdapter;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.UserMood.UserMoodsAdapter;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.UserMood.UserMood;
import com.example.gebeya_mood.UserMood.UserMoodGETPojo;
import com.example.gebeya_mood.UserMood.UserMoodDao;
import com.example.gebeya_mood.UserMood.UserMoodTransformer;
import com.example.gebeya_mood.UserMood.UserMoodViewModel;
import com.example.gebeya_mood.framework.util.Const;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserMoodsActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {
    public RecyclerView userMoodRecycler;
    public UserMoodsAdapter userMoodAdapter;
    public List<UserMood> userMoodItems;
    private Context context;
    private UserMoodDao userMoodDao;
    private UserMoodViewModel userMoodViewModel;
    private String filterByDate;

    @SerializedName("name")
    private TextView userName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_moods);
        userMoodRecycler = findViewById(R.id.userMoodRecycler);
        userMoodItems = new ArrayList<>();
        Spinner filterMood = findViewById(R.id.mood_filter);
        userName = findViewById(R.id.my_user_name);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.date_filter,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterMood.setAdapter(arrayAdapter);
        filterMood.setOnItemSelectedListener(this);

        userMoodAdapter = new UserMoodsAdapter(this, userMoodItems);
        userMoodRecycler.setAdapter(userMoodAdapter);
        userMoodRecycler.setLayoutManager(new LinearLayoutManager(this));

        try{
            userMoodViewModel.getInstance().getAllUsersMoodsRemote();
            userMoodViewModel.getThisUserMoodResponse().observe(this, new Observer<List<UserMoodGETPojo>>() {
                @Override
                public void onChanged(List<UserMoodGETPojo> userMoodPojos) {
                    userMoodItems = UserMoodTransformer.ListDtoToMood(userMoodPojos);
                    userMoodDao.addMoods(userMoodItems);
                }
            });
        }catch(Exception e){ e.printStackTrace();}
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
        switch (choice){
            case "Day":
                filterByDate = choice;
                try{
                    userMoodViewModel.getOneUserMooRemote(filterByDate);
                }catch (Exception e){e.printStackTrace();}

            case "Month":
                filterByDate = choice;
                try{
                    userMoodViewModel.getOneUserMooRemote(filterByDate);
                }catch (Exception e){e.printStackTrace();}

            case "Week" :
                filterByDate = choice;
                try{
                    userMoodViewModel.getOneUserMooRemote(filterByDate);
                }catch (Exception e){e.printStackTrace();}

            case "Year" :
                filterByDate = choice;
                try{
                    userMoodViewModel.getOneUserMooRemote(filterByDate);
                }catch (Exception e){e.printStackTrace();}

            default:
                try{
                    userMoodViewModel.getOneUserMooRemote(filterByDate);
                }catch (Exception e){e.printStackTrace();}
        }
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_LONG).show();
        try{
            userMoodViewModel.getAllUsersMoodsRemote();
            userMoodViewModel.getThisUserMoodResponse().observe(this, new Observer<List<UserMoodGETPojo>>() {
                @Override
                public void onChanged(List<UserMoodGETPojo> userMoodPojos) {
                    userMoodItems = UserMoodTransformer.ListDtoToMood(userMoodPojos);
                    userMoodDao.addMoods(userMoodItems);
                }
            });
        }catch(Exception e){ e.printStackTrace();}
        initRecycler();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initRecycler (){
        userMoodRecycler.setLayoutManager(new LinearLayoutManager(this));
        userMoodAdapter = new UserMoodsAdapter(this, userMoodItems);
        userMoodRecycler.setAdapter(userMoodAdapter);
    }
}
