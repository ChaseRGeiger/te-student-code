package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    private AnimalGroupName target;

    @Before
    public void setup(){
        target = new AnimalGroupName();
    }

    @Test
    public void has_correct_animal(){

        Assert.assertEquals(target.getHerd("rhino"), "Crash");

    }

    @Test
    public void incorrect_animal(){
        Assert.assertEquals(target.getHerd("walrus"), "unknown");
    }

    @Test
    public void no_animal(){
        Assert.assertEquals(target.getHerd(""), "unknown");
    }

    @Test
    public void null_input(){
        Assert.assertEquals(target.getHerd(null), "unknown");
    }


}
