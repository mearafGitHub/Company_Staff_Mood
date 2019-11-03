package com.example.gebeya_mood.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.viewmodels.TeamMoodViewModel;

public class TeamDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_detail);

        Intent intent = getIntent();
        TeamMoodViewModel teamMoodViewModel = intent.getParcelableExtra("TeamMood UserMood Detais");

/*        int emoji = teamMoodViewModel.getEmoji();
        String teamName = teamMoodViewModel.getTeamName();
        String emotion = teamMoodViewModel.getEmotion();
        String teamTotal = teamMoodViewModel.getTeamTotal();
        String date = teamMoodViewModel.getDate();*/

        ImageView imageView = findViewById(R.id.team_emojiTD);
       /* imageView.setImageResource(emoji);*/

       /*
       // the following in the each user detail activity(when the admin wants to see more about each user in the team detail)
       TextView username = findViewById(R.id.admin_data_Username);
        username.setText(teamName);*/

      /*  TextView totalteam = findViewById(R.id.admin_data_totalMembers);
        totalteam.setText(teamTotal);

        TextView userdate = findViewById(R.id.admin_data_date);
        userdate.setText(date);
*/
    }
}
