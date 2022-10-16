package com.techelevator.salesreport.model;

import org.junit.*;

public class SalesReportEntryTests {

    private static final String TEST_PRODUCT_ID = "T1";
    private static final String TEST_PRODUCT_NAME = "Test";
    private static final int TEST_COUNT = 10;
    private static final double TEST_AMOUNT = 123.45;

    private SalesReportEntry entry;

    @Before
    public void setup() {
        entry = new SalesReportEntry(TEST_PRODUCT_ID,
                TEST_PRODUCT_NAME, TEST_COUNT, TEST_AMOUNT);
    }

    @Test
    public void correct_product_id() {
        Assert.assertEquals(TEST_PRODUCT_ID, entry.getProductId());
    }

    @Test
    public void correct_product_name() {
        Assert.assertEquals(TEST_PRODUCT_NAME, entry.getProductName());
    }

    @Test
    public void correct_count() {
        Assert.assertEquals(TEST_COUNT, entry.getCount());
    }

    @Test
    public void correct_amount() {
        Assert.assertEquals(TEST_AMOUNT, entry.getAmount(), 0.009);
    }

    @Test
    public void add_to_count() {
        entry.addToCount(5);
        Assert.assertEquals(TEST_COUNT + 5, entry.getCount());
    }

    @Test
    public void add_negative_to_count() {
        entry.addToCount(-1);
        Assert.assertEquals(TEST_COUNT, entry.getCount());
    }

    @Test
    public void add_to_amount() {
        entry.addToAmount(12.25);
        Assert.assertEquals(TEST_AMOUNT + 12.25, entry.getAmount(), 0.009);
    }

    @Test
    public void add_negative_to_amount() {
        entry.addToAmount(-1);
        Assert.assertEquals(TEST_AMOUNT, entry.getAmount(), 0.009);
    }

}
