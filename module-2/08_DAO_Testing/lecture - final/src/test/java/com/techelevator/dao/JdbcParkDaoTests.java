package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);


    private ParkDao sut;
    private Park testPark;

    @Before
    public void setup() {
        sut = new JdbcParkDao(mockDataSource);
        testPark = new Park(0,"TestPark", LocalDate.now(), 0, false);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park parkReturned = sut.getPark(1);
        assertParksMatch(PARK_1, parkReturned);

        parkReturned = sut.getPark(3);
        assertParksMatch(PARK_3, parkReturned);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
       Park parkShouldNotBeFound = sut.getPark(99);
       Assert.assertNull(parkShouldNotBeFound);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parksReturnedForState = sut.getParksByState("AA");
        Assert.assertEquals("Wrong number of parks returned", 2, parksReturnedForState.size() );
        Assert.assertTrue("Park 1 not included", parksReturnedForState.contains( PARK_1 ));
        Assert.assertTrue("Park 3 not included", parksReturnedForState.contains( PARK_3 ));

        List<Park> shouldOnlyBe1Park = sut.getParksByState("BB");
        Assert.assertEquals("More than 1 park returned", 1, shouldOnlyBe1Park.size());
        Assert.assertEquals("The only park is not park 2", PARK_2, shouldOnlyBe1Park.get(0) );
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parkList = sut.getParksByState("ZZ");
        Assert.assertEquals("Park list wrong size", 0, parkList.size() );
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park parkReturnedFromCreate = sut.createPark(testPark);

        int newId = parkReturnedFromCreate.getParkId();
        Assert.assertTrue("Id not returned", newId > 0);

        testPark.setParkId( newId );
        Assert.assertEquals("Returned park not as expected", testPark, parkReturnedFromCreate);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park parkReturnedFromCreate = sut.createPark(testPark);

        int newId = parkReturnedFromCreate.getParkId();
        Assert.assertTrue("Id not returned", newId > 0);

        testPark.setParkId(newId);

        Park parkReturnedFromSelect = sut.getPark(newId);
        Assert.assertEquals("Park not as expected", testPark, parkReturnedFromSelect);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(999);
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setParkName("Updated");

        sut.updatePark( parkToUpdate );

        Park parkAfterUpdate = sut.getPark(1);

        Assert.assertEquals(parkToUpdate, parkAfterUpdate);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark( 1 );
        Park afterDelete = sut.getPark( 1 );
        Assert.assertNull("Park not deleted", afterDelete );

        List<Park> parksForState = sut.getParksByState("AA");
        Assert.assertEquals("Park list wrong size", 1, parksForState.size() );
        Assert.assertEquals("Wrong park returned for state", PARK_3, parksForState.get(0) );
    }

    @Test
    public void delete_all_parks_for_state() {
        sut.deletePark(1);
        sut.deletePark(3);
        List<Park> parksForState = sut.getParksByState("AA");
        Assert.assertEquals(0, parksForState.size());
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.addParkToState(3, "BB");
        List<Park> parksForState = sut.getParksByState("BB");
        Assert.assertEquals(2, parksForState.size());
        Assert.assertTrue(parksForState.contains( PARK_3 ));
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        sut.removeParkFromState(1, "AA");
        List<Park> parksForState = sut.getParksByState("AA");
        Assert.assertEquals(1, parksForState.size());
        Assert.assertEquals(PARK_3, parksForState.get(0));
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
