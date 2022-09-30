package com.techelevator.trees;

/*/
    pick some of the fruit
    pick all the fruit
    pick 0 fruit
    pick negative fruit
    pick too much fruit
    pick fruit multiple times

    number of fruit on the tree
    type of fruit

 */


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitTreeTest {

    private FruitTree fruitTree;

    @Before
    public void setup() {
        fruitTree = new FruitTree("Apple", 20);
    }

    @Test
    public void tree_has_correct_fruit() {
        String actualTypeOfFruit = fruitTree.getTypeOfFruit();
        Assert.assertEquals("Apple", actualTypeOfFruit);
    }

    @Test
    public void tree_has_correct_number_of_fruit() {
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_some_fruit() {
        // Arrange
        // Act
        boolean wasSuccessful = fruitTree.pickFruit(5);
        // Assert
        Assert.assertTrue(wasSuccessful);
        int actualFruitRemaining = fruitTree.getPiecesOfFruitLeft();
        Assert.assertEquals(15, actualFruitRemaining);
    }

    @Test
    public void pick_all_the_fruit() {
        // Arrange
        // Act
        boolean wasSuccessful = fruitTree.pickFruit(20);
        // Assert
        Assert.assertTrue("Returned False", wasSuccessful);
        Assert.assertEquals("Wrong number of fruit left on tree", 0, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_fruit_multiple_times() {
        // Arrange
        fruitTree.pickFruit(5);

        // Act
        boolean wasSuccessful = fruitTree.pickFruit(7);

        // Assert
        Assert.assertTrue(wasSuccessful);
        Assert.assertEquals(8, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void try_pick_too_much_fruit() {
        Assert.assertFalse( fruitTree.pickFruit(21) );
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft());
    }

    @Test
    public void pick_0_fruit() {
        Assert.assertFalse( fruitTree.pickFruit(0) );
        Assert.assertEquals(20, fruitTree.getPiecesOfFruitLeft() );
    }

    @Test
    public void pick_negative_fruit() {
        Assert.assertFalse( fruitTree.pickFruit(-1) );
        Assert.assertEquals( 20, fruitTree.getPiecesOfFruitLeft());
    }

}
