package com.techelevator;

import com.techelevator.cart.CartItem;
import com.techelevator.exceptions.InsufficientBalanceException;
import com.techelevator.exceptions.InsufficientStockException;
import com.techelevator.exceptions.InvalidAmountException;
import com.techelevator.exceptions.ItemDoesNotExistException;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;
import com.techelevator.inventory.reader.InventoryFileReader;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.log.LogFileWriter;
import com.techelevator.log.LogWriter;
import com.techelevator.log.exception.LogWriteException;
import com.techelevator.sale.CompletedSale;
import com.techelevator.salesreport.FileSalesReport;
import com.techelevator.salesreport.SalesReport;
import com.techelevator.salesreport.exception.SalesReportWriteException;
import com.techelevator.salesreport.model.SalesReportEntry;
import com.techelevator.view.Menu;

/*
 * This class should control the workflow of the application, but not do any other work
 * 
 * The menu class should communicate with the user, but do no other work
 * 
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CandyStore class to do any work and pass the results between those 2 classes.
 */
public class ApplicationCLI {

	private static final int MAIN_MENU_SHOW_INVENTORY = 1;
	private static final int MAIN_MENU_MAKE_SALE = 2;
	private static final int MAIN_MENU_QUIT = 3;
	public static final int MAKE_SALE_MENU_TAKE_MONEY = 1;
	public static final int MAKE_SALE_MENU_SELECT_PRODUCTS = 2;
	public static final int MAKE_SALE_MENU_COMPLETE_SALE = 3;
	public static final String LOG_FILE_NAME = "Log.txt";
	public static final String SALES_REPORT_FILE_NAME = "SalesReport.rpt";

	/*
	 * The menu class is instantiated in the main() method at the bottom of this file.  
	 * It is the only class instantiated in the starter code.  
	 * You will need to instantiate all other classes using the new keyword before you can use them.
	 * 
	 * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
	 */
	private Menu menu;
	private CandyStore candyStore;
	private LogWriter logWriter = new LogFileWriter(LOG_FILE_NAME);
	private SalesReport salesReportWriter;
	public ApplicationCLI(Menu menu) {
		this.menu = menu;
	}

	/*
	 * Your application starts here
	 */
	public void run() {

		if (!initializeApplication()) {
			return;
		}

		menu.showWelcomeMessage();
		while (true) {
			int menuSelection = menu.getUserSelectionFromMainMenu();
			if (menuSelection == MAIN_MENU_SHOW_INVENTORY) {
				showInventory();
			} else if (menuSelection == MAIN_MENU_MAKE_SALE) {
				try {
					showMakeSaleMenu();
				} catch (LogWriteException e) {
					menu.showLogWriterException(e.getCause().getMessage());
					break;
				} catch (SalesReportWriteException e) {
					menu.showSalesReportWriterException(e.getMessage());
					break;
				}
			} else if (menuSelection == MAIN_MENU_QUIT) {
				break;
			}
		}
	}

	private void showMakeSaleMenu() throws LogWriteException, SalesReportWriteException {
		while (true) {
			int choice = menu.getUserSelectionFromMakeSaleMenu(candyStore.getCustomerCurrentBalance());
			if (choice == MAKE_SALE_MENU_TAKE_MONEY) {
				takeMoneyFromCustomer();
			} else if (choice == MAKE_SALE_MENU_SELECT_PRODUCTS) {
				purchaseProducts();
			} else if (choice == MAKE_SALE_MENU_COMPLETE_SALE) {
				completeSale();
				break;
			}
		}
	}

	public void takeMoneyFromCustomer() throws LogWriteException {
		int amountToAdd = menu.getAmountOfMoneyToAddFromUser();
		try {
			candyStore.addMoneyToCustomerBalance(amountToAdd);
			logWriter.logMoneyReceived(amountToAdd, candyStore.getCustomerCurrentBalance());
		} catch (InvalidAmountException e) {
			menu.showInvalidAmountToUser(e);
		}
	}

	public void purchaseProducts() throws LogWriteException, SalesReportWriteException {
		String productId = menu.getProductIdFromUser(candyStore.getInventory());
		int quantity = menu.getQuantityFromUser();

		if (productId.trim().length() == 0 || quantity < 1) {
			menu.tellUserNoProductSelected();
			return;
		}

		try {
			CartItem item = candyStore.purchaseItem(productId, quantity);
			menu.tellUserProductAddedToCart(item.getItem().getName(), quantity);
			logWriter.logItemSold(productId, item, candyStore.getCustomerCurrentBalance());
			salesReportWriter.updateSalesReport(new SalesReportEntry(productId,item.getItem().getName(), item.getCount(), item.getTotalCost()));
		} catch (ItemDoesNotExistException e) {
			menu.tellUserProductDoesNotExist(productId);
		} catch (InsufficientStockException e) {
			menu.tellUserThereIsInsufficientStock(e.getStockRemaining());
		} catch (InsufficientBalanceException e) {
			menu.tellUserThereTheyHaveAnInsufficientBalance(e.getTotalCostOfItems());
		}
	}

	public void completeSale() throws LogWriteException {
		CompletedSale completedSale = candyStore.completeSale();
		logWriter.logChangeGiven(completedSale.getChange().getTotalAmount(), candyStore.getCustomerCurrentBalance());
		menu.showReceiptOfSale(completedSale);
	}

	private void showInventory() {
		menu.showInventory(candyStore.getInventory());
	}

	private boolean initializeApplication() {
		try {
			salesReportWriter = new FileSalesReport(SALES_REPORT_FILE_NAME);
		} catch (SalesReportWriteException e) {
			menu.tellUserSalesReportNotCreated(e.getMessage());
			return false;
		}

		while (true) {
			String inventoryFilePath = menu.askUserForInventoryFilePath();
			InventoryReader inventoryReader = new InventoryFileReader(inventoryFilePath);
			try {
				candyStore = new CandyStore(inventoryReader);
				break;
			} catch (InventoryNotFoundException e) {
				menu.tellUserInventoryNotFound(e);
			}
		}
		return true;
	}


	/*
	 * This starts the application, but you shouldn't need to change it.  
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		ApplicationCLI cli = new ApplicationCLI(menu);
		cli.run();
	}
}
