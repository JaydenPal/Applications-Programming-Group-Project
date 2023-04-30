package edu.utsa.cs3443.application_programming_group_project;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.View;

public class GameController implements View.OnClickListener {
    int LAUNCH_SECOND_ACTIVITY = 1;
    int RESULT_OK = 0;
    int RESULT_CANCELED = 1;
    MainActivity mainActivity;
    private AssetManager am;
    private Context c;

    private int diff, result;
    String word;


    public GameController(Context context, MainActivity mainActivity, int difficulty){
        c = context;
        this.mainActivity = mainActivity;
        am = c.getAssets();

        Game game = new Game(difficulty, am);
        word = game.getWord();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity,GameActivity.class);
        intent.putExtra("WORD", word);
        mainActivity.startActivity(intent);
    }
}