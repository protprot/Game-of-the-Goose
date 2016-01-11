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
    int nbDice;
    int gameTime;
    List<Player> listPlayer;

    public Settings (int pickerPlayer, int pickerDifficulty, int nbDice, int pickerGameTime) {

        this.nbPlayer = pickerPlayer;
        this.lvlDifficulty = pickerDifficulty;
        this.nbDice = nbDice;

        switch (pickerGameTime) {
            case 1:
                this.gameTime = 5;
                break;
            case 2:
                this.gameTime = 10;
                break;
            case 3:
                this.gameTime = 15;
                break;
            case 4:
                this.gameTime = 20;
                break;
        }

        listPlayer = new ArrayList<>();
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public int getLvlDifficulty() {
        return lvlDifficulty;
    }

    public int getNbDice() {
        return nbDice;
    }

    public int getGameTime() {
        return gameTime;
    }

    @Override
    public String toString() {

        String s = "nb Joueurs : " + nbPlayer + "\n" +
        "lvl Difficulté : " + lvlDifficulty + "\n" +
        "Nombre de dé(s) : " + nbDice + "\n" +
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
