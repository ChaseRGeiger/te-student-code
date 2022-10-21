package com.techelevator.dao;

import com.techelevator.BaseDaoTests;
import com.techelevator.dao.model.State;
import com.techelevator.dao.model.Venue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcVenueDaoTest extends BaseDaoTests {

    private VenueDao venueDao;
    private Venue testVenueOne;

    @Before
    public void setup() {
        venueDao = new JdbcVenueDao(dataSource);
        testVenueOne = new Venue();
        testVenueOne.setId(1);
        testVenueOne.setName("Hidden Owl Eatery");
        testVenueOne.setCity("Bona");
        testVenueOne.setDescription("This venue has plenty of \"property\" to enjoy. Roll the dice and check out all of our spaces.");

        State state = new State();
        state.setName("Michigan");
        state.setAbbreviation("MI");
        testVenueOne.setState(state);
        testVenueOne.addCategory("Family Friendly");
        testVenueOne.addCategory("Modern");
    }


    @Test
    public void get_all_venues_returns_all_venues() {
        List<Venue> venuesReturned = venueDao.getAllVenues();
        Assert.assertEquals(15, venuesReturned.size());
        Assert.assertTrue(venuesReturned.contains(testVenueOne));
    }
}
