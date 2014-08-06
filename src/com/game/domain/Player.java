package com.game.domain;

/**
 * Created by acer on 8/7/2014.
 */
public abstract class Player {

    protected String playerName;

    public String getPlayerName(){
        return this.playerName;
    }

    protected int position;

    public abstract int getPosition();

    public abstract void setPosition(int position);

    public abstract boolean isChanceToRollDice(int diceNumber);

    public abstract boolean isWon();

    public int rollDice() {
        return (int)(Math.random()*6 )+1;
    }
}
