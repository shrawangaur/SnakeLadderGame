package com.game.domain;

import com.game.literals.GameLiterals;

public abstract class Player {

    protected String playerName;

    public String getPlayerName(){
        return this.playerName;
    }

    protected int position;

    public int getPosition(){
        return this.position;
    }

    public void setNewPositionsIfLadderConditionIsMet(GamingBoard gamingBoard) {
        for (Integer ladderBase : gamingBoard.getLadderBaseToUpMap().keySet()){
            if(this.getPosition() == ladderBase){
                this.setPosition(gamingBoard.getLadderBaseToUpMap().get(ladderBase));
                System.out.println("Ladder Condition For "+this.getPlayerName());
            }
        }
    }

    public void setNewPositionsIfSnakeConditionIsMet(GamingBoard gamingBoard) {
        for(Integer snakeHead : gamingBoard.getSnakeHeadToTailMap().keySet()){
            if (this.getPosition() == snakeHead){
                this.setPosition(gamingBoard.getSnakeHeadToTailMap().get(snakeHead));
                System.out.println("Snake Condition For " + this.getPlayerName());
            }
        }
    }

    public boolean isWon() {
        if(this.getPosition()>=(GameLiterals.BOARD_HORIZONTAL_LENGTH*GameLiterals.BOARD_VERTICAL_LENGTH)){
            System.out.println("PlayerTwo Position "+ this.getPosition() + " Won ");
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
            diceNumber+=(Math.random()*6 )+1;
            if(diceNumber == GameLiterals.NO_MOVEMENT_IF_TOTAL_OF_DICE){
                System.out.println("Player "+getPlayerName()+ " hits maximum number "+ " No Change In Position As Dice Number Will Now Be 0");
               return 0;
            }
          }while(diceNumber == GameLiterals.CHANCE_ALLOWED);

        return  diceNumber;
    }
}
