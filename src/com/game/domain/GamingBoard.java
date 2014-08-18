package com.game.domain;

import com.game.literals.GameLiterals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingBoard {

    Map<Integer,Integer> positionSettingsMap = new HashMap<Integer, Integer>();

    public GamingBoard(){
        populatePositionSettingsMap();
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
}
