package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

    private Lucky13 target;

    @Before
    public void setup(){
        target = new Lucky13();
    }

    @Test
    public void has_one(){
        int[] newArray = {1, 2, 5, 7};
        Assert.assertFalse(target.lucky13(newArray));

    }

    @Test
    public void has_three(){
        int[] newArray = {2, 2, 3, 8};
        Assert.assertFalse(target.lucky13(newArray));
    }

    @Test
    public void no_ones_or_threes(){
        int[] newArray = {2, 4, 6, 7};
        Assert.assertTrue(target.lucky13(newArray));
    }


}
