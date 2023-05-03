package edu.utsa.cs3443.application_programming_group_project.controller;

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
        System.out.println(difficulty);
        switch (difficulty){
            case "easy":
                mainActivity.setDifficulty("EASY");
                break;
            case "medium":
                mainActivity.setDifficulty("MEDIUM");
                break;
            case "hard":
            default:
                mainActivity.setDifficulty("HARD");
                break;
        }

    }
}
