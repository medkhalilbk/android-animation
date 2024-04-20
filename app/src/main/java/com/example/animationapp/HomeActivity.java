package com.example.animationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Items> itemsArrayList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_home);

        Objects.requireNonNull(getSupportActionBar()).hide();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemsArrayList = new ArrayList<>();

        addData();
    }

    private void addData() {

        for (int i = 0; i < 1000; i++) {
            itemsArrayList.add(new Items("" + i, "Worker " + i, "Email" + i + "@gmail.com"));
        }
        adapter = new Adapter(this, itemsArrayList);
        recyclerView.setAdapter(adapter) ;

    }
}