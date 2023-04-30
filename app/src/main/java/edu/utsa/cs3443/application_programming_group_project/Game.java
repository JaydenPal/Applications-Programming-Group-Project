package edu.utsa.cs3443.application_programming_group_project;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    //private static Game singleInstance = null;
    private String word;
    private int time;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Game(int diff, AssetManager am){
        switch(diff){
            case 0:
                //easy mode
                setWord(loadWord("easy.txt", am));
                break;
            case 1:
                //medium mode
                setWord(loadWord("medium.txt", am));
                break;
            case 2:
                //hard mode
                setWord(loadWord("hard.txt", am));
                break;
            default:
                //something messed up
                setWord("Lauren made an oopsie ;-;");
                break;
        }
    }

    /*public static Game getInstance(int diff, AssetManager am)
    {
        if (singleInstance == null)
            singleInstance = new Game(diff, am);

        return singleInstance;
    }

    public static Game getInstance()
    {
        if (singleInstance == null)
            singleInstance = new Game();

        return singleInstance;
    }*/

    public String loadWord(String fileName, AssetManager am){
        InputStream inputStream;
        int randomNum;
        Random rand = new Random();

        randomNum = rand.nextInt(99) + 1;

        try {
            inputStream = am.open(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scnr = new Scanner(inputStream);
        String word = "";
        for(int i = 1; i < 100; i++){
            String line = scnr.nextLine();
            if(i == randomNum && scnr.hasNext()) {
                word = line;
                break;
            }
        }
        scnr.close();
        return word;
    }
}
