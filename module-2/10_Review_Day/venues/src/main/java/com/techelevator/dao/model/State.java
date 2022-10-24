package com.techelevator.dao.model;

import java.util.Objects;

public class State {
    private String abbreviation;
    private String name;


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(abbreviation, state.abbreviation) && Objects.equals(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, name);
    }
}
