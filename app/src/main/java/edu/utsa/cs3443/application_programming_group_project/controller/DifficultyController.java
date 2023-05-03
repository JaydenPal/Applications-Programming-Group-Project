package edu.utsa.cs3443.application_programming_group_project.controller;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import edu.utsa.cs3443.application_programming_group_project.MainActivity;
import edu.utsa.cs3443.application_programming_group_project.R;

public class DifficultyController implements View.OnClickListener{
    private MainActivity mainActivity;
    public DifficultyController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String difficulty = b.getText().toString();
        switch (difficulty){
            case "easy":
                mainActivity.setDifficulty("EASY");
                mainActivity.findViewById(R.id.easyButton).setBackgroundColor(Color.rgb(91,57,198));
                mainActivity.findViewById(R.id.hardButton).setBackgroundColor(Color.LTGRAY);
                mainActivity.findViewById(R.id.mediumButton).setBackgroundColor(Color.LTGRAY);
                break;
            case "medium":
                mainActivity.setDifficulty("MEDIUM");
                mainActivity.findViewById(R.id.mediumButton).setBackgroundColor(Color.rgb(91,57,198));
                mainActivity.findViewById(R.id.easyButton).setBackgroundColor(Color.LTGRAY);
                mainActivity.findViewById(R.id.hardButton).setBackgroundColor(Color.LTGRAY);
                break;
            case "hard":
            default:
                mainActivity.setDifficulty("HARD");
                mainActivity.findViewById(R.id.hardButton).setBackgroundColor(Color.rgb(91,57,198));
                mainActivity.findViewById(R.id.easyButton).setBackgroundColor(Color.LTGRAY);
                mainActivity.findViewById(R.id.mediumButton).setBackgroundColor(Color.LTGRAY);
                break;
        }

    }
}
