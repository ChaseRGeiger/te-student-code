package com.techelevator.salesreport;

import com.techelevator.BaseCandyApplicationTests;
import com.techelevator.salesreport.exception.SalesReportWriteException;
import com.techelevator.salesreport.model.SalesReportEntry;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Note: these are integration tests since they use the Sales Report file and the Invalid
    Sales Report file which are resources outside the method.  Integration testing will be
    discussed during module 2.
 */
public class FileSalesReportTests extends BaseCandyApplicationTests {

    private static final String TEST_SALES_REPORT_FILE_NAME = "testSalesReport";
    private static final String SALES_REPORT_LINE_FORMAT = "%-1s|%-1s|%-1s|$%-1.2f";
    private static final String TEXT_TOTAL_SALES = "**TOTAL SALES**";
    public static final String INVALID_LINE_ITEM = "T2|TEST|5";

    private SalesReport salesReport;
    private File salesReportFile;

    @Before
    public void setup() throws SalesReportWriteException {
        salesReport = new FileSalesReport(TEST_SALES_REPORT_FILE_NAME);
        salesReportFile = new File(TEST_SALES_REPORT_FILE_NAME);
    }

    @After
    public void cleanupFile() {
        salesReportFile.delete();
    }

    @Test
    public void create_new_sales_report_with_1_entry() throws SalesReportWriteException, FileNotFoundException {
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_SOUR);
        Assert.assertTrue("Sales report does not exist", salesReportFile.exists());
        List<String> reportLines = getLinesFromSalesReportFile();
        Assert.assertEquals("Report wrong size", 3, reportLines.size());
        Assert.assertEquals("Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_SOUR),
                reportLines.get(0));
        Assert.assertEquals("Blank line does not exist", "", reportLines.get(1));
        Assert.assertEquals("Total Sales incorrect",
                createdExpectedTotalSales(TEST_SALES_REPORT_ENTRY_SOUR.getAmount()),
                        reportLines.get(2));
    }

    @Test
    public void add_multiple_lines_to_sales_report() throws SalesReportWriteException, FileNotFoundException {
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_SOUR);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_CHOCOLATE);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_HARD_CANDY);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_LICORICE);
        Assert.assertTrue("Sales report does not exist", salesReportFile.exists());
        List<String> reportLines = getLinesFromSalesReportFile();
        Assert.assertEquals("Report wrong size", 6, reportLines.size());
        Assert.assertEquals("Sour Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_SOUR),
                reportLines.get(0));
        Assert.assertEquals("Chocolate Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_CHOCOLATE),
                reportLines.get(1));
        Assert.assertEquals("Hard Candy Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_HARD_CANDY),
                reportLines.get(2));
        Assert.assertEquals("Licorice Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_LICORICE),
                reportLines.get(3));

        Assert.assertEquals("Blank line does not exist", "", reportLines.get(4));

        double expectedTotalSales = TEST_SALES_REPORT_ENTRY_SOUR.getAmount()
                + TEST_SALES_REPORT_ENTRY_LICORICE.getAmount()
                + TEST_SALES_REPORT_ENTRY_CHOCOLATE.getAmount()
                + TEST_SALES_REPORT_ENTRY_HARD_CANDY.getAmount();

        Assert.assertEquals("Total Sales incorrect",
                createdExpectedTotalSales(expectedTotalSales),
                reportLines.get(5));
    }

    @Test
    public void update_existing_sales_report_item() throws SalesReportWriteException, FileNotFoundException {
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_SOUR);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_CHOCOLATE);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_SOUR);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_SOUR);
        salesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_LICORICE);
        Assert.assertTrue("Sales report does not exist", salesReportFile.exists());
        List<String> reportLines = getLinesFromSalesReportFile();
        Assert.assertEquals("Report wrong size", 5, reportLines.size());

        String expectedSourLine = String.format(SALES_REPORT_LINE_FORMAT, TEST_SALES_REPORT_ENTRY_SOUR.getProductId(),
                TEST_SALES_REPORT_ENTRY_SOUR.getProductName(), (TEST_SALES_REPORT_ENTRY_SOUR.getCount() * 3),
                (TEST_SALES_REPORT_ENTRY_SOUR.getAmount() * 3));

        Assert.assertEquals("Sour Line item not updated as expected", expectedSourLine, reportLines.get(0));
        Assert.assertEquals("Chocolate Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_CHOCOLATE),
                reportLines.get(1));
        Assert.assertEquals("Licorice Line item not correct",
                createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_LICORICE),
                reportLines.get(2));

        Assert.assertEquals("Blank line does not exist", "", reportLines.get(3));

        double expectedTotalSales = (TEST_SALES_REPORT_ENTRY_SOUR.getAmount() * 3)
                + TEST_SALES_REPORT_ENTRY_CHOCOLATE.getAmount() + TEST_SALES_REPORT_ENTRY_LICORICE.getAmount();

        Assert.assertEquals("Total Sales incorrect",
                createdExpectedTotalSales(expectedTotalSales),
                reportLines.get(4));
    }

    @Test
    public void invalid_line_in_sales_report() throws FileNotFoundException, SalesReportWriteException {
        File invalidFile = createInvalidSalesReport();
        SalesReport invalidSalesReport = new FileSalesReport(invalidFile.getAbsolutePath());
        try {
            invalidSalesReport.updateSalesReport(TEST_SALES_REPORT_ENTRY_CHOCOLATE);
            Assert.fail("Invalid Line exception not thrown");
        } catch (SalesReportWriteException e) {
            Assert.assertEquals("Exception message incorrect",
                    "Invalid line in sales report: " + INVALID_LINE_ITEM, e.getMessage());
        }
        invalidFile.delete();
    }

    private String createExpectedLineFromSalesReportEntry(SalesReportEntry entry) {
        return String.format(SALES_REPORT_LINE_FORMAT, entry.getProductId(), entry.getProductName(),
                entry.getCount(), entry.getAmount());
    }

    private String createdExpectedTotalSales(double totalSales) {
        return String.format(TEXT_TOTAL_SALES + " $%1.2f", totalSales);
    }

    private List<String> getLinesFromSalesReportFile() throws FileNotFoundException {
        List<String> linesFromReport = new ArrayList<String>();
        try (Scanner reader = new Scanner(salesReportFile)) {
            while(reader.hasNextLine()) {
                linesFromReport.add( reader.nextLine() );
            }
        }
        return linesFromReport;
    }

    private File createInvalidSalesReport() throws FileNotFoundException {
        File file = new File("testInvalidReport.rpt");
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(createExpectedLineFromSalesReportEntry(TEST_SALES_REPORT_ENTRY_LICORICE));
            writer.println(INVALID_LINE_ITEM);
            writer.println();
            writer.printf(TEXT_TOTAL_SALES + " $-1.2f", TEST_SALES_REPORT_ENTRY_LICORICE.getAmount());
        }
        return file;
    }

}
