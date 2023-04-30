package edu.utsa.cs3443.application_programming_group_project;

import android.content.Context;
import android.media.MediaPlayer;

public class MediaPlayerManager {
    private static MediaPlayerManager instance;
    private MediaPlayer musicPlayer;
    private Boolean musicCreated = false;
    private Boolean musicOn = true;

    private MediaPlayerManager(){}

    public static MediaPlayerManager getInstance(){
        if(instance == null){
            instance = new MediaPlayerManager();
        }
        return instance;
    }
    public Boolean isCreated(){
        return musicCreated;
    }
    public Boolean isMusicOn(){
        return musicOn;
    }
    public void setMusicOn(Boolean val){
        this.musicOn = val;
    }
    public void startMusic(Context c){
        musicPlayer = MediaPlayer.create(c, R.raw.music);
        musicPlayer.setLooping(true);
        musicPlayer.start();
        musicCreated = true;
    }
    public void stopMusic(){
        if(musicPlayer != null){
            musicPlayer.stop();
            musicPlayer.release();
            musicPlayer = null;
            musicCreated = false;
        }
    }
}
