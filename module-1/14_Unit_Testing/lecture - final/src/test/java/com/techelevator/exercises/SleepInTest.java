package com.techelevator.exercises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    weekday     vacation    return
    true        true        true
    false       false       true
    true        false       false
    false       true        true
 */
public class SleepInTest {

    // declare a variable to hold the object we are testing
    private SleepIn target;

    @Before
    public void setup() {
        target = new SleepIn();
    }

    @After
    public void cleanup() {
        System.out.println("After is optional and often not needed");
    }

    @Test
    public void weekday_and_on_vacation() {
        // Arrange (setup)
        // Act (test)
        boolean result = target.sleepIn(true, true);
        // Assert (verify)
        Assert.assertTrue(result);
    }

    @Test
    public void weekend_and_not_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(false, false);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void weekday_and_not_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(true, false);
        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void weekend_and_on_vacation() {
        // Arrange
        // Act
        boolean result = target.sleepIn(false, true);
        // Assert
        Assert.assertTrue(result);
    }

}
