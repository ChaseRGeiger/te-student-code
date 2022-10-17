package com.techelevator.cart;

import com.techelevator.BaseCandyApplicationTests;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTests extends BaseCandyApplicationTests {

    private ShoppingCart shoppingCart;

    @Before
    public void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void add_item_to_cart() {
        List<CartItem> expectedCart = new ArrayList<CartItem>();
        expectedCart.add( new CartItem( TEST_ITEM_LICORICE, 10));

        shoppingCart.addItemToCart(TEST_ITEM_LICORICE, 10);

        Assert.assertEquals(expectedCart, shoppingCart.getCart());

    }

    @Test
    public void add_multiple_items_to_cart() {
        List<CartItem> expectedCart = new ArrayList<CartItem>();
        expectedCart.add( new CartItem( TEST_ITEM_LICORICE, 10));
        expectedCart.add( new CartItem( TEST_ITEM_CHOCOLATE, 2));

        shoppingCart.addItemToCart(TEST_ITEM_LICORICE, 10);
        shoppingCart.addItemToCart(TEST_ITEM_CHOCOLATE, 2);

        Assert.assertEquals(expectedCart, shoppingCart.getCart());
    }

    @Test
    public void clear_cart() {
        shoppingCart.addItemToCart(TEST_ITEM_LICORICE, 10);
        shoppingCart.addItemToCart(TEST_ITEM_CHOCOLATE, 2);

        shoppingCart.clearCart();

        Assert.assertEquals(0, shoppingCart.getCart().size());
    }

    @Test
    public void total_cost_with_1_item() {

        double expectedTotal = TEST_ITEM_LICORICE.getPrice() * 10d;

        shoppingCart.addItemToCart(TEST_ITEM_LICORICE, 10);
        Assert.assertEquals(expectedTotal, shoppingCart.getCartTotalAmount(), 0.009);
    }

    @Test
    public void total_cost_with_multiple_item() {

        double expectedTotal = TEST_ITEM_LICORICE.getPrice() * 10;
        expectedTotal += TEST_ITEM_CHOCOLATE.getPrice() * 2;
        expectedTotal += TEST_ITEM_HARD_CANDY.getPrice() * 100;
        expectedTotal += TEST_ITEM_SOUR.getPrice() * 72;

        shoppingCart.addItemToCart(TEST_ITEM_LICORICE, 10);
        shoppingCart.addItemToCart(TEST_ITEM_CHOCOLATE, 2);
        shoppingCart.addItemToCart(TEST_ITEM_HARD_CANDY, 100);
        shoppingCart.addItemToCart(TEST_ITEM_SOUR, 72);

        Assert.assertEquals(expectedTotal, shoppingCart.getCartTotalAmount(), 0.009);
    }
}
