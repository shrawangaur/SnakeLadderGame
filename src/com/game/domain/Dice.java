package com.game.domain;

public class Dice {

    protected int roll() {
        return (int)(Math.random()*6 )+1;
    }

}
