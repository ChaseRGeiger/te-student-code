package com.techelevator.vehicle;

import java.util.Locale;

public class Bus {

    private final static int TOTAL_SEATS = 40;

    /*
        Member variables
        Should always be private
     */
    private String routeName;
    private int passengers;
    private int gallonsOfGas = 50;
    private boolean isDoorOpen = false;

    /*
        Constructors
     */
    /*
        No argument constructor
        Provided by default if no constructor overloads are included
        If a another overload exists, then must explicitly include the no-arg
        constructor IF the class should be able to be instantiated without
        arguments.
     */
    public Bus() {

    }
    public Bus(String routeName) {
        this.routeName = cleanRouteName(routeName);
    }

    /*
        Getter gives public access to a member variable
     */
    public String getRouteName() {
        return routeName;
    }

    /*
        Setter gives public access to change the value of member variable
     */
    public void setRouteName(String routeName) {
        this.routeName = cleanRouteName(routeName);
    }


    /*
        For boolean values getters start with is instead of get
     */
    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    /*
        Encapsulated Getters/Setters allow the user of the class
        to change the values of the member variables in an easier
        to understand way

        Example:  openDoor()   instead of setIsDoorOpen(true)
     */
    public void addGas(int gallons) {
        this.gallonsOfGas += gallons;
    }

    public int getGallonsOfGas() {
        return this.gallonsOfGas;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    /*
        A derived property looks like a getter, but
        calculates the result and returns it instead of storing it
     */
    public int getRemainingSeats() {
        return TOTAL_SEATS - this.passengers;
    }

    public boolean board() {
        if (this.isDoorOpen && getRemainingSeats() > 0) {
            this.passengers += 1;
            return true;
        }
        return false;
    }

    public boolean board(int boardingPassengers) {
        if (this.isDoorOpen && getRemainingSeats() >= boardingPassengers) {
            this.passengers += boardingPassengers;
            return true;
        }
        return false;
    }

    private String cleanRouteName(String routeName) {
        String name = routeName.replace(" ", "-");
        return name.toUpperCase();
    }

}
