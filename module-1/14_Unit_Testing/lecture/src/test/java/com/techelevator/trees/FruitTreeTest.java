package com.techelevator.trees;

/*
    pick some of the fruit
    pick all of the fruit
    pick 0 fruit
    pick negative fruit
    pick too much fruit
    num of fruit on tree
    pick fruit multiple times
    type of fruit
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void setup(){
        fruitTree = new FruitTree("Apple", 20);
    }

    @Test
    public void tree_has_correct_fruit(){
        String actualTypeOfFruit = fruitTree.getTypeOfFruit();
        Assert.assertEquals("Apple", actualTypeOfFruit);
    }

    @Test
    public void has_correct_num(){
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_some_fruit(){
        boolean wasSuccessful = fruitTree.pickFruit(5);
        Assert.assertTrue(wasSuccessful);
        Assert.assertEquals(15, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_all_the_fruit(){
        Assert.assertTrue(fruitTree.pickFruit(20));
        Assert.assertEquals(0, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_fruit_multiple_times(){
        //Arrange
        fruitTree.pickFruit(5);


        Assert.assertTrue(fruitTree.pickFruit(7));
        Assert.assertEquals(8, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_too_much_fruit(){
        Assert.assertFalse(fruitTree.pickFruit(21));
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());

    }

    @Test
    public void pick_zero_fruit(){
        Assert.assertTrue(fruitTree.pickFruit(0));
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_negative_fruit(){
        Assert.assertFalse(fruitTree.pickFruit(-1));
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
    }

}
