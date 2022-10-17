package com.techelevator.salesreport.model;

import com.techelevator.BaseCandyApplicationTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class SalesReportLineItemTests extends BaseCandyApplicationTests {

    private final static double TEST_STARTING_TOTAL_SALES = 200.75;

    private SalesReportLineItems reportItems;

    @Before
    public void setup() {
        reportItems = new SalesReportLineItems();
        reportItems.addSalesReportEntry(TEST_SALES_REPORT_ENTRY_CHOCOLATE);
        reportItems.setTotalSales(TEST_STARTING_TOTAL_SALES);
    }

    @Test
    public void add_sales_report_entry() {
        reportItems.addSalesReportEntry(TEST_SALES_REPORT_ENTRY_HARD_CANDY);
        Assert.assertEquals(2, reportItems.getCurrentSalesReport().size());
    }

    @Test
    public void add_null_sales_report_entry() {
        reportItems.addSalesReportEntry(null);
        Assert.assertEquals(1, reportItems.getCurrentSalesReport().size());
    }

    @Test
    public void add_to_total_sales() {
        reportItems.addToTotalSales(50);
        Assert.assertEquals(TEST_STARTING_TOTAL_SALES + 50, reportItems.getTotalSales(), 0.009);
    }

    @Test
    public void add_negative_to_total_sales() {
        reportItems.addToTotalSales(-1);
        Assert.assertEquals(TEST_STARTING_TOTAL_SALES, reportItems.getTotalSales(), 0.009);
    }

    @Test
    public void product_exists_in_report() {
        Assert.assertTrue( reportItems.doesProductEntryExistInReport(TEST_ID_CHOCOLATE) );
    }

    @Test
    public void product_does_not_exist_in_report() {
        Assert.assertFalse( reportItems.doesProductEntryExistInReport("TEST") );
    }

    @Test
    public void product_exists_when_id_null() {
        Assert.assertFalse( reportItems.doesProductEntryExistInReport(null) );
    }

    @Test
    public void get_sales_report() {
        Map<String,SalesReportEntry> actualReport = reportItems.getCurrentSalesReport();
        Assert.assertEquals("Map wrong size", 1, actualReport.size());
    }

    @Test
    public void set_total_sales() {
        reportItems.setTotalSales(999.99);
        Assert.assertEquals(999.99, reportItems.getTotalSales(), 0.009);
    }

    @Test
    public void set_negative_total_sales() {
        reportItems.setTotalSales(-1);
        Assert.assertEquals(TEST_STARTING_TOTAL_SALES, reportItems.getTotalSales(), 0.009);
    }
}
