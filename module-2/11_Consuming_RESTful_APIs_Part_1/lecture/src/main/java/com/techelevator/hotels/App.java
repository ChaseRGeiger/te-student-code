package com.techelevator.hotels;

import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    public static final int MAIN_MENU_LIST_HOTELS = 1;
    public static final int MAIN_MENU_LIST_REVIEWS = 2;
    public static final int MAIN_MENU_SHOW_HOTEL_DETAILS = 3;
    public static final int MAIN_MENU_LIST_REVIEWS_FOR_HOTEL = 4;
    public static final int MAIN_MENU_FIND_HOTELS_BY_STAR_RATING = 5;
    public static final int MAIN_MENU_QUERY_A_PUBLIC_API = 6;
    public static final int MAIN_MENU_EXIT = 0;

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == MAIN_MENU_LIST_HOTELS) {
                listAllHotels();
            } else if (menuSelection == MAIN_MENU_LIST_REVIEWS) {
                listAllReviews();
            } else if (menuSelection == MAIN_MENU_SHOW_HOTEL_DETAILS) {
                showDetailsForHotel();
            } else if (menuSelection == MAIN_MENU_LIST_REVIEWS_FOR_HOTEL) {
                showReviewsForHotel();
            } else if (menuSelection == MAIN_MENU_FIND_HOTELS_BY_STAR_RATING) {
                searchHotelsByStarReview();
            } else if (menuSelection == MAIN_MENU_QUERY_A_PUBLIC_API) {
                queryAPublicApi();
            } else if (menuSelection == MAIN_MENU_EXIT) {
                continue;
            } else {
                consoleService.showInvalidSelection();
            }
            consoleService.pause();
        }
    }

    private void listAllHotels() {
        System.out.println("Not implemented");
    }

    private void listAllReviews() {
        System.out.println("Not implemented");
    }

    private void showDetailsForHotel() {
        int hotelId = consoleService.getHotelId();
        System.out.println("Not implemented");
    }

    private void showReviewsForHotel() {
        int hotelId = consoleService.getHotelId();
        System.out.println("Not implemented");
    }

    private void searchHotelsByStarReview() {
        int starRating = consoleService.getStarRating();
        System.out.println("Not implemented");
    }

    private void queryAPublicApi() {
        System.out.println("Not implemented - Create a custom Web API query here");
    }

}
