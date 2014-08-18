package com.game.domain;

import com.game.literals.GameLiterals;

public class Player {

    protected String playerName;

    protected int position;
    Dice dice = new Dice();

    public Player(){}

    public Player(String playerName) {
        this.playerName = playerName;
        this.position = GameLiterals.START_POINT;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getPosition(){
        return this.position;
    }

   public boolean isWon() {
        if(this.getPosition()>=(GameLiterals.BOARD_HORIZONTAL_LENGTH * GameLiterals.BOARD_VERTICAL_LENGTH)){
            System.out.println("Player " +getPlayerName() +" With Position "+ this.getPosition() + "  has Won!! ");
            return true;
        }
        return false;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int rollDice() {
        int diceNumber = 0;
            do{
            diceNumber+= dice.roll();
            if(diceNumber == GameLiterals.NO_MOVEMENT_IF_TOTAL_OF_DICE_BECOMES_THRESHOLD){
                System.out.println("Player Playing -->" + getPlayerName() + " hits maximum number " + " No Change In Position As Dice Number Will Now Be 0");
               return 0;
            }
          }while(diceNumber%GameLiterals.CHANCE_ALLOWED==0);
        return  diceNumber;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
