package com.game.domain;

import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingBoard {

    List<Integer> boardNumbers = new ArrayList<Integer>();
    Map<Integer,Integer> positionSettingsMap = new HashMap<Integer, Integer>();

    public GamingBoard(){
        populateBoardNumbers(GameLiterals.BOARD_HORIZONTAL_LENGTH, GameLiterals.BOARD_VERTICAL_LENGTH);
        populatePositionSettingsMap();
    }

    private void populateBoardNumbers(int horizontalLength, int verticalLength){
        int totalNumbersOnBoard = horizontalLength * verticalLength;
        for (int index = 1 ; index<=totalNumbersOnBoard ; index++  ){
            boardNumbers.add(index);
        }
    }

    private void populatePositionSettingsMap(){
        for (int index=0 ; index< GameLiterals.POSITION_SETTINGS_IN_GAME.length;index++){
            positionSettingsMap.put(GameLiterals.POSITION_SETTINGS_IN_GAME[index][0], GameLiterals.POSITION_SETTINGS_IN_GAME[index][1]);
        }
    }

    public Map<Integer, Integer> getPositionSettingsMap() {
        populatePositionSettingsMap();
        return positionSettingsMap;
    }

    public List<Integer> getBoardNumbers() {
        return boardNumbers;
    }
}
