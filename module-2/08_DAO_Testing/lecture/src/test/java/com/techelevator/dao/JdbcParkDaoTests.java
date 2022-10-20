package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests{

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
        testPark = new Park(0, "TestPark", LocalDate.now(), 0, false);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = sut.getPark(1);
        assertParksMatch(PARK_1, park);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park park = sut.getPark(99);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(2, parks.size());
        Assert.assertTrue(parks.contains(PARK_1));
        Assert.assertTrue(parks.contains(PARK_3));


        parks = sut.getParksByState("BB");
        Assert.assertEquals(1, parks.size());
        Assert.assertTrue(parks.contains(PARK_2));


    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {

        List<Park> parks = sut.getParksByState("ZZ");
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park parkReturnedFromCreate = sut.createPark(testPark);

        int newId = parkReturnedFromCreate.getParkId();
        testPark.setParkId(newId);

        Assert.assertTrue(newId > 0);

    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park parkCreated = sut.createPark(testPark);

        int newId = parkCreated.getParkId();
        Assert.assertTrue(newId > 0);

        testPark.setParkId(newId);

        Park parkRetrieved = sut.getPark(newId);
        Assert.assertEquals(parkCreated, parkRetrieved);


    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getPark(1);
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(999);
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setParkName("UPDATED");

        sut.updatePark(parkToUpdate);

        Park parkAfterUpdate = sut.getPark(1);

        Assert.assertEquals(parkToUpdate, parkAfterUpdate);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark(2);

        Park retrievedPark = sut.getPark(2);
        Assert.assertNull(retrievedPark);

        List<Park> parks = sut.getParksByState("BB");
        Assert.assertEquals(0, parks.size());

    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {

        sut.addParkToState(3, "BB");
        List<Park> parksForState = sut.getParksByState("BB");
        Assert.assertEquals(2, parksForState.size());
        Assert.assertTrue(parksForState.contains(PARK_3));
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
