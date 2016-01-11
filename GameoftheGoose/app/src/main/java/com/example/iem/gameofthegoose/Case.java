package com.example.iem.gameofthegoose;

/**
 * Created by iem on 11/01/16.
 */
public class Case {

    int num;
    int imageId;
    boolean bonus;
    boolean malus;
    int type;
    int x;
    int y;
    int haut;
    int larg;

    public Case(int num, int imageId, boolean bonus, boolean malus, int type, int x, int y, int haut, int larg) {
        this.num = num;
        this.imageId = imageId;
        this.bonus = bonus;
        this.malus = malus;
        this.type = type;
        this.x = x;
        this.y = y;
        this.haut = haut;
        this.larg = larg;
    }

    public int getNum() {
        return num;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean isBonus() {
        return bonus;
    }

    public boolean isMalus() {
        return malus;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHaut() {
        return haut;
    }

    public int getLarg() {
        return larg;
    }
}
