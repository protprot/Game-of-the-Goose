package com.example.iem.gameofthegoose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iem on 06/01/16.
 */
public class Settings implements Serializable {

    int nbPlayer;
    int lvlDifficulty;
    int answerTime;
    int gameTime;
    List<Player> listPlayer;

    public Settings (int pickerPlayer, int pickerDifficulty, int pickerAnswerTime, int pickerGameTime) {

        nbPlayer = pickerPlayer;
        lvlDifficulty = pickerDifficulty;

        switch (pickerAnswerTime) {
            case 1:
                answerTime = 30;
                break;
            case 2:
                answerTime = 60;
                break;
            case 3:
                answerTime = 120;
                break;
            case 4:
                answerTime = 180;
                break;
        }

        switch (pickerGameTime) {
            case 1:
                gameTime = 30;
                break;
            case 2:
                gameTime = 45;
                break;
            case 3:
                gameTime = 60;
                break;
            case 4:
                gameTime = 120;
        }

        listPlayer = new ArrayList<>();
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public int getLvlDifficulty() {
        return lvlDifficulty;
    }

    public int getAnswerTime() {
        return answerTime;
    }

    public int getGameTime() {
        return gameTime;
    }

    @Override
    public String toString() {

        String s = "nb Joueurs : " + nbPlayer + "\n" +
        "lvl Difficulté : " + lvlDifficulty + "\n" +
        "Temps réponse : " + answerTime + "\n" +
        "Temps Jeu : " + gameTime + "\n";

        for (int i=0 ; i<listPlayer.size() ; i++){
            s = s + listPlayer.get(i).toString() + "\n";
        }


        return s;
    }

    public void addPlayer(Player p) {

        listPlayer.add(p);
    }
}
