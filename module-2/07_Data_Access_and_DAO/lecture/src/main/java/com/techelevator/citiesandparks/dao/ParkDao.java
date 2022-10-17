package com.techelevator.citiesandparks.dao;

import com.techelevator.citiesandparks.model.Park;

import java.util.List;

public interface ParkDao {

    Park getPark(int parkId);

    List<Park> getParksByState(String stateAbbreviation);

    Park createPark(Park park);

    void updatePark(Park park);

    void deletePark(int parkId);

    void addParkToState(int parkId, String stateAbbreviation);

    void removeParkFromState(int parkId, String stateAbbreviation);
}
