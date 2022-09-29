package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    string of at least 3 chars repeated n amt of times
    string less than 3 chars but greater than 0
    string repeated 0 times
    string repeated negative times
    null string
 */
public class FrontTimesTest {

    private FrontTimes target;

    @Before
    public void setup(){
        target = new FrontTimes();
    }

    @Test
    public void three_char_string_with_positive_n(){
        Assert.assertEquals("ABCABCABC", target.generateString("ABC", 3));
    }

    @Test
    public void one_char_string_with_positive_n(){
        Assert.assertEquals("DDD", target.generateString("D", 3));
    }

    @Test
    public void string_with_zero_n(){
        Assert.assertEquals("", target.generateString("ABC", 0));
    }

    @Test
    public void string_with_negative_n(){
        Assert.assertEquals("", target.generateString("ABC", -3));
    }

    @Test
    public void null_string(){
        Assert.assertEquals("", target.generateString(null, 3));
    }

}
