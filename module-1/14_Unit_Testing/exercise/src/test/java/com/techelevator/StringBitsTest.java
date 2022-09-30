package com.techelevator;

/*
    full length str
    2 char str
    1 char string
    empty string
    null
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTest {

    private StringBits target;

    @Before
    public void setup(){
        target = new StringBits();
    }

    @Test
    public void full_string(){
        Assert.assertEquals("Hlo", target.getBits("Hello"));
    }

    @Test
    public void two_char_string(){
        Assert.assertEquals("H", target.getBits("Hi"));
    }

    @Test
    public void one_char_string(){
        Assert.assertEquals("H", target.getBits("H"));
    }

    @Test
    public void empty_string(){
        Assert.assertEquals("", target.getBits(""));
    }

    @Test
    public void null_test(){
        Assert.assertEquals("", target.getBits(null));
    }

}
