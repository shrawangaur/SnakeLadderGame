package com.game.domain;

import com.game.literals.GameLiterals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class PlayerTest {

    GamingBoard gamingBoard;
    Player player;
    Player playerTwo;

    @Before
    public void setUp() throws Exception {
        gamingBoard = new GamingBoard();
        player = new Player(GameLiterals.FIRST_PLAYER);
        playerTwo = new Player(GameLiterals.SECOND_PLAYER);

    }

    @Test
    public void should_set_new_position_if_ladder_condition_is_met_after_rolling_dice() {
        //Given
        player.setPosition(4);
        int expectedNewPosition = 14;

        //When
        player.setNewPositionsIfLadderConditionIsMet(gamingBoard);
        //Then
        Assert.assertEquals(expectedNewPosition, player.getPosition());

    }


    @Test
    public void should_set_new_position_if_snake_condition_is_met_after_rolling_dice() {
        //Given
        player.setPosition(17);
        int expectedNewPosition = 7;

        //When
        player.setNewPositionsIfSnakeConditionIsMet(gamingBoard);
        //Then
        Assert.assertEquals(expectedNewPosition, player.getPosition());

    }

    @Test
    public void should_return_true_if_player_position_equals_or_exceeds_board_number() {
        //Given
        player.setPosition(100);
        //When
        boolean actualCondition = player.isWon();
        //Then
        assertThat(true, is(actualCondition));
    }

    @Test
    public void should_return_false_if_player_position_is_less_than_maximum_number_on_board_number() {
        //Given
        player.setPosition(98);
        //When
        boolean actualCondition = player.isWon();
        //Then
        assertThat(false, is(actualCondition));
    }

    @Test
    public void should_not_move_more_than_threshold_allowed() {
        //Given
        int maxMoveAllowedByAnyPlayer = 18;

        //When
        int actualMoveByPlayer = player.rollDice();

        //Then
        boolean isActualMoveAllowed = (actualMoveByPlayer < maxMoveAllowedByAnyPlayer);
        assertThat(true, is(isActualMoveAllowed));

    }

    @Test
    public void should_stay_in_same_position_if_player_hits_threshold_count() {

        //Given
        Player player = new Player();
        Dice dice = Mockito.mock(Dice.class);
        when(dice.roll()).thenReturn(6);
        player.setDice(dice);
        //When
        int diceNumber = player.rollDice();

        //Then
        Assert.assertEquals(0,diceNumber);
    }

    @Test
    public void player_should_move_in_accordance_with_dice_number_he_hits(){
        //Given
        Player player = new Player();
        Dice dice = Mockito.mock(Dice.class);
        when(dice.roll()).thenReturn(4);
        player.setDice(dice);
        player.setPosition(1);
        //When
            int diceNumber = player.rollDice();
            player.setPosition(player.getPosition()+diceNumber);
        //Then
           Assert.assertEquals(5,player.getPosition());
    }


}
