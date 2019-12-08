package com.example.gebeya_mood.GebeyaMoodGeneral;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.gebeya_mood.Admin.AdminActivity;
import com.example.gebeya_mood.Mood.Mood;
import com.example.gebeya_mood.Mood.MoodTranfromer;
import com.example.gebeya_mood.Mood.MoodsCountPojo;
import com.example.gebeya_mood.R;
import com.example.gebeya_mood.TeamMood.TeamMood;
import com.example.gebeya_mood.TeamMood.TeamMoodAdapter;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;
import com.example.gebeya_mood.UserMood.UserMoodsActivity;
import com.example.gebeya_mood.framework.base.BaseActivity;
import com.example.gebeya_mood.framework.util.Const;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GebeyaGeneralMoodActivity extends BaseActivity {
    public GebeyaGeneralViewModel gebeyaGeneralViewModel;
    private Context context;
    public Mood generalMoods;
    private int happy, content, neutral, angry, sad;

    @BindView(R.id.mood_filter_byDate)
    public Spinner filterByDate;

    @BindView(R.id.general_mood_graph)
    public LineChart lineChart;

    final ArrayList<String> xAxisLabel = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebeya_all_team_mood);
        ButterKnife.bind(this);
        lineChart =findViewById(R.id.general_mood_graph);
        lineChart.setBackgroundColor(Color.WHITE);
        lineChart.setGridBackgroundColor(Color.WHITE);
        lineChart.setDrawGridBackground(false);
        lineChart.setDrawBorders(false );
        lineChart.getDescription().setEnabled(false);
        lineChart.setPinchZoom(false);
        Legend legend = lineChart.getLegend();
        legend.setEnabled(true);
        lineChart.scheduleLayoutAnimation();
        lineChart.animate();
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawGridLines(false);

        xAxisLabel.add("Happy");
        xAxisLabel.add("Content");
        xAxisLabel.add("Neutral");
        xAxisLabel.add("Angry");
        xAxisLabel.add("Sad");

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter(){
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return xAxisLabel.get((int) value);
        }
    });

        setChartData(70, 5);

        gebeyaGeneralViewModel = new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(GebeyaGeneralViewModel.class);
        filterByDate = findViewById(R.id.mood_filter_byDate);

        ArrayAdapter<CharSequence> byDateAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.general_date_filter,
                android.R.layout.simple_spinner_item);
        byDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterByDate.setAdapter(byDateAdapter);

        try{
            gebeyaGeneralViewModel.getGeneralMoods().observe(this, new Observer<MoodsCountPojo>() {
                @Override
                public void onChanged(MoodsCountPojo moodsCount) {
                    generalMoods = MoodTranfromer.toMood(moodsCount);
                    happy = generalMoods.getHappy();
                    content = generalMoods.getContent();
                    neutral = generalMoods.getNeutral();
                    angry = generalMoods.getAngry();
                    sad = generalMoods.getSad();
                }
            });

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void setChartData(int members, float moods){
    // create random data
        ArrayList<Entry> yAxis= new ArrayList<>();
        yAxis.add(new Entry(1, 39));
        yAxis.add(new Entry(2, 30));
        yAxis.add(new Entry(3, 12));
        yAxis.add(new Entry(4, 4));
        yAxis.add(new Entry(5, 1));

        LineDataSet set2;
        set2 = new LineDataSet(yAxis,"Gebeya Mood Today");
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
        set2.setColor(Color.GREEN);
        set2.setDrawCircleHole(false);
        set2.setDrawCircles(false);
        set2.setDrawFilled(false);

        LineData lineData = new LineData(set2);
        lineData.setDrawValues(false);
        lineData.setValueTextColor(Color.LTGRAY);
        lineData.notifyDataChanged();
        lineChart.setData(lineData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Const.ROLE.equals("admin")){
            getMenuInflater().inflate(R.menu.admin_data_set, menu);
        }
        else{
            getMenuInflater().inflate(R.menu.mood_promt_menu, menu);
            getMenuInflater().inflate(R.menu.my_moods_menu, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.moodsPromptIcon:
                Intent intentPrompt = new Intent(GebeyaGeneralMoodActivity.this, MoodPromptActivity.class);
                startActivity(intentPrompt);
                return true;
            case R.id.my_mood_history:
                Intent intentMoods = new Intent(GebeyaGeneralMoodActivity.this, UserMoodsActivity.class);
                startActivity(intentMoods);
                return true;
            case R.id.adminDataSetIcon:
                Intent intentAdminView = new Intent(GebeyaGeneralMoodActivity.this, AdminActivity.class);
                startActivity(intentAdminView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
