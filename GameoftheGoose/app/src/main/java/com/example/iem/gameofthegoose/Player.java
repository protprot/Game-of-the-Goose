package com.example.iem.gameofthegoose;

import java.io.Serializable;

/**
 * Created by iem on 06/01/16.
 */
public class Player implements Serializable {

    String name;
    int image;
    int answerTime;

    public Player (String name, int image, int answerTime) {

        this.name = name;
        this.image = image;
        this.answerTime = answerTime;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getAnswerTime() { return answerTime; }

    @Override
    public String toString() {
        return "Joueur : " + name + ", pion : " + image + ", temps de réponse : " + answerTime;
    }
}
