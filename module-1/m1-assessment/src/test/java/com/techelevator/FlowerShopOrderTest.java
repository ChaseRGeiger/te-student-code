package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlowerShopOrderTest {

    private FlowerShopOrder target;

    @Before
    public void setup(){
        target = new FlowerShopOrder();
    }

    @Test
    public void correct_subtotal(){
        target.setNumOfRoses(5);

        Assert.assertEquals(34.94, target.subtotal(), .9);
    }

    @Test
    public void correct_delivery_fee(){
        Assert.assertEquals(9.98, target.deliveryTotal(true, "20000"), .9);
    }

}
