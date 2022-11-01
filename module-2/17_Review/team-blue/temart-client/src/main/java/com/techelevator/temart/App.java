package com.techelevator.temart;

import com.techelevator.temart.model.AuthenticatedUser;
import com.techelevator.temart.model.Product;
import com.techelevator.temart.model.UserCredentials;
import com.techelevator.temart.services.AuthenticationService;
import com.techelevator.temart.services.ConsoleService;
import com.techelevator.temart.services.StoreService;

import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";
    public static final int MAIN_MENU_LIST_PRODUCTS = 1;
    public static final int MAIN_MENU_CREATE_WISHLIST = 2;
    public static final int MAIN_MENU_VIEW_WISHLISTS = 3;
    public static final int MAIN_MENU_ADD_PRODUCT_TO_WISHLIST = 4;
    public static final int MAIN_MENU_EXIT = 0;

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private StoreService storeService = new StoreService(API_BASE_URL);
    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == MAIN_MENU_LIST_PRODUCTS) {
                listAllProducts();
            } else if (menuSelection == MAIN_MENU_CREATE_WISHLIST) {
                createWishlist();
            } else if (menuSelection == MAIN_MENU_VIEW_WISHLISTS) {
                viewWishlists();
            } else if (menuSelection == MAIN_MENU_ADD_PRODUCT_TO_WISHLIST) {
                addProductToWishlist();
            } else if (menuSelection == MAIN_MENU_EXIT) {
                continue;
            } else {
                consoleService.printInvalidSelection();
            }
            consoleService.pause();
        }
    }

	private void listAllProducts() {
        /*
            1) Calls the Service to get all the Products
         */
        List<Product> products = storeService.getAllProducts();
        /*
            7) When the List<Product> is returned from the StoreService (API)
               it is passed to the ConsoleService to be displayed to the user
         */
        consoleService.displayAllProducts(products);
	}

	private void createWishlist() {
		// TODO Auto-generated method stub
		
	}

	private void viewWishlists() {
		// TODO Auto-generated method stub
		
	}

	private void addProductToWishlist() {
		// TODO Auto-generated method stub
		
	}


}
