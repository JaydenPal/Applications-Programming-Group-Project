package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start music service
        Intent musicServiceIntent = new Intent(this, MusicService.class);
        startService(musicServiceIntent);

        // Start music playback
        music = MediaPlayer.create(this, R.raw.music);
        music.setLooping(true);
        music.start();

        int diff = 0;

        Button play = findViewById(R.id.playButton);
        Button settings = findViewById(R.id.settingButton);
        Button stats = findViewById(R.id.statButton2);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop music service
        Intent musicServiceIntent = new Intent(this, MusicService.class);
        stopService(musicServiceIntent);

        // Stop music playback
        music.stop();
        music.release();
    }
}

