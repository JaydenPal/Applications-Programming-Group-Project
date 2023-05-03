package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;

import edu.utsa.cs3443.application_programming_group_project.controller.DifficultyController;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer music;
    enum Difficulty {
        EASY,
        MEDIUM,
        HARD
    }
    private Difficulty difficulty = Difficulty.MEDIUM;
    public void setDifficulty(String difficulty){
        switch(difficulty){
            case "EASY":
                this.difficulty = Difficulty.EASY;
                break;
            case "MEDIUM":
                this.difficulty = Difficulty.MEDIUM;
                break;
            case "HARD":
            default:
                this.difficulty = Difficulty.HARD;
                break;
        }
    }
    public Difficulty getDifficulty(){
        return difficulty;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Start music playback
        if(!MediaPlayerManager.getInstance().isCreated() && MediaPlayerManager.getInstance().isMusicOn()) {
            MediaPlayerManager.getInstance().startMusic(this);
        }
        //get buttons
        Button play = findViewById(R.id.playButton);
        Button settings = findViewById(R.id.settingButton);
        Button easyButton = findViewById(R.id.easyButton);
        Button mediumButton = findViewById(R.id.mediumButton);
        Button hardButton = findViewById(R.id.hardButton);
        //connect controller
        DifficultyController difficultyController = new DifficultyController(this);
        easyButton.setOnClickListener(difficultyController);
        mediumButton.setOnClickListener(difficultyController);
        hardButton.setOnClickListener(difficultyController);

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
    }
}

