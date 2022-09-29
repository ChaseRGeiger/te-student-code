package com.techelevator.exercises;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
           Weekday      Vacation    return
           True         True        ture
           false        false       true
           true         false       false
           false        true        true
     */




public class SleepInTest {

    //declare a variable to hold the object
    private SleepIn target;

    @Before
    public void setup(){
        target = new SleepIn();
    }

    @Test
    public void weekday_and_on_vacation(){
        //Arrange(setup)
        //Act(test)
        boolean result = target.sleepIn(true, true);

        //Assert(verify)
        Assert.assertTrue(result);
    }

    @Test
    public void weekend_and_not_on_vacation(){
        boolean result = target.sleepIn(false, false);
        Assert.assertTrue(result);
    }

    @Test
    public void weekday_and_not_on_vacation(){
        boolean result = target.sleepIn(true, false);
        Assert.assertFalse(result);
    }

    @Test
    public void weekend_and_on_vacation(){
        boolean result = target.sleepIn(false, true);
        Assert.assertTrue(result);
    }

    @After
    public void cleanUp(){
        System.out.println("After is optional, often not needed");
    }

}
