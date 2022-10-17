package com.techelevator.inventory;

import com.techelevator.BaseCandyApplicationTests;
import org.junit.*;

public class StockItemTests extends BaseCandyApplicationTests {

    public static final int TEST_QUANTITY = 75;
    private StockItem testStockItem;

    @Before
    public void createTestStockItem() {
        testStockItem = new StockItem(TEST_ITEM_CHOCOLATE, TEST_QUANTITY);
    }

    @Test
    public void stock_item_correct_item() {
        Assert.assertEquals(TEST_ITEM_CHOCOLATE, testStockItem.getItem());
    }

    @Test
    public void stock_item_correct_starting_quantity() {
        Assert.assertEquals(TEST_QUANTITY, testStockItem.getQuantity());
    }
}
