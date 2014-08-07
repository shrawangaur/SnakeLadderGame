package com.game.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingBoardTest {

    @Test
    public void should_populate_snakeMap_as_provided_in_literals(){
        //Given
        Map<Integer,Integer> expectedPositionOfSnakeMap =  new HashMap<Integer, Integer>();
        expectedPositionOfSnakeMap.put(17,7);
        expectedPositionOfSnakeMap.put(54,34);
        expectedPositionOfSnakeMap.put(62,19);
        expectedPositionOfSnakeMap.put(64,60);
        expectedPositionOfSnakeMap.put(87,24);
        expectedPositionOfSnakeMap.put(93,73);
        expectedPositionOfSnakeMap.put(95,75);
        expectedPositionOfSnakeMap.put(99,78);

        //When
        GamingBoard gamingBoard = new GamingBoard();

        //Then
        Assert.assertEquals(expectedPositionOfSnakeMap, gamingBoard.getSnakeHeadToTailMap());


    }

    @Test
    public void should_populate_ladderMap_as_provided_in_literals(){
        //Given
        Map<Integer,Integer> expectedPositionOfLadderMap =  new HashMap<Integer, Integer>();
        expectedPositionOfLadderMap.put(4,14);
        expectedPositionOfLadderMap.put(9,31);
        expectedPositionOfLadderMap.put(20,38);
        expectedPositionOfLadderMap.put(28,84);
        expectedPositionOfLadderMap.put(40,59);
        expectedPositionOfLadderMap.put(51,67);
        expectedPositionOfLadderMap.put(63,81);
        expectedPositionOfLadderMap.put(71,91);

        //When
        GamingBoard gamingBoard = new GamingBoard();

        //Then
        Assert.assertEquals(expectedPositionOfLadderMap, gamingBoard.getLadderBaseToUpMap());

    }

    @Test
    public void should_populate_board_numbers_as_provided_in_literals(){
        //Given
        List<Integer> boardNumbers = new ArrayList<Integer>();
        for(int index = 1 ; index <=100; index ++){
            boardNumbers.add(index);
        }

        //When
        GamingBoard gamingBoard = new GamingBoard();

        //Then
        Assert.assertEquals(boardNumbers,gamingBoard.getBoardNumbers());
    }


}
