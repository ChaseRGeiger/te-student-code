package com.techelevator;

public class Elevator {

    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    public Elevator(int numberOfLevels){
        this.numberOfFloors = numberOfLevels;
        currentFloor = 1;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void openDoor(){
        doorOpen = true;
    }

    public void closeDoor(){
        doorOpen = false;
    }

    public void goUp(int desiredFloor){
        if(doorOpen == false){
            if(desiredFloor <= numberOfFloors && desiredFloor > currentFloor){
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor){
        if(doorOpen == false){
            if(desiredFloor >= 1 && desiredFloor < currentFloor){
                currentFloor = desiredFloor;
            }
        }
    }
}
