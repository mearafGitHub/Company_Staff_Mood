package com.example.gebeya_mood.helper;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.TeamMood.GebeyaAllTeamMoodsActivity;
import com.example.gebeya_mood.UserMood.UserMoodsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavHelper {

public static void enableNav(final Context context, BottomNavigationView view){

        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_nav:
                        Intent intent = new Intent(context, GebeyaAllTeamMoodsActivity.class);
                        context.startActivity(intent);
                        return true;
                    case R.id.info_nav:
                        Intent intentI = new Intent(context, AdminActivity.class);
                        context.startActivity(intentI);
                        return true;
                    case R.id.my_moods_nav:
                        Intent intentM = new Intent(context, UserMoodsActivity.class);
                        context.startActivity(intentM);
                        return true;
                }
                return false;
            }
        });
    }
}
