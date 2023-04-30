package edu.utsa.cs3443.application_programming_group_project;

import android.content.res.AssetManager;

public class Stats {
    private static Stats singleInstance = null;
    private int init = 0, totalTime, wins, losses, fastestWin;
    private String longestSolve;

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getFastestWin() {
        return fastestWin;
    }

    public void setFastestWin(int fastestWin) {
        this.fastestWin = fastestWin;
    }

    public String getLongestSolve() {
        return longestSolve;
    }

    public void setLongestSolve(String longestSolve) {
        this.longestSolve = longestSolve;
    }

    private Stats(){
        setInit(1);
    }

    public static Stats getInstance()
    {
        if (singleInstance == null)
            singleInstance = new Stats();

        return singleInstance;
    }

    public void updateStats(int time, int result, String word){
        //find out how to add the time to the total
        //check against given time to see if its faster than the current fastest

        if(result == 0){
            setLosses(getLosses() + 1);
        }
        else{
            setWins(getWins() + 1);
        }

        if(word.length() > getLongestSolve().length()){
            setLongestSolve(word);
        }
    }
}
