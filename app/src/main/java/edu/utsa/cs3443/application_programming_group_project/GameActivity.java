package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView t1 = findViewById(R.id.placeholder);
        t1.setText(getIntent().getStringExtra("WORD"));

        TextView t2 = findViewById(R.id.time);

        long maxCounter = 3000000;
        long diff = 1000;

        new CountDownTimer(maxCounter , diff ) {

            public void onTick(long millisUntilFinished) {
                long diff = maxCounter - millisUntilFinished;
                long timeInSec = diff / 1000;
                String s = "Time: \n" + timeInSec / 60 + ":" + timeInSec % 60;
                t2.setText(s);
            }

            @Override
            public void onFinish() {

                /* Note from Lauren:
                *           This is the idea I had for the
                *           activity result. I think it would
                *           work if we can figure out how to
                *           get results from secondary activities.
                */

                /* pass back different infos:
                        win/loss
                        time it took

                   Look into storing it as one int:
                        If win: long result = diff + 20000000;
                        If loss: long result = diff + 10000000;
                    Thus:
                        scoreResult = result - 10000000;
                        if(scoreResult > 3000000){
                            increment wins++
                            add (result - 10000000) to total time
                        }
                        else{
                            increment losses++
                            add result to the total time
                        }

                */
            }

        }.start();

        /* Listen for button clicks from Jayden's keyboard. */
    }
}