package edu.utsa.cs3443.application_programming_group_project.controller;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.application_programming_group_project.GameActivity;
import edu.utsa.cs3443.application_programming_group_project.R;

public class KeyBoardController implements View.OnClickListener {
    private int numOfIncorrect;
    private int lettersCorrect;
    private Boolean gameOver = false;
    GameActivity gameActivity;
    public KeyBoardController(GameActivity gameActivity){
        this.gameActivity = gameActivity;
        numOfIncorrect = 0;
    }
    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String letter = b.getText().toString();
        String word  = gameActivity.getWord();
        System.out.println(letter);
        System.out.println(word);
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(letter.toLowerCase().charAt(0) == word.toLowerCase().charAt(i)){
                gameActivity.getWordDisplay()[i] = word.toUpperCase().charAt(i);
                count++;
            }
        }
        lettersCorrect += count;
        System.out.println(count);
        if(count > 0) {
            TextView wordView = gameActivity.findViewById(R.id.wordView);
            wordView.setText(new String(gameActivity.getWordDisplay()));
            if (lettersCorrect == word.length()) gameOver = true;
        } else {
            /**
             * since no letters correct, guess is wrong, increment numOfIncorrect
             * and draw the respective image for numOfIncorrect
             */
            numOfIncorrect++;
            ImageView hangmanImg = null;
            switch(numOfIncorrect){
                case 1:
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g1);
                    break;
                case 2:
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g2);
                    break;
                case 3:
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g3);
                    break;
                case 4:
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g4);
                    break;
                case 5:
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g5);
                    break;
                default:
                    /* game is over all parts drawn so set gameOver to true*/
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g6);
                    gameOver = true;
                    break;
            }
            /* draw the respective image with error check to avoid working on null object*/
            if(hangmanImg != null) hangmanImg.setVisibility(View.VISIBLE);
        }
        /* remove letter from view */
        b.setVisibility(View.GONE);
        /*This handles the game ending i.e player won/lost*/
        if(gameOver){
            /*stop timer and prepare game over layout, win/lose message*/
            gameActivity.getTimer().cancel();
            LinearLayout gameOverLayout = gameActivity.findViewById(R.id.gameOver);
            gameOverLayout.setVisibility(View.VISIBLE);
            TextView gameOverMessage = gameActivity.findViewById(R.id.winlosemessage);
            if ((lettersCorrect == word.length())) {
                /**
                 * THIS IS THE GAME WON CODESPACE THIS IS WHERE WE NEED TO UPDATE STATS
                 * THE WORD IS STORED IN STRING VAR 'word'
                 * TIME IS STORED in 'gameActivity.getTimer().getTimeElapsed();' UNIT IS MILISECONDS
                 * LOOK AT UPDATE FUNCTION IN STATS FOR THE REST AND FIGURE IT OUT LOLL <3
                 */
                gameOverMessage.setText("You Won!");
                gameActivity.findViewById(R.id.timetowin).setVisibility(View.VISIBLE);
            } else {
                gameOverMessage.setText("You Lost!");
            }
            /*disable keyboard to prevent user from guessing after game over*/
            LinearLayout keyboard = gameActivity.findViewById(R.id.keyboard);
            for(int i = 0; i < keyboard.getChildCount(); i++){
                LinearLayout row = (LinearLayout) keyboard.getChildAt(i);
                for(int j = 0; j < row.getChildCount(); j++){
                    Button curButton = (Button) row.getChildAt(j);
                    curButton.setEnabled(false);
                }
            }
        }
    }
}
