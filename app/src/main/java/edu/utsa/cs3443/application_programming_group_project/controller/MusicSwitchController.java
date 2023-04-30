package edu.utsa.cs3443.application_programming_group_project.controller;

import android.view.View;
import android.widget.Switch;

import edu.utsa.cs3443.application_programming_group_project.MediaPlayerManager;
import edu.utsa.cs3443.application_programming_group_project.MusicService;
import edu.utsa.cs3443.application_programming_group_project.SettingsActivity;
import edu.utsa.cs3443.application_programming_group_project.SettingsController;

public class MusicSwitchController implements View.OnClickListener{
    SettingsActivity settingsActivity;
    public MusicSwitchController(SettingsActivity settingsActivity){
        this.settingsActivity = settingsActivity;
    }
    @Override
    public void onClick(View view) {
        Switch musicSwitch = (Switch) view;
        if(musicSwitch.isChecked()){
            MediaPlayerManager.getInstance().stopMusic();
        } else{
            MediaPlayerManager.getInstance().startMusic(settingsActivity);
        }
    }
}
