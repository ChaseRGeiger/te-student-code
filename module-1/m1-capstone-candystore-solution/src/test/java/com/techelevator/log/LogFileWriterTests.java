package com.techelevator.log;

import com.techelevator.cart.CartItem;
import com.techelevator.BaseCandyApplicationTests;
import com.techelevator.log.exception.LogWriteException;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Note that these are integration tests since they rely on an external source, the file, and not unit tests,
    which will be covered in module 2.
 */
public class LogFileWriterTests extends BaseCandyApplicationTests {

    private final static DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");

    private final static int TEST_PURCHASED_ITEM_COUNT = 12;
    private final static String ACTION_MONEY_RECEIVED = "MONEY RECEIVED:";
    private final static String ACTION_CHANGE_GIVEN = "CHANGE GIVEN:";
    private final static String ACTION_ITEM_PURCHASED = TEST_PURCHASED_ITEM_COUNT + " " +
            TEST_ITEM_CHOCOLATE.getName() + " " + TEST_ID_CHOCOLATE;
    private final static CartItem TEST_CART_ITEM = new CartItem( TEST_ITEM_CHOCOLATE, TEST_PURCHASED_ITEM_COUNT);

    private static final String TEST_LOG_FILE_NAME = "testLog";
    private LogWriter logWriter;
    private File file;

    @Before
    public void createNewLogWriter() {
        logWriter = new LogFileWriter(TEST_LOG_FILE_NAME);
        file = new File(TEST_LOG_FILE_NAME);
    }

    @After
    public void cleanup() {
        file.delete();
    }

    @Test
    public void write_single_line_to_log() throws LogWriteException {
            logWriter.logChangeGiven(0.00, 0.00);

            List<String> linesActuallyLogged = getLinesFromFile();
            Assert.assertEquals("Wrong number of lines logged", 1, linesActuallyLogged.size());
            Assert.assertTrue("Wrong action logged", linesActuallyLogged.get(0).contains(ACTION_CHANGE_GIVEN) );
    }

    @Test
    public void multiple_lines_log_appends_to_file() throws LogWriteException {
        logWriter.logChangeGiven(0, 0);
        logWriter.logMoneyReceived(0,0);

        List<String> lines = getLinesFromFile();

        Assert.assertEquals("Incorrect number of lines in file", 2, lines.size());
        Assert.assertTrue("Wrong action logged on line 1", lines.get(0).contains(ACTION_CHANGE_GIVEN) );
        Assert.assertTrue( "Wrong action logged on line 2", lines.get(1).contains(ACTION_MONEY_RECEIVED) );
    }

    @Test
    public void log_take_money() throws LogWriteException {
        double amountAdded = 12.34;
        double newBalance = 56.78;
        logWriter.logMoneyReceived(amountAdded, newBalance);
        List<String> lines = getLinesFromFile();
        assertLogFile(lines.get(0), ACTION_MONEY_RECEIVED, amountAdded, newBalance);
    }


    @Test
    public void log_purchase_product() throws LogWriteException {
        double newBalance = 98.60;
        logWriter.logItemSold(TEST_ID_CHOCOLATE, TEST_CART_ITEM, newBalance);
        List<String> lines = getLinesFromFile();
        assertLogFile(lines.get(0), ACTION_ITEM_PURCHASED, TEST_CART_ITEM.getTotalCost(), newBalance);
    }

    @Test
    public void log_make_change() throws LogWriteException {
        double amountAdded = 982.00;
        double newBalance = 0;
        logWriter.logChangeGiven(amountAdded, newBalance);
        List<String> lines = getLinesFromFile();
        assertLogFile(lines.get(0), ACTION_CHANGE_GIVEN, amountAdded, newBalance);
    }


    private List<String> getLinesFromFile() {
        List<String> lines = new ArrayList<String>();

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            Assert.fail("File not found: " + e.getMessage());
        }

        return lines;
    }

    private void assertLogFile(String actualLogLine, String expectedAction, double expectedAmount, double expectedBalance) {

        // If the string can be split into 2 parts using the expectedAction as a delimiter, then we know
        // that the correct action has been logged.
        String[] splitActualLine = actualLogLine.split(expectedAction);
        Assert.assertEquals("\nExpected action: " + expectedAction +" \nActual log line: " + actualLogLine,
                2, splitActualLine.length);

        String actualDateTimeStamp = splitActualLine[0].trim();
        String actualAmounts = splitActualLine[1].trim();

        String expectedAmounts = String.format("$%1.2f $%1.2f", expectedAmount, expectedBalance);
        Assert.assertEquals("Amounts incorrect",expectedAmounts, actualAmounts);

        // If the timestamp can be parsed into a LocalDateTime as not null using the expected format,
        // then we know it is a valid timestamp in the correct format.
        try {
            LocalDateTime parsedDateTime = LocalDateTime.parse(actualDateTimeStamp, timestampFormatter);
            Assert.assertNotNull(parsedDateTime);
        } catch (DateTimeParseException e) {
            Assert.fail("Failed to parse date: " + actualDateTimeStamp);
        }
    }

}
