package edu.utsa.cs3443.application_programming_group_project;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

public class SettingsController implements View.OnClickListener {
    SettingsActivity settingsActivity;
    public SettingsController(SettingsActivity settingsActivity){
        this.settingsActivity = settingsActivity;
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(settingsActivity, MainActivity.class);
        settingsActivity.startActivity(intent);
    }
}

