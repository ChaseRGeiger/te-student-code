package com.techelevator;

import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.items.*;
import com.techelevator.salesreport.model.SalesReportEntry;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public abstract class BaseCandyApplicationTests {

    protected static final int EXPECTED_QUANTITY = 100;

    protected static final CandyStoreItem TEST_ITEM_CHOCOLATE = new Chocolate("testChocolate", .55, true);
    protected static final CandyStoreItem TEST_ITEM_SOUR = new Sour("testSour", 1.60, false);
    protected static final CandyStoreItem TEST_ITEM_LICORICE = new Licorice("testLicorice", 2.65, false);
    protected static final CandyStoreItem TEST_ITEM_HARD_CANDY = new HardCandy("testHardCandy", 3.00, true);

    protected static final String TEST_ID_CHOCOLATE = "C01";
    protected static final String TEST_ID_SOUR = "S01";
    protected static final String TEST_ID_LICORICE = "L01";
    protected static final String TEST_ID_HARD_CANDY = "H01";

    protected static final String TYPE_CHOCOLATE = "CH";
    protected static final String TYPE_SOUR = "SR";
    protected static final String TYPE_LICORICE = "LI";
    protected static final String TYPE_HARD_CANDY = "HC";

    protected final static SalesReportEntry TEST_SALES_REPORT_ENTRY_CHOCOLATE = new SalesReportEntry(TEST_ID_CHOCOLATE,
            TEST_ITEM_CHOCOLATE.getName(),10, TEST_ITEM_CHOCOLATE.getPrice() * 10);
    protected final static SalesReportEntry TEST_SALES_REPORT_ENTRY_HARD_CANDY = new SalesReportEntry(TEST_ID_HARD_CANDY,
            TEST_ITEM_HARD_CANDY.getName(),16, TEST_ITEM_HARD_CANDY.getPrice() * 16);
    protected final static SalesReportEntry TEST_SALES_REPORT_ENTRY_SOUR = new SalesReportEntry(TEST_ID_SOUR,
            TEST_ITEM_SOUR.getName(),100, TEST_ITEM_SOUR.getPrice() * 100);
    protected final static SalesReportEntry TEST_SALES_REPORT_ENTRY_LICORICE = new SalesReportEntry(TEST_ID_LICORICE,
            TEST_ITEM_LICORICE.getName(),1, TEST_ITEM_LICORICE.getPrice());

    protected Map<String, StockItem> buildTestInventoryMap() {
        Map<String, StockItem> expected = new TreeMap<String, StockItem>();
        expected.put(TEST_ID_CHOCOLATE, new StockItem(TEST_ITEM_CHOCOLATE, EXPECTED_QUANTITY));
        expected.put(TEST_ID_SOUR, new StockItem(TEST_ITEM_SOUR, EXPECTED_QUANTITY));
        expected.put(TEST_ID_LICORICE, new StockItem(TEST_ITEM_LICORICE, EXPECTED_QUANTITY));
        expected.put(TEST_ID_HARD_CANDY, new StockItem(TEST_ITEM_HARD_CANDY, EXPECTED_QUANTITY));
        return expected;
    }
}
