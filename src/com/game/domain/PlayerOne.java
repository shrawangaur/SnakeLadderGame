package com.game.domain;

import com.game.literals.GameLiterals;

/**
 * Created by acer on 8/7/2014.
 */
public class PlayerOne extends Player {

    public PlayerOne(){
        setPosition(0);
        setPlayerName();
    }

    @Override
    public boolean isChanceToRollDice(int diceNumber) {
        if(this.getPosition()==0){
            return true;
        }if(diceNumber==GameLiterals.CHANCE_ALLOWED){
            return true;
        }
        return true;
    }

    @Override
    public boolean isWon() {
        if(this.getPosition()>=(GameLiterals.BOARD_HORIZONTAL_LENGTH*GameLiterals.BOARD_VERTICAL_LENGTH)){
            System.out.println("PlayerOne Position "+ this.getPosition() + " Won ");
            return true;
        }
        return false;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public void setPlayerName(){
        playerName = "PlayerOne";
    }
}
