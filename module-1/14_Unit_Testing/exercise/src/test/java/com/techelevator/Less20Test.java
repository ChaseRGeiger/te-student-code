package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    one less mod 20 = true
    two less mod 20 = true
    three less mod 20 = false
    mod 20 = false
    one more mod 20 = false
    negative num check = false
 */
public class Less20Test {

    private Less20 target;

    @Before
    public void setup(){
        target = new Less20();
    }

    @Test
    public void one_less_mod_20(){
        Assert.assertTrue(target.isLessThanMultipleOf20(39));
    }

    @Test
    public void two_less_mod_20(){
        Assert.assertTrue(target.isLessThanMultipleOf20(38));
    }

    @Test
    public void mod_20(){
        Assert.assertFalse(target.isLessThanMultipleOf20(40));
    }

    @Test
    public void three_less_mod_20(){
        Assert.assertFalse(target.isLessThanMultipleOf20(37));
    }

    @Test
    public void one_more_mod_20(){
        Assert.assertFalse(target.isLessThanMultipleOf20(41));
    }

    @Test
    public void negative_num_check(){
        Assert.assertFalse(target.isLessThanMultipleOf20(-40));
    }

}
