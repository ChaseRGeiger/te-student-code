package com.techelevator.money;

import com.techelevator.money.change.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangeMakerTests {

    private ChangeMaker changeMaker;

    @Before
    public void setup() {
        changeMaker = new ChangeMaker();
    }

    @Test
    public void get_change_for_0() {
        List<Change> change = changeMaker.makeChange(0.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(0, change.size());
    }

    @Test
    public void get_change_for_negative() {
        List<Change> change = changeMaker.makeChange(-10.05);

        Assert.assertNotNull(change);
        Assert.assertEquals(0, change.size());
    }

    @Test
    public void get_change_for_20_dollars() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new TwentyDollar();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(20.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_10_dollars() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new TenDollar();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(10.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_5_dollars() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new FiveDollar();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(5.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_1_dollars() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new OneDollar();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(1.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_25_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new Quarter();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(.25);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_10_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new Dime();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(.10);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_5_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new Nickel();
        money.setCount(1);
        expectedResult.add(money);

        List<Change> change = changeMaker.makeChange(.05);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_with_all_dollar_types() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change twenty = new TwentyDollar();
        twenty.setCount(1);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(1);
        expectedResult.add(one);

        List<Change> change = changeMaker.makeChange(36.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_with_all_coin_types() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change quarter = new Quarter();
        quarter.setCount(1);
        expectedResult.add(quarter);

        Change dime = new Dime();
        dime.setCount(1);
        expectedResult.add(dime);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);

        List<Change> change = changeMaker.makeChange(0.40);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_with_all_types() {
        List<Change> expectedResult = new ArrayList<Change>();

        Change twenty = new TwentyDollar();
        twenty.setCount(1);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(1);
        expectedResult.add(one);

        Change quarter = new Quarter();
        quarter.setCount(1);
        expectedResult.add(quarter);

        Change dime = new Dime();
        dime.setCount(1);
        expectedResult.add(dime);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);

        List<Change> change = changeMaker.makeChange(36.40);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_with_multiple_dollar_types() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change twenty = new TwentyDollar();
        twenty.setCount(3);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(2);
        expectedResult.add(one);

        List<Change> change = changeMaker.makeChange(77.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);

    }

    public void get_change_with_multiple_coin_types() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change quarter = new Quarter();
        quarter.setCount(2);
        expectedResult.add(quarter);

        Change dime = new Dime();
        dime.setCount(1);
        expectedResult.add(dime);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);

        List<Change> change = changeMaker.makeChange(0.65);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_60_dollars_75_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change twentyDollar = new TwentyDollar();
        twentyDollar.setCount(3);
        expectedResult.add(twentyDollar);

        Change quarter = new Quarter();
        quarter.setCount(3);
        expectedResult.add(quarter);


        List<Change> change = changeMaker.makeChange(60.75);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_3_dollars_15_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change one = new OneDollar();
        one.setCount(3);
        expectedResult.add(one);

        Change dime = new Dime();
        dime.setCount(1);
        expectedResult.add(dime);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);

        List<Change> change = changeMaker.makeChange(3.15);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_1000_dollars() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change money = new TwentyDollar();
        money.setCount(50);
        expectedResult.add(money);


        List<Change> change = changeMaker.makeChange(1000.00);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_999_dollars_95_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change twenty = new TwentyDollar();
        twenty.setCount(49);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(4);
        expectedResult.add(one);

        Change quarter = new Quarter();
        quarter.setCount(3);
        expectedResult.add(quarter);

        Change dime = new Dime();
        dime.setCount(2);
        expectedResult.add(dime);

        List<Change> change = changeMaker.makeChange(999.95);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_537_dollars_5_cents() {
        List<Change> expectedResult = new ArrayList<Change>();
        Change twenty = new TwentyDollar();
        twenty.setCount(26);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(2);
        expectedResult.add(one);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);


        List<Change> change = changeMaker.makeChange(537.05);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_116_dollars_40_cents() {
        List<Change> expectedResult = new ArrayList<Change>();

        Change twenty = new TwentyDollar();
        twenty.setCount(5);
        expectedResult.add(twenty);

        Change ten = new TenDollar();
        ten.setCount(1);
        expectedResult.add(ten);

        Change five = new FiveDollar();
        five.setCount(1);
        expectedResult.add(five);

        Change one = new OneDollar();
        one.setCount(1);
        expectedResult.add(one);

        Change quarter = new Quarter();
        quarter.setCount(1);
        expectedResult.add(quarter);

        Change dime = new Dime();
        dime.setCount(1);
        expectedResult.add(dime);

        Change nickel = new Nickel();
        nickel.setCount(1);
        expectedResult.add(nickel);

        List<Change> change = changeMaker.makeChange(116.40);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }

    @Test
    public void get_change_for_20_cents() {
        List<Change> expectedResult = new ArrayList<Change>();

        Change dime = new Dime();
        dime.setCount(2);
        expectedResult.add(dime);


        List<Change> change = changeMaker.makeChange(.20);

        Assert.assertNotNull(change);
        Assert.assertEquals(expectedResult, change);
    }
}
