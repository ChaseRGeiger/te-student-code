package com.techelevator.dao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Venue {

    private long id;
    private String name;
    private String city;
    private String description;
    private State state;
    private List<String> categories = new ArrayList<String>();

    public void addCategory(String category) {
        categories.add(category);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return id == venue.id && Objects.equals(name, venue.name) && Objects.equals(city, venue.city) && Objects.equals(description, venue.description) && Objects.equals(state, venue.state) && Objects.equals(categories, venue.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, description, state, categories);
    }
}
