package com.techelevator;

import com.techelevator.vehicle.Bus;

public class App {

    //psvm
    public static void main(String[] args) {

        Bus ourBus = new Bus();

        ourBus.setRouteName("High Street");

        System.out.println( ourBus.getRouteName() );

        ourBus.openDoor();
        boolean success = ourBus.board();

        if (success) {
            System.out.println("Was able to board the bus");
        } else {
            System.out.println("Failed to board the bus");
        }

        success = ourBus.board(28);

        System.out.println("Remaining Seats: " + ourBus.getRemainingSeats() );

        Bus secondBus = new Bus("Front Street");
        System.out.println("Second Bus route name " + secondBus.getRouteName());
        Bus thirdBus = new Bus();
        thirdBus.addGas(12);

        System.out.println("Remaining Gas: " + thirdBus.getGallonsOfGas());

        int milesRemaining =  Bus.getDistanceRemaining(50, 27);

        Bus busOne = new Bus("BusOne");
        Bus busTwo = new Bus("BusOne");



        if (busOne.equals(busTwo)) {
            System.out.println("The same values!");
        }

        System.out.println( busOne.toString() );

        // print() automatically calls toString()
        // on any reference type
        System.out.println( ourBus );

    }

}
