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
}
