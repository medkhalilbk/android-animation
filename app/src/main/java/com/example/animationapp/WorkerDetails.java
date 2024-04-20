package com.example.animationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class WorkerDetails extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worker_details);

        PieChart pieChart = findViewById(R.id.chart) ;
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(30f, "Work")) ;
        entries.add(new PieEntry(90f, "Sales")) ;
        entries.add(new PieEntry(75f, "Delivery")) ;

        PieDataSet pieDataSet = new PieDataSet(entries,"Subjects") ;
        PieData pieData = new PieData(pieDataSet) ;
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS) ;
        pieChart.setData(pieData) ;
        pieChart.getDescription().setEnabled(false);
        pieChart.animateY(300);
        pieChart.invalidate();






    }
}
