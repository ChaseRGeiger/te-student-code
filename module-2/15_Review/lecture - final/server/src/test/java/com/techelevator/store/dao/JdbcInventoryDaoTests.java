package com.techelevator.store.dao;

import com.techelevator.store.model.Product;
import org.junit.*;

import java.util.List;

public class JdbcInventoryDaoTests extends BaseDaoTests {

    private static final Product CLOTHING_PRODUCT_1 = new Product("C01", "Clothing", "Test Clothing 1",
            "Test Clothing 1 Description", false, 24.98, 6, true);
    private static final Product GROCERY_PRODUCT_1 = new Product("G01", "Grocery", "Test Grocery 1",
            "Test Grocery 1 Description",true, 8.99, 1, false);
    private static final Product HOMEGOOD_PRODUCT_1 = new Product("H01", "Home Goods", "Test Home Goods 1",
            "Test Home Goods 1 Description", false, 5.55, 1, true);
    private static final Product BOOK_PRODUCT_1 = new Product("B01", "Book", "Test Book 1",
            "Test Book 1 Description - taxable", false, 19.95, 11, true);
    private static final Product BOOK_PRODUCT_2 = new Product("B02", "Book", "Test Book 2",
            "Test Book 2 Description - nontaxable", false, 39.95, 5, false);


    private InventoryDao dao;

    @Before
    public void setup() {
        dao = new JdbcInventoryDao(dataSource);
    }

    @Test
    public void get_all_products() {
        List<Product> actualProducts = dao.getAllProducts();
        Assert.assertEquals("Wrong number of products", 5, actualProducts.size());
        Assert.assertTrue("Does not contain Clothing Product 1", actualProducts.contains( CLOTHING_PRODUCT_1 ) );
        Assert.assertTrue("Does not contain Grocery Product 1", actualProducts.contains( GROCERY_PRODUCT_1 ) );
        Assert.assertTrue("Does not contain Home Good Product 1", actualProducts.contains( HOMEGOOD_PRODUCT_1 ) );
        Assert.assertTrue("Does not contain Book Product 1", actualProducts.contains( BOOK_PRODUCT_1 ) );
        Assert.assertTrue("Does not contain Book Product 2", actualProducts.contains( BOOK_PRODUCT_2 ) );
    }


}
