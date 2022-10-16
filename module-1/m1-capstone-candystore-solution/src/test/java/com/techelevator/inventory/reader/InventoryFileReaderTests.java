package com.techelevator.inventory.reader;

import com.techelevator.BaseCandyApplicationTests;
import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;
import com.techelevator.inventory.items.*;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/*
    Most of these are not Unit Tests since they require a test file.  They are integration tests with the file.
    Using the Test Inventory File would be appropriate, but this demonstrates how an independent file integration
    test can be done that does not rely on an existing file.  It uses 2 JUnit annotations @BeforeClass and @AfterClass
    that we will learn in module 2
 */
public class InventoryFileReaderTests extends BaseCandyApplicationTests {

    protected static final String TEST_INVENTORY_FILE_NAME = "testInventory.csv";
    protected static final String TEST_INVALID_FILE_NAME = "notfound.csv";
    private static final File testInventoryFile = new File(TEST_INVENTORY_FILE_NAME);

    private InventoryReader fileReader;


    @BeforeClass
    public static void createTestFile() {
        try (PrintWriter writer = new PrintWriter(testInventoryFile)) {
            String fileLine = buildInventoryFileLine(TYPE_CHOCOLATE, TEST_ID_CHOCOLATE, TEST_ITEM_CHOCOLATE);
            writer.println(fileLine);
            fileLine = buildInventoryFileLine(TYPE_LICORICE, TEST_ID_LICORICE, TEST_ITEM_LICORICE);
            writer.println(fileLine);
            fileLine = buildInventoryFileLine(TYPE_SOUR, TEST_ID_SOUR, TEST_ITEM_SOUR);
            writer.println(fileLine);
            fileLine = buildInventoryFileLine(TYPE_HARD_CANDY, TEST_ID_HARD_CANDY, TEST_ITEM_HARD_CANDY);
            writer.println(fileLine);
        } catch (FileNotFoundException e) {
            Assert.fail("Failed to create test file");
        }
    }

    @AfterClass
    public static void destroyTestFile() {
        testInventoryFile.delete();
    }

    @Before
    public void createFileReader() {
        fileReader = new InventoryFileReader(TEST_INVENTORY_FILE_NAME);
    }

    @Test
    public void read_items_from_file() {
        Map<String, StockItem> expectedResults = buildTestInventoryMap();
        Map<String, StockItem> itemsFromFile = null;
        try {
            itemsFromFile = fileReader.read();
        } catch (InventoryNotFoundException e) {
            Assert.fail("Inventory not found!");
        }
        Assert.assertNotNull("Actual results are null", itemsFromFile);
        Assert.assertEquals("Actual results do not match expected", expectedResults, itemsFromFile);
    }

    @Test
    public void inventory_not_found_exception_thrown_when_file_not_found() {
        boolean wasExceptionThrown = false;
        InventoryReader errorReader = new InventoryFileReader(TEST_INVALID_FILE_NAME);
        try {
            errorReader.read();
        } catch (InventoryNotFoundException e) {
            wasExceptionThrown = true;
        } catch (Exception e) {
            Assert.fail("Wrong Exception Thrown: " + e.getClass() + ":" + e.getMessage());
        }
        if (!wasExceptionThrown){
            Assert.fail("InventoryNotFoundException was not thrown");
        }
    }

    private static String buildInventoryFileLine(String id, String testId, CandyStoreItem testItem) {
        return String.join("|", id, testId, testItem.getName(), String.valueOf(testItem.getPrice()),
                testItem.isWrapped() ? "T" : "F");
    }



}
