package com.techelevator.printer;

public class House implements Printable {

    private String color;
    private int numberOfWindows;
    private int numberOfRooms;
    private String address;

    public House(String color, int numberOfRooms, int numberOfWindows, String address) {
        this.color = color;
        this.numberOfRooms = numberOfRooms;
        this.numberOfWindows = numberOfWindows;
        this.address = address;
    }

    public void print() {
        String message = "The " + this.color + " house with "
                + numberOfRooms + " rooms and " + numberOfWindows
                + " windows that is located at " + address;
        System.out.println(message);
    }

}
