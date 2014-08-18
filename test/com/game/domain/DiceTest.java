package com.game.domain;

import com.game.literals.GameLiterals;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiceTest {

    @Test
    public void should_never_generate_random_number_more_than_six() {
        //Given
        int maxNumberAllowed = 6;
        Dice dice = new Dice();
        //When
        int diceNumber = dice.roll();
        //Then
        boolean isDiceNumberLessThanMaxLimit = (diceNumber <= maxNumberAllowed);
        assertThat(true, is(isDiceNumberLessThanMaxLimit));

    }



    @Test
    public void check_if_generated_number_is_in_range() {
        int diceNumber;
        int lowestPossibleDiceNumber = 1;
        int highestPossibleDiceNumber = 6;
        Dice dice = new Dice();

        for (int i = 0; i < 10000; i++) {
            diceNumber = dice.roll();
            if (diceNumber > GameLiterals.CHANCE_ALLOWED) {
                fail("More than 6 diceNumber has come " + diceNumber);
            }
            if (diceNumber < 0) {
                fail("Incorrect value of diceNumber " + diceNumber);
            }

            if (highestPossibleDiceNumber < diceNumber) {
                highestPossibleDiceNumber = diceNumber;
            }

            if (lowestPossibleDiceNumber > diceNumber) {
                lowestPossibleDiceNumber = diceNumber;
            }
        }

        if (lowestPossibleDiceNumber == highestPossibleDiceNumber) {
            fail("The highest diceNumber count is the same as the lowest diceNumber count. Check the method is returning a random number, and re-run the test.");
        }

        if (lowestPossibleDiceNumber != 1) {
            fail("The lowest diceNumber is " + lowestPossibleDiceNumber + " and it should be one.");
        }

        if (highestPossibleDiceNumber != GameLiterals.CHANCE_ALLOWED) {
            fail("The highest pin is " + highestPossibleDiceNumber + " and it should be " + GameLiterals.CHANCE_ALLOWED + ".");
        }

    }
}
