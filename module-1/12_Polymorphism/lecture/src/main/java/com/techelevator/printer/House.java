package com.techelevator.printer;

public class House implements Printable {

    private String color;
    private int numOfWindows;
    private int numOfRooms;
    private String address;

    public House(String color, int numOfRooms, int numOfWindows, String address){
        this.color = color;
        this.numOfRooms = numOfRooms;
        this.numOfWindows = numOfWindows;
        this.address = address;
    }

    public void print(){
        String message = "The " + this.color + " house with " + numOfRooms + " rooms has " + numOfWindows + " windows";
        System.out.println(message);
    }
}
