package edu.utsa.cs3443.application_programming_group_project.controller;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import edu.utsa.cs3443.application_programming_group_project.GameActivity;
import edu.utsa.cs3443.application_programming_group_project.R;
import edu.utsa.cs3443.application_programming_group_project.Stats;

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
//        System.out.println(letter);
//        System.out.println(word);
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
             * JAYDEN LEFT OFF HERE NEED TO DRAW PICTURES ON IN CORRECT GUESSES
             * MAYBE STORE NUMBER OF INCORRECT IN GAME ACTIVITY AS A FIELD AND
             * MAKE A SWITCH THAT DRAWS A CERTAIN IMAGE DEPENEDING ON THE NUMBER
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
                    hangmanImg = gameActivity.findViewById(R.id.hangman_g6);
                    gameOver = true;
                    break;
            }
            if(hangmanImg != null) hangmanImg.setVisibility(View.VISIBLE);
        }
        b.setVisibility(View.GONE);
        if(gameOver){
            gameActivity.getTimer().cancel();
            LinearLayout gameOverLayout = gameActivity.findViewById(R.id.gameOver);
            gameOverLayout.setVisibility(View.VISIBLE);
            TextView gameOverMessage = gameActivity.findViewById(R.id.winlosemessage);
            if ((lettersCorrect == word.length())) {
                gameActivity.gameEnded(1);
                gameOverMessage.setText("You Won!");
                gameActivity.findViewById(R.id.timetowin).setVisibility(View.VISIBLE);
            } else {
                gameActivity.gameEnded(0);
                gameOverMessage.setText("You Lost!\nThe word was: " + word);
            }
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
