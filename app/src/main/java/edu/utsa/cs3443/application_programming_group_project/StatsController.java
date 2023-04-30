package edu.utsa.cs3443.application_programming_group_project;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

public class StatsController implements View.OnClickListener {
    StatsActivity statsActivity;

    public StatsController(StatsActivity statsActivity){
        this.statsActivity = statsActivity;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(statsActivity, MainActivity.class);
        /*intent.putExtra("WINS", Stats.getInstance().getWins());
        intent.putExtra("LOSSES", Stats.getInstance().getLosses());
        intent.putExtra("T_TIME", "Total time: ");
        intent.putExtra("F_SOLVE", "Fastest");
        intent.putExtra("L_WORD", );*/
        statsActivity.startActivity(intent);
    }
}