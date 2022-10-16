package com.techelevator.view;

import com.techelevator.sale.CompletedSale;
import com.techelevator.cart.CartItem;
import com.techelevator.exceptions.InvalidAmountException;
import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;

import java.util.Map;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the candy store.
 */
public class Menu {

	private static final String BASE_FORMAT = "%-2s    %-20s     %-7s     %-9s  ";
	private static final String HEADER_FORMAT = BASE_FORMAT + "%-6s%n";
	private static final String LINE_ITEM_FORMAT = BASE_FORMAT + "$%-4.2f%n";

	private static final Scanner in = new Scanner(System.in);

	public String askUserForInventoryFilePath() {
		System.out.print("Path to inventory file >>>");
		return in.nextLine();
	}

	public void tellUserInventoryNotFound(InventoryNotFoundException e) {
		System.out.println(e.getMessage());
	}

	public void showWelcomeMessage() {
		System.out.println("***************************");
		System.out.println("**     Silver Shamrock   **");
		System.out.println("**      Candy Company    **");
		System.out.println("***************************");
		System.out.println();
	}

	public int getUserSelectionFromMainMenu() {
		int choice = 0;
		while (choice == 0) {
			System.out.println("(1) Show Inventory");
			System.out.println("(2) Make Sale");
			System.out.println("(3) Quit");
			choice = validateMenuSelection(in.nextLine(), 3);
		}
		return choice;
	}

	public void showInventory(Map<String, StockItem> inventory) {

		System.out.printf(HEADER_FORMAT,"Id", "Name", "Wrapper", "Qty", "Price");

		for (Map.Entry<String, StockItem> itemEntry : inventory.entrySet()) {
			System.out.printf(LINE_ITEM_FORMAT,
					itemEntry.getKey(),
					itemEntry.getValue().getItem().getName(),
					itemEntry.getValue().getItem().isWrapped() ? "Y" : "N",
					itemEntry.getValue().getQuantity() > 0 ? String.valueOf(itemEntry.getValue().getQuantity()) : "SOLD OUT" ,
					itemEntry.getValue().getItem().getPrice());
		}

		System.out.println();
	}

	public int getUserSelectionFromMakeSaleMenu(double currentBalance) {
		int choice = 0;
		while (choice == 0) {
			System.out.println("(1) Take Money");
			System.out.println("(2) Select Products");
			System.out.println("(3) Complete Sale");
			System.out.printf("Current Customer Balance: $%-4.2f%n", currentBalance);

			String userSelection = in.nextLine();
			choice = validateMenuSelection(userSelection, 3);
		}
		return choice;
	}

	public int getAmountOfMoneyToAddFromUser() {
		int amountToAdd = 0;
		while (true) {
			System.out.print("Amount (in whole dollars up to $100) >>>");
			String customerAmount = in.nextLine();
			try {
				amountToAdd = Integer.parseInt(customerAmount);
				break;
			} catch (NumberFormatException e) {
				System.out.println();
				System.out.println("Please enter a valid amount");
				System.out.println();
			}
		}
		return amountToAdd;
	}

	public String getProductIdFromUser(Map<String, StockItem> inventory) {
		showInventory(inventory);
		System.out.println();
		System.out.print("Product Id to purchase >>>");
		return in.nextLine().toUpperCase();
	}

	public int getQuantityFromUser() {
		int quantity = 0;
		System.out.print("Quantity of product to purchase >>>");
		String userQuantity = in.nextLine();
		try {
			quantity = Integer.parseInt(userQuantity);
		} catch (NumberFormatException e) {
			System.out.println("Invalid quantity");
		}
		if (quantity < 0) {
			System.out.println("Invalid quantity");
		}
		return quantity;
	}

	public void tellUserProductAddedToCart(String itemName, int quantity) {
		System.out.println();
		System.out.print(quantity);
		System.out.print(" ");
		System.out.print(itemName);
		System.out.println(" added to cart.");
		System.out.println();
	}

	public void tellUserNoProductSelected() {
		System.out.println();
		System.out.println("No product selected");
		System.out.println();
	}

	public void tellUserProductDoesNotExist(String productId) {
		System.out.println();
		System.out.println(productId + " does not exist");
		System.out.println();
	}

	public void tellUserThereIsInsufficientStock(int remainingStock) {
		System.out.println();
		System.out.print("Product does not have enough stock for order.");
		System.out.println(" Only " + remainingStock + " left.");
		System.out.println();
	}

	public void tellUserThereTheyHaveAnInsufficientBalance(double totalCostOfItems) {
		System.out.println();
		System.out.printf("Total cost of items selected $%-1.2f", totalCostOfItems);
		System.out.println(". Insufficient balance for order.");
		System.out.println();
	}

	public void showInvalidAmountToUser(InvalidAmountException e) {
		System.out.println();
		System.out.print("Unable to add money to account ");
		System.out.println(e.getMessage());
		System.out.println();
	}

	public void showReceiptOfSale(CompletedSale sale) {
		 String itemLineFormat = "%-3s  %-20s %-25s $%-3.2f  $%-3.2f %n";

		System.out.println();

		 for (CartItem cartItem : sale.getItems()) {
			 System.out.printf(itemLineFormat,
					 cartItem.getCount(),
					 cartItem.getItem().getName(),
					 cartItem.getItem().getDescription(),
					 cartItem.getItem().getPrice(),
					 cartItem.getTotalCost()
					 );
		 }

		System.out.println();
		System.out.printf("Total: $%-1.2f %n", sale.getTotalSaleAmount());
		System.out.println();
		System.out.printf("Change: $%-1.2f %n", sale.getChange().getTotalAmount());

		String changeAsString = String.join(", ", sale.getChange().getChange().toString());
		System.out.println( changeAsString.substring(1, changeAsString.length() - 1) );

		System.out.println();
	}

	public void showLogWriterException(String message) {
		showShutDownError("Unable to write to log: " + message);
	}

	public void showSalesReportWriterException(String message) {
		showShutDownError("Unable to write to sales report: " + message);
	}

	public void tellUserSalesReportNotCreated(String message) {
		System.out.println();
		System.out.println("Failed to Start");
		System.out.println("Sales Report could not be accessed: " + message);
		System.out.println();
	}

	private int validateMenuSelection(String userChoice, int numberOfOptions) {
		try {
			int choice = Integer.parseInt(userChoice);
			if (choice > 0 && choice <= numberOfOptions) {
				return choice;
			}
			System.out.println("Please select a valid option");
		} catch (NumberFormatException e) {
			System.out.println("Please enter a number");
		}
		return 0;
	}

	private void showShutDownError(String message) {
		System.out.println();
		System.out.println("UNEXPECTED ERROR: Application shutting down");
		System.out.println(message);
		System.out.println();
	}


}
