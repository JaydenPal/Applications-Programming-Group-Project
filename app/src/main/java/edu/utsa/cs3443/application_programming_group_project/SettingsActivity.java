package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import edu.utsa.cs3443.application_programming_group_project.controller.MusicSwitchController;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button mainMenu = findViewById(R.id.settingsMainMenu);
        Switch musicSwitch = findViewById(R.id.musicSwitch);
        musicSwitch.setChecked(MediaPlayerManager.getInstance().isMusicOn());

        SettingsController settingsController = new SettingsController(this);
        mainMenu.setOnClickListener(settingsController);
        MusicSwitchController musicSwitchController = new MusicSwitchController(this);
        musicSwitch.setOnClickListener(musicSwitchController);
    }
}