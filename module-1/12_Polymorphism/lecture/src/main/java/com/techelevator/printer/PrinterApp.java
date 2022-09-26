package com.techelevator.printer;

public class PrinterApp {

    public static void main(String[] args) {

        Product product = new Product("A01", "Surviving TE Book", 12.99, "", 2);
        product.displayProductDetails();

        System.out.println();

        Animal cat = new Animal("Cat", "Meow");
        cat.displayWhatTheAnimalSays();

        System.out.println();

        StringReverse stringReverse = new StringReverse("Reverse This String");
        stringReverse.showReversedString();

        System.out.println();
        Fibonnaci fibonnaci = new Fibonnaci(100);
        fibonnaci.showSequence();
    }
}
