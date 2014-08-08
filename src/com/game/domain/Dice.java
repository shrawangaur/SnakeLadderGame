package com.game.domain;

/**
 * Created by sg22702 on 8/8/14.
 */
public class Dice {

    protected int roll() {
        return (int)(Math.random()*6 )+1;
    }

}
