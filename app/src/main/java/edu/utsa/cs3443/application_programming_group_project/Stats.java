package edu.utsa.cs3443.application_programming_group_project;

import android.content.res.AssetManager;

public class Stats {
    private static Stats singleInstance = null;
    private int init = 0, wins, losses;
    long totalTime, fastestWin;
    private String longestSolve;

    public int getInit() {
        return init;
    }

    public void setInit(int init) {
        this.init = init;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
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

    public long getFastestWin() {
        return fastestWin;
    }

    public void setFastestWin(long fastestWin) {
        this.fastestWin = fastestWin;
    }

    public String getLongestSolve() {
        return longestSolve;
    }

    public void setLongestSolve(String longestSolve) {
        this.longestSolve = longestSolve;
    }

    private Stats(){
        this.init = 1;
        this.totalTime = 0;
        this.longestSolve = "";
        this.fastestWin = 0;
        this.losses = 0;
        this.wins = 0;
    }

    public static Stats getInstance()
    {
        if (singleInstance == null)
            singleInstance = new Stats();

        return singleInstance;
    }

    public void updateStats(long time, int result, String word){

        //increment losses or wins
        if(result == 0){
            setLosses(getLosses() + 1);
        }
        else{
            setWins(getWins() + 1);
        }

        //update longest word solved
        if(word.length() > getLongestSolve().length() && result == 1){
            setLongestSolve(word);
        }

        //update total time played
        setTotalTime(getTotalTime() + time);

        //update fastest record
        if(getFastestWin() == 0 || getFastestWin() > time){
            setFastestWin(time);
        }
    }
}
