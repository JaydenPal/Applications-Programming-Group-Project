package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        Stats stats = Stats.getInstance();
        StatsController statsController = new StatsController();
    }
}