package com.techelevator;

import com.techelevator.animals.Cat;
import com.techelevator.animals.Dog;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectureTest {

    private static final int STARTING_BALANCE = 100;
    private Lecture lecture;

    @Before
    public void setup() {
        lecture = new Lecture(STARTING_BALANCE);
    }


    /*
        @After
        We could have a method here to run after each test is run, but since these tests don't require
        any cleanup we can omit it.
     */

    /*
        Asserting results for different data types

        The following tests show how to assert results for different data types that may be returned from
        a method.
     */

    /*
        Asserting true
     */
    @Test
    public void assertingBooleanTrue() {
        boolean result = lecture.or35(9);
        Assert.assertTrue(result);
    }

    /*
        Asserting false
     */
    @Test
    public void assertingBooleanFalse() {
        boolean result = lecture.or35(2);
        Assert.assertFalse(result);
    }

    /*
        Asserting int
     */
    @Test
    public void assertingInt() {
        int result = lecture.doubleNumber(2);
        Assert.assertEquals(4, result);
    }


    /*
        See the AssertingDoulbesApp for details about the double delta
     */

    /*
    * Asserting double to 2 decimal places
    */
    @Test
    public void assertDoubleTo2DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.33, result, 0.009);
    }

    /*
    * Asserting double to 4 decimal places
    */
    @Test
    public void assertDoubleTo4DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.3333, result, 0.00009);
    }

    /*
        Asserting double to 1 decimal place
     */
    @Test
    public void assertDoubleTo1DecimalPlaces() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3.3, result, 0.09);
    }

    /*
        Asserting double to a whole number
     */
    @Test
    public void assertDoubleToWholeNumber() {
        double result = lecture.thirdDouble(10);
        Assert.assertEquals(3, result, 0.9);
    }

    /*
        Asserting Strings
     */
    @Test
    public void assertString() {
        String result = lecture.firstTwo("Hello");
        Assert.assertEquals("He", result);
    }

    /*
        Asserting Arrays
     */
    @Test
    public void assertArrayUsingArrayEquals() {
        // Arrange (setup)
        int[] testArray = { 2, 4, 6};
        int[] expectedResult = { 4, 8, 12};

        //Act
        int[] actualResult = lecture.doubleAllNumbers( testArray );

        // Assert
        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    /*
        Asserting List
     */
    @Test
    public void assertListUsingEquals() {
        // Arrange (setup)
        String[] testArray = {"Train", "Boat", "Car"};
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("Train");
        expectedResult.add("Car");

        // Act (test)
        List<String> actualResult = lecture.no4LetterWords(testArray);

        // Assert
        /*
        This works for built in data types.  For custom data types the
        .equals method must be Overridden in the class the defines it.
         */
        Assert.assertEquals(expectedResult,actualResult);
    }

    // Map
    @Test
    public void assertListUsingMapEquals() {
        // Arrange (Setup)
        Map<String, Integer> testMap = new HashMap<String, Integer>();
        testMap.put("Peter", 2000);
        testMap.put("Paul", 99);

        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("Peter", 1000);
        expectedResult.put("Paul", 1099);

        // Act (test)
        Map<String, Integer> actualResult = lecture.robPeterToPayPaul(testMap);

        // Assert
          /*
        This works for built in data types.  For custom data types the
        .equals() and hashCode() methods must be Overridden in the class the defines it.
         */
        Assert.assertEquals(expectedResult, actualResult);

    }

    // Objects
    @Test
    public void assertObjectsWithoutEqualsOverride() {
        // Arrange
        Dog dog = new Dog("PuppyKong", "Corgi", 1);

        // Act
        Dog otherDog = lecture.returnOurDog( dog );

        // Assert

        // This doesn't work because Dog doesn't override equals()
        //Assert.assertEquals(dog, otherDog);

        /*
        Asserts can happen in private methods.  If they fail in the
        private method the test will fail.  This allows the creation of
        custom asserts
         */
        assertDogs(dog, otherDog);
    }

    private void assertDogs(Dog dog, Dog other) {
        Assert.assertEquals("Name not equal", dog.getName(), other.getName());
        Assert.assertEquals("Breed not equal", dog.getBreed(), other.getBreed());
        Assert.assertEquals("Age not equal", dog.getAge(), other.getAge());
    }

    @Test
    public void assertObjectsWithEqualsOverride() {
        // Arrange
        Cat cat = new Cat("Catzilla", "Tabby", 5);

        // Act
        Cat otherCat = lecture.returnOurCat(cat);

        // Assert
        Assert.assertEquals(cat, otherCat);
    }


    // void
    @Test
    public void assertVoidReturn() {
        // Arrange
        // was done in the setup by passing STARTING_BALANCE to the constructor.
        // This makes the balance consist for all tests

        int amountToAdd = 10;
        // Act
        lecture.addToBalance( amountToAdd);

        // Assert
        /*
        Since the method doesn't return a value we must determine what side effects
        the method has in the class (meaning what will have changed).  Then use the
        methods the class provides to verify that those changes happened.

        In this case we know the starting balance is 100 due to the setup.  So the
        new balance should be 110.  The new balance can be retrieved using the
        getBalance() method.  So it can be called and the result asserted that the
        balance changed the way we expected.
         */
        int expectedNewBalance = STARTING_BALANCE + amountToAdd;
        int actualNewBalance = lecture.getBalance();

        Assert.assertEquals( expectedNewBalance, actualNewBalance);
    }
}
