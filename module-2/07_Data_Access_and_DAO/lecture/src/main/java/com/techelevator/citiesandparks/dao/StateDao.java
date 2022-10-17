package com.techelevator.citiesandparks.dao;

import com.techelevator.citiesandparks.model.State;

import java.util.List;

public interface StateDao {

    State getState(String stateAbbreviation);

    State getStateByCapital(int cityId);

    List<State> getStates();
}
