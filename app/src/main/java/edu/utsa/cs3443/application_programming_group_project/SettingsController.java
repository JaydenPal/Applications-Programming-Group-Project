package edu.utsa.cs3443.application_programming_group_project;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

public class SettingsController implements View.OnClickListener {
    MainActivity mainActivity;
    private AssetManager am;
    private Context c;

    public SettingsController(Context context, MainActivity mainActivity){
        c = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, SettingsActivity.class);

        mainActivity.startActivity(intent);
    }
}

