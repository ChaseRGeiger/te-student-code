package com.techelevator.money.change;

import org.junit.*;

public class ChangeTests {

    private Change change;

    @Before
    public void createChange() {
        change = new Dime();
        change.setCount(20);
    }

    @Test
    public void change_name() {
        Assert.assertEquals("Dime", change.getName());
    }

    @Test
    public void change_value() {
        Assert.assertEquals(10, change.getValue());
    }

    @Test
    public void change_count() {
        Assert.assertEquals(20, change.getCount());
    }

    @Test
    public void display_name_when_count_1() {
        change.setCount(1);
        Assert.assertEquals("Dime", change.getDisplayName());
    }

    @Test
    public void display_name_when_count_0() {
        change.setCount(0);
        Assert.assertEquals("Dimes", change.getDisplayName());
    }

    @Test
    public void display_name_when_count_not_1() {
        Assert.assertEquals("Dimes", change.getDisplayName());
    }
}
