package com.techelevator.exercises;

public class SleepIn {

    /*
    1. The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on
    vacation. We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in.
    sleepIn(false, false) → true
    sleepIn(true, false) → false
    sleepIn(false, true) → true
    */
    public boolean sleepIn(boolean weekday, boolean vacation) {
      boolean sleepIn = !weekday || vacation;
      return sleepIn;
    }

}
