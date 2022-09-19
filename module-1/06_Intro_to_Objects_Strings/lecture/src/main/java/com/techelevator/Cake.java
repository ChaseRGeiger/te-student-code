package com.techelevator;

public class Cake {

    private String icingType;
    private boolean hasSprinkles;


    public Cake(String icingType, boolean hasSprinkles) {
        this.icingType = icingType;
        this.hasSprinkles = hasSprinkles;
    }

    public String getIcingType() {
        return icingType;
    }

    public void setIcingType(String icingType) {
        this.icingType = icingType;
    }

    public boolean isHasSprinkles() {
        return hasSprinkles;
    }

    public void setHasSprinkles(boolean hasSprinkles) {
        this.hasSprinkles = hasSprinkles;
    }

}
