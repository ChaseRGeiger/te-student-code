package com.techelevator.printer;

public class Fibonnaci implements Printable {

    private int highestNumber;

    public Fibonnaci(int highestNumber) {
        this.highestNumber = highestNumber;
    }

    public void showSequence() {

        int previous = 1;
        System.out.print("0, 1");

        for (int next = 1; next <= highestNumber;) {
            System.out.print(", " + next);
            int temp = previous + next;
            previous = next;
            next = temp;
        }

    }
    public void print(){
        showSequence();
    }
}
