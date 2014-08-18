package com.game.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingBoardTest {

    @Test
    public void should_populate_positionSettingMap_as_provided_in_literals(){
        //Given
        Map<Integer,Integer> expectedPositionSettingsMap =  new HashMap<Integer, Integer>();
        expectedPositionSettingsMap.put(17, 7);
        expectedPositionSettingsMap.put(54, 34);
        expectedPositionSettingsMap.put(62, 19);
        expectedPositionSettingsMap.put(64, 60);
        expectedPositionSettingsMap.put(87, 24);
        expectedPositionSettingsMap.put(93, 73);
        expectedPositionSettingsMap.put(95, 75);
        expectedPositionSettingsMap.put(99, 78);
        expectedPositionSettingsMap.put(4,14);
        expectedPositionSettingsMap.put(9,31);
        expectedPositionSettingsMap.put(20,38);
        expectedPositionSettingsMap.put(28,84);
        expectedPositionSettingsMap.put(40,59);
        expectedPositionSettingsMap.put(51,67);
        expectedPositionSettingsMap.put(63,81);
        expectedPositionSettingsMap.put(71,91);

        //When
        GamingBoard gamingBoard = new GamingBoard();

        //Then
        Assert.assertEquals(expectedPositionSettingsMap, gamingBoard.getPositionSettingsMap());


    }

}
