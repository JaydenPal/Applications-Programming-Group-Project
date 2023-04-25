package edu.utsa.cs3443.application_programming_group_project;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

public class GameController implements View.OnClickListener {
    MainActivity mainActivity;
    private AssetManager am;
    private Context c;

    private int diff;

    public GameController(Context context, MainActivity mainActivity, int difficulty){
        c = context;
        this.mainActivity = mainActivity;
        //diff = difficulty;

        //Game game = new Game(difficulty, am);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, GameActivity.class);

        mainActivity.startActivity(intent);
    }
}