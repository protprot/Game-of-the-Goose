package com.example.iem.gameofthegoose;

import java.io.Serializable;

/**
 * Created by iem on 06/01/16.
 */
public class Player implements Serializable {

    String name;
    int image;

    public Player (String name, int image) {

        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Joueur : " + name + ", pion : " + image;
    }
}
