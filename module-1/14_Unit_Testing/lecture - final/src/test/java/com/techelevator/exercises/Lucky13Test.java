package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

    /*
    return false if array contains 1
    return false if array contains 3
    return true if the array contains no 1s or 3s
     */

    private Lucky13 target;

    @Before
    public void setup() {
        target = new Lucky13();
    }

    @Test
    public void test_for_ones() {
        //arrange
        int[] testArray = {1, 2, 4, 6};
        //act
        boolean hasOne = target.lucky13(testArray);
        //assert
        Assert.assertFalse(hasOne);
    }


    @Test
    public void test_for_threes() {
        // Arrange
        int[] testArray = {2, 3, 4, 5};
        // Act
        boolean hasThree = target.lucky13(testArray);
        // Assert
        Assert.assertFalse(hasThree);
    }

    @Test
    public void test_for_none(){

        int[] testArray = {2,4,6,8};
        boolean hasNone = target.lucky13(testArray);
        Assert.assertTrue(hasNone);

    }
}
