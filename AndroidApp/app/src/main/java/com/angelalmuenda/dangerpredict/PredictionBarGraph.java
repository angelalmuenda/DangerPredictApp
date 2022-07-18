package com.angelalmuenda.dangerpredict;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class PredictionBarGraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_bar_graph);

        TextView title = (TextView) findViewById(R.id.textTitle);
        String titleText= getIntent().getStringExtra("TITLE_STR");
        title.setText(titleText);

        TextView assess = (TextView) findViewById(R.id.textAssess);
        String assessText= getIntent().getStringExtra("ASSESS_STR");
        assess.setText(assessText);

        ArrayList<BarEntry> values = new ArrayList<>();
        final String[] mLabels = {
                "Carnapping",
                "Drug Related Incident",
                "Murder/Homicide",
                "Physical Injuries",
                "Rape",
                "Robbery",
                "Theft"
        };

        for (int i = 0; i < 7; i++) {
            String name2 = new String();
            name2 = String.format("%s_%s","CRIME_VALUE",String.valueOf(i));
            Float temp1 = new Float(getIntent().getStringExtra(name2));
            values.add(new BarEntry(i, temp1));
        }

        BarChart chart = findViewById(R.id.crime_chart);

        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        chart.getAxisRight().setEnabled(false);
        chart.setFitBars(true);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(8);
        xAxis.setLabelRotationAngle(270.0f);
        xAxis.setValueFormatter(new IAxisValueFormatter(){
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mLabels[(int) value];
            }
        });

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        BarDataSet set = new BarDataSet(values,"");

        set.setDrawIcons(false);

        set.setColors(new int[]{
                ContextCompat.getColor(this, android.R.color.holo_orange_light),
                ContextCompat.getColor(this, android.R.color.holo_blue_bright),
                ContextCompat.getColor(this, android.R.color.holo_green_light),
                ContextCompat.getColor(this, android.R.color.holo_purple),
                ContextCompat.getColor(this, android.R.color.holo_red_light),
                ContextCompat.getColor(this, android.R.color.holo_blue_dark),
                ContextCompat.getColor(this, android.R.color.holo_red_dark),
        });

        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set);

        BarData data = new BarData(dataSets);
        data.setValueTextSize(10f);
        data.setBarWidth(0.9f);

        chart.setData(data);

    }
}
