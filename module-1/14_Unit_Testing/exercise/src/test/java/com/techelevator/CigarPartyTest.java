package com.techelevator;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    no weekend 40-60 cigars
    no wknd 39 cigars
    no wknd 61 cigars
    weekend 40+ cigars
    weekend 39 cigars


 */
public class CigarPartyTest {

    private CigarParty target;

    @Before
    public void setup(){
        target = new CigarParty();
    }

    @Test
    public void weekday_and_within_cigar_limit(){
        Assert.assertTrue(target.haveParty(50, false));
    }

    @Test
    public void weekday_and_lower_than_cigar_limit(){
        Assert.assertFalse(target.haveParty(39, false));
    }

    @Test
    public void weekday_and_above_cigar_limit(){
        Assert.assertFalse(target.haveParty(61, false));
    }

    @Test
    public void weekend_and_minimum_cigar_limit_reached(){
        Assert.assertTrue(target.haveParty(75, true));
    }

    @Test
    public void weekend_and_below_cigar_limit(){
        Assert.assertFalse(target.haveParty(39, true));
    }

}
