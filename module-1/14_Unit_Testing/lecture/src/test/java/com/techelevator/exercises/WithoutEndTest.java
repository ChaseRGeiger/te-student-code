package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WithoutEndTest {

    private WithoutEnd target;

    @Before
    public void setup(){
        target = new WithoutEnd();
    }

    @Test
    public void hello_without_end(){
        String expectedResult = "ell";
        String actualResult = target.withoutEnd("Hello");
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void three_char_string(){
        Assert.assertEquals("b", target.withoutEnd("abc"));

    }

    @Test
    public void two_char_string(){
        Assert.assertEquals("", target.withoutEnd("ab"));

    }

    @Test
    public void empty_string(){
        Assert.assertEquals("", target.withoutEnd(""));

    }

    @Test
    public void null_input(){
        Assert.assertNull(target.withoutEnd(null));

    }

    @Test
    public void single_char_string(){
        Assert.assertEquals("", target.withoutEnd("a"));

    }

}
