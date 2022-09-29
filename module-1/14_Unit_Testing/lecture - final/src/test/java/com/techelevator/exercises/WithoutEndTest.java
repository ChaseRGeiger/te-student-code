package com.techelevator.exercises;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WithoutEndTest {

    private WithoutEnd target;

    @Before
    public void setup() {
        target = new WithoutEnd();
    }

    /*
        Hello -> ell
        abc -> b
        ab -> ""
        a -> ""
        "" -> ""
        null ->  null
     */

    @Test
    public void full_length_string() {
        String expectedResult = "ell";
        // Arrange
        // Act
        String actualResult = target.withoutEnd("Hello");
        // Assert
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void three_char_string() {
        Assert.assertEquals("b", target.withoutEnd("abc"));
    }

    @Test
    public void two_char_string() {
        String result = target.withoutEnd("ab");
        Assert.assertEquals("", result);
    }

    @Test
    public void single_char_string() {
        String result = target.withoutEnd("a");
        Assert.assertEquals("", result);
    }

    @Test
    public void empty_string() {
        String result = target.withoutEnd("");
        Assert.assertEquals("", result);
    }

    @Test
    public void null_string() {
        String result = target.withoutEnd(null);
        Assert.assertNull(result);
    }


}
