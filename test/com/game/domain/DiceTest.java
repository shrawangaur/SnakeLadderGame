package com.game.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiceTest {

    @Test
    public void should_never_generate_random_number_more_than_six() {
        //Given
        int numberOneMoreThanAllowedLimit = 7;
        Dice dice = new Dice();
        //When
        int diceNumber = dice.roll();
        //Then
        boolean isDiceNumberLessThanMaxLimit = (diceNumber < numberOneMoreThanAllowedLimit);
        assertThat(true, is(isDiceNumberLessThanMaxLimit));

    }
}