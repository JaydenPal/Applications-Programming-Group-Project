package edu.utsa.cs3443.application_programming_group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.utsa.cs3443.application_programming_group_project.controller.KeyBoardController;

public class GameActivity extends AppCompatActivity {
    private char[] wordDisplay;
    private String word;

    public char[] getWordDisplay() {
        return wordDisplay;
    }

    public String getWord() {
        return word;
    }

    public String getWord(int difficulty) {
        AssetManager am = getAssets();
        InputStream inStream = null;
        try {
            switch (difficulty) {
                case 0:
                    inStream = am.open("easy.txt");
                    break;
                case 1:
                    inStream = am.open("medium.txt");
                    break;
                case 2:
                    inStream = am.open("hard.txt");
                default:
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner s = new Scanner(inStream);
        ArrayList<String> words = new ArrayList<>();
        while (s.hasNextLine()) {
            String line = s.nextLine().trim();
            if (!line.isEmpty()) {
                words.add(line);
            }
        }
        s.close();
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //get difficulty and word
        int difficulty = getIntent().getIntExtra("DIFFICULTY", 0);
        this.word = getWord(difficulty);
        TextView wordView = findViewById(R.id.wordView);
        this.wordDisplay = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            wordDisplay[i] = '_';
        }
        wordView.setText(new String(wordDisplay));
        //make keyboard controller
        KeyBoardController keyBoardController = new KeyBoardController(this);

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
        Button a = findViewById(R.id.A);
        Button b = findViewById(R.id.B);
        Button c = findViewById(R.id.C);
        Button d = findViewById(R.id.D);
        Button e = findViewById(R.id.E);
        Button f = findViewById(R.id.F);
        Button g = findViewById(R.id.G);
        Button h = findViewById(R.id.H);
        Button i = findViewById(R.id.I);
        Button j = findViewById(R.id.J);
        Button k = findViewById(R.id.K);
        Button l = findViewById(R.id.L);
        Button m = findViewById(R.id.M);
        Button n = findViewById(R.id.N);
        Button o = findViewById(R.id.O);
        Button p = findViewById(R.id.P);
        Button q = findViewById(R.id.Q);
        Button r = findViewById(R.id.R);
        Button s = findViewById(R.id.S);
        Button t = findViewById(R.id.T);
        Button u = findViewById(R.id.U);
        Button v = findViewById(R.id.V);
        Button w = findViewById(R.id.W);
        Button x = findViewById(R.id.X);
        Button y = findViewById(R.id.Y);
        Button z = findViewById(R.id.Z);

        a.setOnClickListener(keyBoardController);
        b.setOnClickListener(keyBoardController);
        c.setOnClickListener(keyBoardController);
        d.setOnClickListener(keyBoardController);
        e.setOnClickListener(keyBoardController);
        f.setOnClickListener(keyBoardController);
        g.setOnClickListener(keyBoardController);
        h.setOnClickListener(keyBoardController);
        i.setOnClickListener(keyBoardController);
        j.setOnClickListener(keyBoardController);
        k.setOnClickListener(keyBoardController);
        l.setOnClickListener(keyBoardController);
        m.setOnClickListener(keyBoardController);
        n.setOnClickListener(keyBoardController);
        o.setOnClickListener(keyBoardController);
        p.setOnClickListener(keyBoardController);
        q.setOnClickListener(keyBoardController);
        r.setOnClickListener(keyBoardController);
        s.setOnClickListener(keyBoardController);
        t.setOnClickListener(keyBoardController);
        u.setOnClickListener(keyBoardController);
        v.setOnClickListener(keyBoardController);
        w.setOnClickListener(keyBoardController);
        x.setOnClickListener(keyBoardController);
        y.setOnClickListener(keyBoardController);
        z.setOnClickListener(keyBoardController);
    }
}