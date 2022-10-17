package com.techelevator;

import com.techelevator.cart.CartItem;
import com.techelevator.cart.ShoppingCart;
import com.techelevator.exceptions.InsufficientBalanceException;
import com.techelevator.exceptions.InsufficientStockException;
import com.techelevator.exceptions.InvalidAmountException;
import com.techelevator.exceptions.ItemDoesNotExistException;
import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.money.ChangeTotal;
import com.techelevator.money.MoneyDrawer;
import com.techelevator.sale.CompletedSale;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    This class should encapsulate all the functionality of the Candy Store application, meaning it should
    contain all the "work"
 */
public class CandyStore {

    private static final String ERROR_INVALID_AMOUNT = "Amount must be between $0 and $100";
    private static final String ERROR_BALANCE_EXCEEDS_LIMIT = "Total balance may not exceed $1000";
    private static final int MAX_AMOUNT_PER_ADD = 100;
    private static final int MAX_ALLOWED_BALANCE = 1000;

    private Map<String, StockItem> inventory;
    private MoneyDrawer moneyDrawer = new MoneyDrawer();
    private ShoppingCart shoppingCart = new ShoppingCart();

    public CandyStore(InventoryReader inventoryReader) throws InventoryNotFoundException {
        this.inventory = inventoryReader.read();
    }

    public Map<String, StockItem> getInventory() {
        return inventory;
    }

    public double getCustomerCurrentBalance() {
        return moneyDrawer.getCurrentBalance();
    }

    public double addMoneyToCustomerBalance(int amountToAdd) throws InvalidAmountException {
        if (amountToAdd < 0 || amountToAdd > MAX_AMOUNT_PER_ADD) {
            throw new InvalidAmountException(ERROR_INVALID_AMOUNT, amountToAdd);
        }
        if (moneyDrawer.getCurrentBalance() + amountToAdd > MAX_ALLOWED_BALANCE) {
            throw new InvalidAmountException(ERROR_BALANCE_EXCEEDS_LIMIT, amountToAdd);
        }

        return moneyDrawer.addMoney(amountToAdd);
    }

    public List<CartItem> getShoppingCart() {
        return shoppingCart.getCart();
    }

    public CartItem purchaseItem(String id, int quantity) throws ItemDoesNotExistException, InsufficientStockException, InsufficientBalanceException {
        if (id == null || quantity < 1) {
            return null;
        }
        StockItem item = inventory.get(id);
        if (item == null) {
            throw new ItemDoesNotExistException(id + " is not a valid product");
        }
        if (item.getQuantity() < quantity) {
            throw new InsufficientStockException(item.getQuantity());
        }
        double total = item.getItem().getPrice() * quantity;
        if (total > moneyDrawer.getCurrentBalance()) {
            throw new InsufficientBalanceException(total);
        }
        CartItem cartItem = shoppingCart.addItemToCart(item.getItem(), quantity);
        item.removeQuantity(quantity);
        moneyDrawer.removeMoney(total);
        return cartItem;
    }

    public CompletedSale completeSale() {
        double purchaseTotal = shoppingCart.getCartTotalAmount();
        List<CartItem> items = new ArrayList<CartItem>(shoppingCart.getCart());
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        shoppingCart.clearCart();
        return new CompletedSale(items, purchaseTotal, changeTotal);
    }




}
