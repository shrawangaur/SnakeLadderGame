package com.game.domain;

import com.game.literals.GameLiterals;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PlayerTest {

    GamingBoard gamingBoard;
    PlayerFactory playerFactory;
    Player player;
    Player playerTwo;
    @Before
    public void setUp() throws Exception {
       gamingBoard = new GamingBoard();
        playerFactory  = new PlayerFactory();
        player = playerFactory.createPlayer(GameLiterals.FIRST_PLAYER);
        playerTwo = playerFactory.createPlayer(GameLiterals.SECOND_PLAYER);

    }

    @Test
      public void should_set_new_position_if_ladder_condition_is_met_after_rolling_dice(){
        //Given
        player.setPosition(4);
        int expectedNewPosition = 14;

        //When
        player.setNewPositionsIfLadderConditionIsMet(gamingBoard);
        //Then
        Assert.assertEquals(expectedNewPosition,player.getPosition());

    }


    @Test
    public void should_set_new_position_if_snake_condition_is_met_after_rolling_dice(){
        //Given
        player.setPosition(17);
        int expectedNewPosition = 7;

        //When
        player.setNewPositionsIfSnakeConditionIsMet(gamingBoard);
        //Then
        Assert.assertEquals(expectedNewPosition,player.getPosition());

    }

    @Test
    public void should_return_true_if_player_position_equals_or_exceeds_board_number(){
        //Given
         player.setPosition(100);
        //When
         boolean actualCondition = player.isWon();
        //Then
        assertThat(true,is(actualCondition));
    }

    @Test
    public void should_return_false_if_player_position_is_less_than_maximum_number_on_board_number(){
        //Given
        player.setPosition(98);
        //When
        boolean actualCondition = player.isWon();
        //Then
        assertThat(false, is(actualCondition));
    }

    @Test
    public void should_not_move_more_than_threshold_allowed(){
        //Given
           int maxMoveAllowedByAnyPlayer = 18;

        //When
          int actualMoveByPlayer = player.rollDice();

        //Then
        boolean isActualMoveAllowed =  (actualMoveByPlayer <   maxMoveAllowedByAnyPlayer);
         assertThat(true, is(isActualMoveAllowed));

    }

    @Test
    public void should_not_move_if_threshold_condition_is_met(){
         //Given
          int totalMoveByPlayer = 18;
        //When
         int actualMoveByPlayer = player.rollDice();
         boolean isPlayerHitsPermittedThreshold =   (actualMoveByPlayer == totalMoveByPlayer);
        //Then
        if(isPlayerHitsPermittedThreshold){
            assertThat(0, is(actualMoveByPlayer));
        }

    }

    @Test
    public void should_never_generate_random_number_more_than_six(){
        //Given
          int numberOneMoreThanAllowedLimit = 7;
        //When
           int diceNumber = player.generateRandomNumber();
        //Then
           boolean isDiceNumberLessThanMaxLimit= (diceNumber < numberOneMoreThanAllowedLimit);
           assertThat(true,is(isDiceNumberLessThanMaxLimit));

    }

    @Test
    public void should_return_null_from_player_factory_if_invalid_input_is_provided(){

        //When
             Player invalidPlayer = playerFactory.createPlayer("ABC");
        //Then
        assertThat(null,is(invalidPlayer));
    }

}
