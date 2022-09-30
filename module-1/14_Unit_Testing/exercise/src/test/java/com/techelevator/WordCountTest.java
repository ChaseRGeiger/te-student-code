package com.techelevator;

/*
    one double instance
    two double instance
    empty array
    all single instances
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTest {

    private WordCount target;

    @Before
    public void setup(){
        target = new WordCount();
    }

    @Test
    public void one_double_instance(){
        String[] newArray = {"ba", "ba", "Black", "Sheep"};
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("ba", 2);
        test.put("Black", 1);
        test.put("Sheep", 1);
        Assert.assertEquals(test, target.getCount(newArray));
    }

    @Test
    public void two_double_instance(){
        String[] newArray = {"a", "b", "a", "c", "b"};
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("a", 2);
        test.put("b", 2);
        test.put("c", 1);
        Assert.assertEquals(test, target.getCount(newArray));
    }

    @Test
    public void empty_array(){
        String[] newArray = {};
        Map<String, Integer> test = new HashMap<String, Integer>();

        Assert.assertEquals(test, target.getCount(newArray));
    }

    @Test
    public void all_single_instances(){
        String[] newArray = {"c", "b", "a"};
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("c", 1);
        test.put("b", 1);
        test.put("a", 1);
        Assert.assertEquals(test, target.getCount(newArray));
    }


}
