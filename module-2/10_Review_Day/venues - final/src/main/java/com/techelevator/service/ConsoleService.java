package com.techelevator.service;

import com.techelevator.dao.model.Venue;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private static final Scanner in = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("**************************");
        System.out.println("*       WECLOME TO       *");
        System.out.println("*    JAVA BLUE VENUES    *");
        System.out.println("**************************");
    }

    public void showListOfVenues(List<Venue> venues) {

        for (Venue venue : venues) {
            System.out.println(venue.getId() + ") " + venue.getName());
        }
    }

    public int getVenueIdFromUser() {
        System.out.print("Venue Id >>>");
        String userChoice = in.nextLine();
        return Integer.parseInt(userChoice);
    }

    public void displayVenue(Venue venue) {
        System.out.println("Id: " + venue.getId() );
        System.out.println("Name: " + venue.getName());
        System.out.printf("Location: %-1s, %-1s %n", venue.getCity(), venue.getState().getAbbreviation());
        System.out.println("Categories: " + String.join(",", venue.getCategories()));
        System.out.println();
        System.out.println(venue.getDescription());
    }
}
