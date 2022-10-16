package com.techelevator.money;

import org.junit.*;

public class MoneyDrawerTests {

    private MoneyDrawer moneyDrawer;

    @Before
    public void setup() {
        moneyDrawer = new MoneyDrawer();
    }

    @Test
    public void add_money() {
        moneyDrawer.addMoney(100);
        Assert.assertEquals(100, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void add_negative_money_does_not_change_balance() {
        moneyDrawer.addMoney(-5);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void add_zero_money() {
        moneyDrawer.addMoney(0);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_20_cents() {
        moneyDrawer.addMoney(.20);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(1, changeTotal.getChange().size());
        Assert.assertEquals(.20, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_5_cents() {
        moneyDrawer.addMoney(.05);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(1, changeTotal.getChange().size());
        Assert.assertEquals(.05, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_1dollar() {
        moneyDrawer.addMoney(1);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(1, changeTotal.getChange().size());
        Assert.assertEquals(1, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_1000dollar() {
        moneyDrawer.addMoney(1000);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(1, changeTotal.getChange().size());
        Assert.assertEquals(1000, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_0() {
        moneyDrawer.addMoney(0);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(0, changeTotal.getChange().size());
        Assert.assertEquals(0, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_negative() {
        moneyDrawer.addMoney(-1);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(0, changeTotal.getChange().size());
        Assert.assertEquals(0, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_537dollars_5cents() {
        moneyDrawer.addMoney(537.05);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(5, changeTotal.getChange().size());
        Assert.assertEquals(537.05, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

    @Test
    public void change_when_999dollars_and_95_cents() {
        moneyDrawer.addMoney(999.95);
        ChangeTotal changeTotal = moneyDrawer.makeChange();
        Assert.assertEquals(6, changeTotal.getChange().size());
        Assert.assertEquals(999.95, changeTotal.getTotalAmount(), 0.009);
        Assert.assertEquals(0, moneyDrawer.getCurrentBalance(), 0.009);
    }

}
