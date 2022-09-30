package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    a null
    b null
    full a and b
    empty a full b
    full a empty b
    both empty
 */
public class NonStartTest {


    private NonStart target;

    @Before
    public void setup(){
        target = new NonStart();
    }

    @Test
    public void null_a(){
        Assert.assertEquals("ello", target.getPartialString(null, "Hello"));
    }

    @Test
    public void null_b(){
        Assert.assertEquals("ello", target.getPartialString("Hello", null));
    }

    @Test
    public void full_a_and_b(){
        Assert.assertEquals("ellohere", target.getPartialString("Hello", "There"));
    }

    @Test
    public void empty_a_and_b(){
        Assert.assertEquals("", target.getPartialString("", ""));
    }

    @Test
    public void full_a_and_empty_b(){
        Assert.assertEquals("ello", target.getPartialString("Hello", ""));
    }

    @Test
    public void empty_a_and_full_b(){
        Assert.assertEquals("here", target.getPartialString("", "There"));
    }

}
