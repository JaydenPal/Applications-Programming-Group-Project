package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int diff = 0;

        Button play = findViewById(R.id.playButton);
        Button settings = findViewById(R.id.settingButton);
        Button stats = findViewById(R.id.statButton2);
        /*Button easy = findViewById(R.id.easyMode);
        Button medium = findViewById(R.id.medMode);
        Button hard = findViewById(R.id.hardMode);*/

        play.setOnClickListener(new GameController(getApplicationContext(), this, diff)); /* pass in the difficulty of the game here
                                                                                               *  maybe use pre-proc definition */
        settings.setOnClickListener(new SettingsController(getApplicationContext(), this));
        stats.setOnClickListener(new StatsController(getApplicationContext(), this));

        /*  Note from Lauren:
        *       I think there'd be some weirdness having
        *       the buttons on the screen. I'll have to
        *       tinker with it some more, but for the time
        *       being, I've just commented it out.
        */

        /*easy.setOnClickListener(diff = 0);
        medium.setOnClickListener(diff = 1);
        hard.setOnClickListener(diff = 2);*/
    }
}