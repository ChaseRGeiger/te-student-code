package com.techelevator.cart;

import com.techelevator.BaseCandyApplicationTests;
import org.junit.*;

public class CartItemTests extends BaseCandyApplicationTests {

    private CartItem cartItem;

    @Before
    public void setup() {
        cartItem = new CartItem(TEST_ITEM_LICORICE, 10);
    }

    @Test
    public void cart_item() {
        Assert.assertEquals(TEST_ITEM_LICORICE, cartItem.getItem());
    }

    @Test
    public void cart_count() {
        Assert.assertEquals(10, cartItem.getCount());
    }

    @Test
    public void cart_total() {
        Assert.assertEquals((TEST_ITEM_LICORICE.getPrice() * 10), cartItem.getTotalCost(), 0.009);
    }

    @Test
    public void cart_total_when_quantity_0() {
        CartItem zeroQuantity = new CartItem(TEST_ITEM_LICORICE, 0);
        Assert.assertEquals(0, zeroQuantity.getTotalCost(), 0.009);
    }

    @Test
    public void cart_total_when_quantity_1() {
        CartItem zeroQuantity = new CartItem(TEST_ITEM_LICORICE, 1);
        Assert.assertEquals(TEST_ITEM_LICORICE.getPrice(), zeroQuantity.getTotalCost(), 0.009);
    }

    @Test
    public void cart_total_negative_quantity() {
        CartItem negativeQuantity = new CartItem(TEST_ITEM_LICORICE, -1);
        Assert.assertEquals(0, negativeQuantity.getTotalCost(), 0.009);
    }
}
