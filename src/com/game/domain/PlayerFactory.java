package com.game.domain;

import com.game.literals.GameLiterals;

public class PlayerFactory {

       public Player createPlayer(String playerName){
           if(playerName.equalsIgnoreCase(GameLiterals.FIRST_PLAYER)){
               return new PlayerOne();
           }
           if(playerName.equalsIgnoreCase(GameLiterals.SECOND_PLAYER)){
               return new PlayerTwo();
           }
           return null;
       }
}
