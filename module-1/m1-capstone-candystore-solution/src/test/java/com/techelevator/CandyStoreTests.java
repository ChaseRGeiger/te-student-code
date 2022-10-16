package com.techelevator;

import com.techelevator.cart.CartItem;
import com.techelevator.exceptions.InsufficientBalanceException;
import com.techelevator.exceptions.InsufficientStockException;
import com.techelevator.exceptions.InvalidAmountException;
import com.techelevator.exceptions.ItemDoesNotExistException;
import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;
import com.techelevator.inventory.items.CandyStoreItem;
import com.techelevator.inventory.reader.InventoryReader;
import com.techelevator.inventory.reader.MockInventoryReader;
import com.techelevator.sale.CompletedSale;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CandyStoreTests extends BaseCandyApplicationTests {

    private static final String ERROR_INVALID_AMOUNT = "Amount must be between $0 and $100";
    private static final String ERROR_BALANCE_EXCEEDS_LIMIT = "Total balance may not exceed $1000";


    private CandyStore candyStore;

    @Before
    public void setup() {
        InventoryReader mockInventoryReader = new MockInventoryReader();
        try {
            candyStore = new CandyStore(mockInventoryReader);
        } catch (InventoryNotFoundException e) {
            Assert.fail("Failed to instantiate CandyStore");
        }
    }

    @Test
    public void get_inventory() {
        Map<String, StockItem> expectedResult = buildTestInventoryMap();
        Map<String, StockItem> actualResult = candyStore.getInventory();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_postive_amount_money_under_100() {
        try {
            candyStore.addMoneyToCustomerBalance(100);
            Assert.assertEquals("Incorrect Balance", 100, candyStore.getCustomerCurrentBalance(), 0.009);
        } catch (InvalidAmountException e) {
            Assert.fail("Invalid Amount Exception: " + e.getMessage());
        }
    }

    @Test
    public void add_negative_amount_money() {
        try {
            candyStore.addMoneyToCustomerBalance(-5);
            Assert.fail("Able to add negative money");
        } catch (InvalidAmountException e) {
            Assert.assertEquals("Incorrect Exception message", ERROR_INVALID_AMOUNT, e.getMessage());
            Assert.assertEquals("Incorrect exception amount", -5, e.getAmount());
            Assert.assertEquals("Balance updated on exception", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        }
    }

    @Test
    public void add_0_amount_money() {
        try {
            candyStore.addMoneyToCustomerBalance(0);
            Assert.assertEquals(0, candyStore.getCustomerCurrentBalance(), 0.009);
        } catch (InvalidAmountException e) {
            Assert.fail("Exception thrown when amount is 0");
        }
    }

    @Test
    public void add_amount_money_over_100() {
        try {
            candyStore.addMoneyToCustomerBalance(101);
            Assert.fail("Able to add more than 100 in single add");
        } catch (InvalidAmountException e) {
            Assert.assertEquals("Incorrect Exception message", ERROR_INVALID_AMOUNT, e.getMessage());
            Assert.assertEquals("Incorrect exception amount", 101, e.getAmount());
            Assert.assertEquals("Balance updated on exception", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        }
    }

    @Test
    public void add_balance_to_exactly_1000() {
        try {
            setBalanceTo1000();
            Assert.assertEquals("Incorrect Balance", 1000, candyStore.getCustomerCurrentBalance(), 0.009);
        } catch (InvalidAmountException e) {
            Assert.fail("Invalid Amount Exception: " + e.getMessage());
        }
    }

    @Test
    public void add_amount_when_balance_exceeds_1000() {
        try {
            setBalanceTo1000();
            candyStore.addMoneyToCustomerBalance(1);
            Assert.fail("Able to exceed max balance limit");
        } catch (InvalidAmountException e) {
            Assert.assertEquals("Incorrect Exception message", ERROR_BALANCE_EXCEEDS_LIMIT, e.getMessage());
            Assert.assertEquals("Incorrect exception amount", 1, e.getAmount());
            Assert.assertEquals("Balance updated on exception", 1000, candyStore.getCustomerCurrentBalance(), 0.009);
        }
    }

    @Test
    public void can_purchase_product() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        CartItem itemReturned = null;
        try {
            itemReturned = candyStore.purchaseItem(TEST_ID_CHOCOLATE, 1);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        assertPurchaseProcessSuccessful(TEST_ID_CHOCOLATE, TEST_ITEM_CHOCOLATE, 1, 100, itemReturned);
    }

    @Test
    public void can_purchase_multiple_of_product() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        CartItem itemReturned = null;
        try {
            itemReturned = candyStore.purchaseItem(TEST_ID_CHOCOLATE, 10);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        assertPurchaseProcessSuccessful(TEST_ID_CHOCOLATE, TEST_ITEM_CHOCOLATE, 10, 100, itemReturned);
    }

    @Test
    public void can_purchase_all_stock_of_a_product() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        CartItem itemReturned = null;
        try {
            itemReturned = candyStore.purchaseItem(TEST_ID_CHOCOLATE, 100);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        assertPurchaseProcessSuccessful(TEST_ID_CHOCOLATE, TEST_ITEM_CHOCOLATE, 100, 100, itemReturned);
    }

    @Test
    public void can_purchase_product_when_exact_balance() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(6);
        CartItem itemReturned = null;
        try {
            itemReturned = candyStore.purchaseItem(TEST_ID_HARD_CANDY, 2);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        assertPurchaseProcessSuccessful(TEST_ID_HARD_CANDY, TEST_ITEM_HARD_CANDY, 2, 6, itemReturned);
    }

    @Test
    public void can_purchase_0_product() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        try {
            candyStore.purchaseItem(TEST_ID_CHOCOLATE, 0);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 100, candyStore.getCustomerCurrentBalance(), 0.009);
    }

    @Test
    public void cannot_purchase_product_that_does_not_exist() throws InvalidAmountException {
        boolean correctExceptionThrown = false;
        candyStore.addMoneyToCustomerBalance(100);
        try {
            candyStore.purchaseItem("TEST", 1);
        } catch (ItemDoesNotExistException e) {
            correctExceptionThrown = true;
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        if (!correctExceptionThrown) {
            Assert.fail("ItemDoesNotExistException not thrown");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 100, candyStore.getCustomerCurrentBalance(), 0.009);
    }

    @Test
    public void cannot_purchase_product_when_insufficient_balance() throws InvalidAmountException {
        boolean correctExceptionThrown = false;
        candyStore.addMoneyToCustomerBalance(1);
        try {
            candyStore.purchaseItem(TEST_ID_CHOCOLATE, 50);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.assertEquals("Exception has incorrect total cost", (TEST_ITEM_CHOCOLATE.getPrice() * 50), e.getTotalCostOfItems(), 0.009);
            correctExceptionThrown = true;
        }
        if (!correctExceptionThrown) {
            Assert.fail("InsufficientBalanceException not thrown");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 1, candyStore.getCustomerCurrentBalance(), 0.009);
    }

    @Test
    public void cannot_purchase_product_when_insufficient_stock() throws InvalidAmountException {
        boolean correctExceptionThrown = false;
        candyStore.addMoneyToCustomerBalance(100);
        try {
            candyStore.purchaseItem(TEST_ID_CHOCOLATE, 101);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.assertEquals("Exception has wrong stock amount", 100, e.getStockRemaining());
            correctExceptionThrown = true;
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        if (!correctExceptionThrown) {
            Assert.fail("InsufficientStockException not thrown");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 100, candyStore.getCustomerCurrentBalance(), 0.009);

    }



    @Test
    public void cannot_purchase_null_product() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        try {
            candyStore.purchaseItem(null, 1);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 100, candyStore.getCustomerCurrentBalance(), 0.009);
    }

    @Test
    public void cannot_purchase_negative_number_of_items() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        try {
            candyStore.purchaseItem(TEST_ID_CHOCOLATE, -1);
        } catch (ItemDoesNotExistException e) {
            Assert.fail("Item should exist");
        } catch (InsufficientStockException e) {
            Assert.fail("Item should have sufficient stock");
        } catch (InsufficientBalanceException e) {
            Assert.fail("Balance should be sufficient");
        }
        Assert.assertEquals("Cart should be empty", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance should not be changed", 100, candyStore.getCustomerCurrentBalance(), 0.009);
    }

    @Test
    public void complete_sale() throws InvalidAmountException, InsufficientStockException, ItemDoesNotExistException, InsufficientBalanceException {
        List<CartItem> expectedList = new ArrayList<CartItem>();
        expectedList.add( new CartItem( TEST_ITEM_HARD_CANDY, 1));
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.purchaseItem(TEST_ID_HARD_CANDY, 1);

        CompletedSale sale = candyStore.completeSale();

        Assert.assertEquals("Items still in cart", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance not 0", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        Assert.assertEquals("List of items incorrect", expectedList, sale.getItems());
        Assert.assertEquals("Purchase price incorrect", TEST_ITEM_HARD_CANDY.getPrice(), sale.getTotalSaleAmount(), 0.009);
        Assert.assertEquals("Change incorrect", 100 - sale.getTotalSaleAmount(), sale.getChange().getTotalAmount(), 0.009);
    }


    @Test
    public void complete_sale_when_cart_empty() throws InvalidAmountException, InsufficientStockException, ItemDoesNotExistException, InsufficientBalanceException {

        candyStore.addMoneyToCustomerBalance(100);
        CompletedSale sale = candyStore.completeSale();
        Assert.assertEquals("Items still in cart", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance not 0", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        Assert.assertEquals("List contains items", 0, sale.getItems().size());
        Assert.assertEquals("Purchase price incorrect", 0, sale.getTotalSaleAmount(), 0.009);
        Assert.assertEquals("Change incorrect", 100, sale.getChange().getTotalAmount(), 0.009);
    }

    @Test
    public void complete_sale_when_balance_0() throws InvalidAmountException, InsufficientStockException, ItemDoesNotExistException, InsufficientBalanceException {
        List<CartItem> expectedList = new ArrayList<CartItem>();
        expectedList.add( new CartItem( TEST_ITEM_HARD_CANDY, 2));
        candyStore.addMoneyToCustomerBalance(6);
        candyStore.purchaseItem(TEST_ID_HARD_CANDY, 2);

        CompletedSale sale = candyStore.completeSale();

        Assert.assertEquals("Items still in cart", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance not 0", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        Assert.assertEquals("List of items incorrect", expectedList, sale.getItems());
        Assert.assertEquals("Purchase price incorrect", TEST_ITEM_HARD_CANDY.getPrice() * 2, sale.getTotalSaleAmount(), 0.009);
        Assert.assertEquals("Change incorrect", 6 - sale.getTotalSaleAmount(), sale.getChange().getTotalAmount(), 0.009);
    }

    @Test
    public void complete_sale_when_multiple_items() throws InvalidAmountException, InsufficientStockException, ItemDoesNotExistException, InsufficientBalanceException {
        List<CartItem> expectedList = new ArrayList<CartItem>();
        expectedList.add( new CartItem( TEST_ITEM_HARD_CANDY, 2));
        expectedList.add( new CartItem( TEST_ITEM_CHOCOLATE, 12));
        expectedList.add( new CartItem( TEST_ITEM_SOUR, 100));

        setBalanceTo1000();
        candyStore.purchaseItem(TEST_ID_HARD_CANDY, 2);
        candyStore.purchaseItem(TEST_ID_CHOCOLATE, 12);
        candyStore.purchaseItem(TEST_ID_SOUR, 100);

        double expectedPrice = TEST_ITEM_HARD_CANDY.getPrice() * 2;
        expectedPrice += TEST_ITEM_CHOCOLATE.getPrice() * 12;
        expectedPrice += TEST_ITEM_SOUR.getPrice() * 100;

        CompletedSale sale = candyStore.completeSale();

        Assert.assertEquals("Items still in cart", 0, candyStore.getShoppingCart().size());
        Assert.assertEquals("Balance not 0", 0, candyStore.getCustomerCurrentBalance(), 0.009);
        Assert.assertEquals("List of items incorrect", expectedList, sale.getItems());
        Assert.assertEquals("Purchase price incorrect", expectedPrice, sale.getTotalSaleAmount(), 0.009);
        Assert.assertEquals("Change incorrect", 1000 - sale.getTotalSaleAmount(), sale.getChange().getTotalAmount(), 0.009);
    }

    private void assertPurchaseProcessSuccessful(String productId, CandyStoreItem itemPurchased, int quantityPurchased, double startingBalance, CartItem itemReturned) {
        Assert.assertEquals("Wrong number of objects in list", 1, candyStore.getShoppingCart().size());
        CartItem cartItem = candyStore.getShoppingCart().get(0);
        Assert.assertEquals("Wrong item in cart", itemPurchased, cartItem.getItem());
        Assert.assertEquals("Wrong number of items in Cart", quantityPurchased, cartItem.getCount());
        Assert.assertEquals("Incorrect balance", (startingBalance - itemPurchased.getPrice() * quantityPurchased), candyStore.getCustomerCurrentBalance(), 0.009);
        Assert.assertNotNull("Null item returned", itemPurchased);
        Assert.assertEquals("Wrong product returned", itemPurchased, itemReturned.getItem());
        Assert.assertEquals("Incorrect stock remains", (100 - quantityPurchased), candyStore.getInventory().get(productId).getQuantity());
    }

    private void setBalanceTo1000() throws InvalidAmountException {
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
        candyStore.addMoneyToCustomerBalance(100);
    }
}
