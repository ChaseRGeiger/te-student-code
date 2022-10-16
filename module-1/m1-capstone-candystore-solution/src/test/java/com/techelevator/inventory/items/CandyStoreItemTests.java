package com.techelevator.inventory.items;

import org.junit.*;



public class CandyStoreItemTests {

    private static final String SOUR_DESCRIPTION = "Sour Flavored Candies";
    private static final String LICORICE_DESCRIPTION = "Licorce and Jellies";
    private static final String CHOCOLATE_DESCRIPTION = "Chocolate Confectionery";
    private static final String HARD_CANDY_DESCRIPTION = "Hard Tack Confectionery";

    private static final String TEST_NAME = "candy name";
    private static final double TEST_PRICE = 1.25;
    private static final boolean TEST_IS_WRAPPED = true;

    @Test
    public void chocolate_candy() {
        CandyStoreItem item = new Chocolate(TEST_NAME, TEST_PRICE, TEST_IS_WRAPPED);
        assertCandyValues(item);
        Assert.assertEquals("Incorrect Description", item.getDescription(),CHOCOLATE_DESCRIPTION);
    }

    @Test
    public void sour_candy() {
        CandyStoreItem item = new Sour(TEST_NAME, TEST_PRICE, TEST_IS_WRAPPED);
        assertCandyValues(item);
        Assert.assertEquals("Incorrect Description", item.getDescription(),SOUR_DESCRIPTION);
    }

    @Test
    public void licorice_candy() {
        CandyStoreItem item = new Licorice(TEST_NAME, TEST_PRICE, TEST_IS_WRAPPED);
        assertCandyValues(item);
        Assert.assertEquals("Incorrect Description", item.getDescription(),LICORICE_DESCRIPTION);
    }

    @Test
    public void hard_candy_candy() {
        CandyStoreItem item = new HardCandy(TEST_NAME, TEST_PRICE, TEST_IS_WRAPPED);
        assertCandyValues(item);
        Assert.assertEquals("Incorrect Description", item.getDescription(),HARD_CANDY_DESCRIPTION);
    }

    private void assertCandyValues(CandyStoreItem item) {
        Assert.assertEquals("Incorrect Name", item.getName(), TEST_NAME);
        Assert.assertEquals("Incorrect price", item.getPrice(), TEST_PRICE, 0.009);
        Assert.assertEquals("Incorrect isWrapped", item.isWrapped(), TEST_IS_WRAPPED);
    }
}
