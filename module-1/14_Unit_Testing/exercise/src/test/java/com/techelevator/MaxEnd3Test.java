package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    first index larger
    last index larger
    first and last index same value
    array less than size 3
    array greater than size 3
 */
public class MaxEnd3Test {

    private MaxEnd3 target;

    @Before
    public void setup(){
        target = new MaxEnd3();
    }

    @Test
    public void first_index_larger(){
        int[] newArray = {5, 3, 2};

        Assert.assertArrayEquals(new int[]{5, 5, 5}, target.makeArray(newArray));
    }

    @Test
    public void last_index_larger(){
        int[] newArray = {2, 3, 6};

        Assert.assertArrayEquals(new int[]{6, 6, 6}, target.makeArray(newArray));
    }

    @Test
    public void both_index_equal(){
        int[] newArray = {3, 5, 3};

        Assert.assertArrayEquals(new int[]{3, 3, 3}, target.makeArray(newArray));
    }

    @Test
    public void array_less_than_three(){
        int[] newArray = {2, 3};

        Assert.assertArrayEquals(new int[]{3, 3}, target.makeArray(newArray));
    }

    @Test
    public void array_greater_than_three(){
        int[] newArray = {2, 3, 5, 9};

        Assert.assertArrayEquals(new int[]{9, 9, 9, 9}, target.makeArray(newArray));
    }

}
