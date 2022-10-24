package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Country;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;

import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection() {
        int menuSelection;
        System.out.print("Please choose an option: ");
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("----Hotels Main Menu----");
        System.out.println("1: List Hotels");
        System.out.println("2: List Reviews");
        System.out.println("3: Show Details for Hotel");
        System.out.println("4: List Reviews for Hotel");
        System.out.println("5: List Hotels with star rating");
        System.out.println("6: Public API Query");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printHotels(Hotel[] hotels) {
        System.out.println("--------------------------------------------");
        System.out.println("Hotels");
        System.out.println("--------------------------------------------");
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getId() + ": " + hotel.getName());
        }
    }

    public void printHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    public void printReviews(Review[] reviews) {
        for (Review review : reviews) {
            System.out.println(review.toString());
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void showInvalidSelection() {
        System.out.println("Invalid Selection");
    }

    public int getHotelId() {
        int hotelId = 0;
        while(hotelId == 0) {
            System.out.print("Hotel Id >>>");
            hotelId = getIntFromUser();
        }
        return hotelId;
    }

    public int getStarRating() {
        int starRating = 0;
        while(starRating == 0) {
            System.out.print("Star Rating >>>");
            starRating = getIntFromUser();
        }
        return starRating;
    }

    private int getIntFromUser() {
        String userInput = scanner.nextLine();
        int id = 0;
        try {
            id = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            showInvalidSelection();
            id = 0;
        }
        return id;
    }

    public void printCountry(Country country) {
        System.out.println(country);
    }


}
