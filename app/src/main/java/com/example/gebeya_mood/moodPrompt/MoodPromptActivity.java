package com.example.gebeya_mood.moods;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gebeya_mood.R;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.moodhome.MoodsHomeActivity;
import com.example.gebeya_mood.mymoods.MyMoodsActivity;


public class MoodPromptActivity extends BaseActivity {

    //@BindView(R.id.happyMood)
    private ImageButton happyMood;
   // @BindView(R.id.sadMood)
    private ImageButton sadMood;
   // @BindView(R.id.mehMood)
    private ImageButton mehMood;
   // @BindView(R.id.angryMood)
    private ImageButton angryMood;
  //  @BindView(R.id.whateverMood)
    private ImageButton neutralMood;

    private ImageButton coolMood;

    private ImageButton excitedMood;



    Button go, skip;
    ImageButton cancel;
    Dialog why;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prompt);

        happyMood = findViewById(R.id.happyMood);
        sadMood = findViewById(R.id.sadMood);
        mehMood = findViewById(R.id.mehMood);
        angryMood = findViewById(R.id.disappointedMood);
        neutralMood = findViewById(R.id.neutral);
        coolMood = findViewById(R.id.coolMood);
        excitedMood = findViewById(R.id.excitedMood);

        happyMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Glad you are Happy.", Toast.LENGTH_LONG).show();
                moodDialogAlert("happyMood");
            }
        });


        sadMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Sorry you are Sad.", Toast.LENGTH_LONG).show();
                moodDialogAlert("sadMood");
            }
        });

        mehMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Oh, you are bord?", Toast.LENGTH_LONG).show();
                moodDialogAlert("mehMood");
            }
        });

        angryMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Angry? What's it?", Toast.LENGTH_LONG).show();
                moodDialogAlert("angryMood");
            }
        });

        neutralMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Just normal", Toast.LENGTH_LONG).show();
                moodDialogAlert("neutral");
            }
        });

        excitedMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Glad you're excited.", Toast.LENGTH_LONG).show();
                moodDialogAlert("excitedMood");
            }
        });

        coolMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodPromptActivity.this, "Aha! Feeling cool.", Toast.LENGTH_LONG).show();
                moodDialogAlert("coolMood");
            }
        });
    }

    public void moodDialogAlert(String mood){
        why = new Dialog(MoodPromptActivity.this);
        why.setContentView(R.layout.activity_mood_submit);
        why.setTitle("What is it?");

        go = why.findViewById(R.id.goModalButton);
        skip = why.findViewById(R.id.skipModalButton);
        cancel = why.findViewById(R.id.cancelModalButton);

        go.setEnabled(true);
        skip.setEnabled(true);
        cancel.setEnabled(true);

        //LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(this.LAYOUT_INFLATER_SERVICE);
       //View view = inflater.inflate(R.layout.happy_anim, null);

        //LinearLayout container =  findViewById(R.id.modalLayout);
       // container.addView(view, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //send to api
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // make a toast & send the emoji to api
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                why.cancel();
            }
        });

        why.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mood_list, menu);
        getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.listIcon:
                Intent intent = new Intent(MoodPromptActivity.this, MoodsHomeActivity.class);
                startActivity(intent);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(MoodPromptActivity.this, MyMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
