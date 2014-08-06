package com.game.domain;

import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingBoard {

    List<Integer> boardNumbers = new ArrayList<Integer>();
    Map<Integer,Integer> snakeHeadToTailMap = new HashMap<Integer, Integer>();
    Map<Integer,Integer> ladderBaseToUpMap = new HashMap<Integer, Integer>();

    public GamingBoard(){
        populateBoardNumbers(GameLiterals.BOARD_HORIZONTAL_LENGTH,GameLiterals.BOARD_VERTICAL_LENGTH);
        populateSnakeMap();
        populateLadderMap();
    }

    void populateBoardNumbers(int horizontalLength, int verticalLength){
        int totalNumbersOnBoard = horizontalLength * verticalLength;
        for (int index = 1 ; index<=totalNumbersOnBoard ; index++  ){
            boardNumbers.add(index);
        }
    }

    void populateSnakeMap(){
        for (int index=0 ; index< GameLiterals.NUMBER_OF_SNAKES_IN_GAME;index++){
            snakeHeadToTailMap.put(GameLiterals.POSITION_OF_SNAKES_IN_GAME[index][0],GameLiterals.POSITION_OF_SNAKES_IN_GAME[index][1]);
        }
    }

    void populateLadderMap(){
        for (int index = 0; index<GameLiterals.NUMBER_OF_LADDERS_IN_GAME ;index++){
            ladderBaseToUpMap.put(GameLiterals.POSITION_OF_LADDER_IN_GAME[index][0],GameLiterals.POSITION_OF_LADDER_IN_GAME[index][1]);
        }
    }

    public Map<Integer, Integer> getLadderBaseToUpMap() {
        populateLadderMap();
        return ladderBaseToUpMap;
    }

    public List<Integer> getBoardNumbers() {
        populateBoardNumbers(GameLiterals.BOARD_HORIZONTAL_LENGTH,GameLiterals.BOARD_VERTICAL_LENGTH);
        return boardNumbers;
    }

    public Map<Integer, Integer> getSnakeHeadToTailMap() {
        populateSnakeMap();
        return snakeHeadToTailMap;
    }

}
