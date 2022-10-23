package com.techelevator.hotels.model;

public class Country {

    private String country;
    private String ip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {

        return "\n--------------------------------------------" +
                "\n Country IP Details" +
                "\n--------------------------------------------" +
                "\n Country: " + country +
                "\n IP Address: " + ip;

    }
}
