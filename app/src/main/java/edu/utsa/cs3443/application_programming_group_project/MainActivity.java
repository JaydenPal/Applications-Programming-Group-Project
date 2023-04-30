package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer music;
    enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize difficulty
        Difficulty difficulty = Difficulty.MEDIUM;
        // Start music playback
        if(!MediaPlayerManager.getInstance().isCreated() && MediaPlayerManager.getInstance().isMusicOn()) {
            MediaPlayerManager.getInstance().startMusic(this);
        }
        //get buttons
        Button play = findViewById(R.id.playButton);
        Button settings = findViewById(R.id.settingButton);
        Button stats = findViewById(R.id.statButton2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("DIFFICULTY", difficulty.ordinal());
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatsActivity.class);
                startActivity(intent);
            }
        });

    }
}

