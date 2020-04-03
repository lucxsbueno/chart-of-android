package com.goldencode.piechart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PieChart mPieChart;
    HorizontalBarChart mBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPieChart = (PieChart) findViewById(R.id.pieChart);

        mPieChart.setUsePercentValues(true);
        mPieChart.getDescription().setEnabled(true);
        mPieChart.setExtraOffsets(5, 10, 5, 5);

        mPieChart.setDragDecelerationFrictionCoef(0.95f);

        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleColor(Color.WHITE);
        mPieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(34f, "Brasil"));
        yValues.add(new PieEntry(23f, "Inglaterra"));
        yValues.add(new PieEntry(14f, "Índia"));
        yValues.add(new PieEntry(35f, "Rússia"));
        yValues.add(new PieEntry(40f, "China"));
        yValues.add(new PieEntry(23f, "Japão"));

        PieDataSet mDataSet = new PieDataSet(yValues, "Countries");
        mDataSet.setSliceSpace(3f);
        mDataSet.setSelectionShift(5f);
        mDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData mData = new PieData((mDataSet));
        mData.setValueTextSize(10f);
        mData.setValueTextColor(Color.YELLOW);

        mPieChart.setData(mData);

        mBarChart = (HorizontalBarChart) findViewById(R.id.horizontalBarChart);

        setData(6, 20);

    }

    private void setData(int count, int range) {

        ArrayList<BarEntry> yValues = new ArrayList<>();
        float barWidth = 9f;
        float spaceForBar =10f;

        for (int i = 0; i < count; i++){
            float val = (float) (Math.random()*range);
            yValues.add(new BarEntry(i*spaceForBar, val));
        }

        BarDataSet set;

        set = new BarDataSet(yValues, "Data sets");

        BarData data = new BarData(set);
        data.setBarWidth(barWidth);

        mBarChart.setData(data);

    }
}
