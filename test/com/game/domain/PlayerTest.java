package com.game.domain;

import com.game.literals.GameLiterals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void should_never_generate_random_number_more_than_six() {
        //Given
        int numberOneMoreThanAllowedLimit = 7;
        //When
        int diceNumber = player.generateRandomNumber();
        //Then
        boolean isDiceNumberLessThanMaxLimit = (diceNumber < numberOneMoreThanAllowedLimit);
        assertThat(true, is(isDiceNumberLessThanMaxLimit));

    }

    @Test
    public void should_stay_in_same_position_if_player_hits_threshold_count() {

        //Given
        Player player = new PartialPlayerTestWithFixedRandomGenerator(6);
        //When
        int diceNumber = player.rollDice();

        //Then
        Assert.assertEquals(0,diceNumber);
    }


    @Test
    public void should_be_allowed_a_second_chance_if_player_hits_six_on_dice(){
        //Given
        Player player = new PartialPlayerTestWithRandomGenerator(6,4);
        //When
        int diceNumber  = player.rollDice();
        //Then
        Assert.assertEquals(10,diceNumber);
    }

    @Test
    public void player_should_move_in_accordance_with_dice_number_he_hits(){
        //Given
            Player player = new PartialPlayerTestWithFixedRandomGenerator(2);
            player.setPosition(1);
        //When
            int diceNumber = player.rollDice();
            player.setPosition(player.getPosition()+diceNumber);
        //Then
           Assert.assertEquals(3,player.getPosition());
    }

    private class PartialPlayerTestWithFixedRandomGenerator extends Player {

        private int diceNumber;

        private PartialPlayerTestWithFixedRandomGenerator(int diceNumber) {
            this.diceNumber = diceNumber;
        }

        @Override
        protected int generateRandomNumber() {

            return diceNumber;
        }
    }

    private class PartialPlayerTestWithRandomGenerator extends Player {

        private int firstDiceNumber;
        private int secondDiceNumber;
        private boolean isFirstTimeToRollDice;  //We are going to return 6 for first time . for next chance, return number less than 6

        private PartialPlayerTestWithRandomGenerator(int firstDiceNumber,int secondDiceNumber) {
            this.firstDiceNumber = firstDiceNumber;
            this.secondDiceNumber = secondDiceNumber;
            isFirstTimeToRollDice = true;
        }

        @Override
        protected int generateRandomNumber() {
            if(isFirstTimeToRollDice) {
                isFirstTimeToRollDice = false;
                return firstDiceNumber;
            }else {
                return secondDiceNumber;
            }
        }
    }
}
