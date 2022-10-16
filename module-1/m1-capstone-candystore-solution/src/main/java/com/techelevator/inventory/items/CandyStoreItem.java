package com.techelevator.inventory.items;

import java.util.Objects;

/*
    This represents a single catering item in the system

    This is an abstract class that should be used as a superclass for the items.
 */
public abstract class CandyStoreItem {

    private String name;
    private double price;
    private boolean isWrapped;

    public CandyStoreItem(String name, double price, boolean isWrapped) {
        this.name = name;
        this.price = price;
        this.isWrapped = isWrapped;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isWrapped() {
        return isWrapped;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyStoreItem that = (CandyStoreItem) o;
        return Double.compare(that.price, price) == 0 && isWrapped == that.isWrapped && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, isWrapped);
    }
}
