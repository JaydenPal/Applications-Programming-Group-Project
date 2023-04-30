package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        String s, time;
        long timeInSec, minute, second;
        Stats stats = Stats.getInstance();
        StatsController statsController = new StatsController(this);

        Button mainMenu = findViewById(R.id.settingsMainMenu);
        TextView wins = findViewById(R.id.wins);
        TextView losses = findViewById(R.id.losses);
        TextView totalTime = findViewById(R.id.total_time);
        TextView fastestSolve = findViewById(R.id.fastest_solve);
        TextView longestWord = findViewById(R.id.longest_word);


        mainMenu.setOnClickListener(statsController);
        s = "Wins: " + stats.getWins();
        wins.setText(s);

        s = "Losses: " + stats.getLosses();
        losses.setText(s);

        timeInSec = stats.getTotalTime() / 1000;
        minute =  timeInSec / 60;
        second = timeInSec % 60;
        if(minute < 10 && second < 10) {
            time = "0" + minute + ":" + "0" + second;
        } else if (minute < 10){
            time = "0" + minute + ":" + second;
        } else if(second < 10){
            time = minute + ":" + "0" + second;
        } else {
            time = minute + ":" + second;
        }
        s = "Total time: " + time;
        totalTime.setText(s);

        timeInSec = stats.getTotalTime() / 1000;
        minute =  timeInSec / 60;
        second = timeInSec % 60;
        if(minute < 10 && second < 10) {
            time = "0" + minute + ":" + "0" + second;
        } else if (minute < 10){
            time = "0" + minute + ":" + second;
        } else if(second < 10){
            time = minute + ":" + "0" + second;
        } else {
            time = minute + ":" + second;
        }
        s = "Fastest time: " + time;
        fastestSolve.setText(s);

        s = "Longest solved word: " + stats.getLongestSolve();
        longestWord.setText(s);
    }
}