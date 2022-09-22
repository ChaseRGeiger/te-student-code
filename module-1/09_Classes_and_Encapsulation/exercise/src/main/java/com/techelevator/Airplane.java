package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;

    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;

    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){


        if(forFirstClass){
            if(bookedFirstClassSeats + totalNumberOfSeats > totalFirstClassSeats){
                return false;
            }
            bookedFirstClassSeats += totalNumberOfSeats;
            return true;
        }
        else{
            if(bookedCoachSeats + totalNumberOfSeats > totalCoachSeats){
                return false;
            }
            bookedCoachSeats += totalNumberOfSeats;
            return true;
        }


    }
}
