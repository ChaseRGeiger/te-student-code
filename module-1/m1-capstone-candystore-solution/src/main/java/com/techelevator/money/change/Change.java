package com.techelevator.money.change;

import java.util.Objects;

public abstract class Change {

    private String name;
    private int value;
    private int count = 0;

    public Change(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getDisplayName() {
        return count == 1 ? name : name + "s" ;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Change change = (Change) o;
        return value == change.value && count == change.count && Objects.equals(name, change.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, count);
    }

    @Override
    public String toString() {
        return "(" + count + ") " + getDisplayName();
    }
}
