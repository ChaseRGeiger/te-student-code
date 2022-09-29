package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    empty array
    first and last element the same
    first and last arent the same
    array of length 1
 */
public class SameFirstLastTest {

    private SameFirstLast target;

    @Before
    public void setup(){
        target = new SameFirstLast();
    }

    @Test
    public void first_and_last_same(){
        int[] newArray = {1, 3, 4, 1};
        Assert.assertTrue(target.isItTheSame(newArray));
    }

    @Test
    public void length_of_one(){
        int[] newArray = {1};
        Assert.assertTrue(target.isItTheSame(newArray));
    }

    @Test
    public void empty_array(){
        int[] newArray = {};
        Assert.assertFalse(target.isItTheSame(newArray));
    }

    @Test
    public void first_and_last_not_same(){
        int[] newArray = {1, 3, 4, 6};
        Assert.assertFalse(target.isItTheSame(newArray));
    }
}
