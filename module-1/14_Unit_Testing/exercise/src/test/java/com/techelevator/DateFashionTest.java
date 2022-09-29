package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    you and date combo both between 3 and 7 = 1
    you or date at least 8 and the other at least 3 = 2
    you or date at most 2 and the other is at most 7 = 0
    you or date at most 2 and the other is at least an 8 = going to be an error
 */
public class DateFashionTest {

    private DateFashion target;

    @Before
    public void setup(){
        target = new DateFashion();
    }

    @Test
    public void maybe_reservation(){
        Assert.assertEquals(1, target.getATable(3, 7));
    }

    @Test
    public void yes_reservation(){
        Assert.assertEquals(2, target.getATable(3, 8));
    }

    @Test
    public void no_reservation(){
        Assert.assertEquals(0, target.getATable(2, 7));
    }

//    @Test
//    public void yes_and_no_reservation(){
//        Assert.assertEquals(2, target.getATable(2, 8));
//    }


}
