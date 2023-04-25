package edu.utsa.cs3443.application_programming_group_project;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private String word;

    public Game(int diff, AssetManager am){
        switch(diff){
            case 0:
                //easy mode
                word = loadWord("easy.txt", am);
                break;
            case 1:
                //medium mode
                word = loadWord("medium.txt", am);
                break;
            case 2:
                //hard mode
                word = loadWord("hard.txt", am);
                break;
            default:
                //something messed up
                System.out.println("Lauren made an oopsie ;-;");
                break;
        }
    }

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

        for(int i = 1; i < 100; i++){
            String word = "";
            if(i == randomNum && scnr.hasNext()) {
                String line = scnr.nextLine();
                word = line;
                break;
            }
        }
        scnr.close();
        return word;
    }
}
