package com.techelevator.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {

        List<Printable> thingsThatCanPrint = new ArrayList<Printable>();

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
        System.out.println();

        thingsThatCanPrint.add(product);
        thingsThatCanPrint.add(cat);
        thingsThatCanPrint.add(stringReverse);
        thingsThatCanPrint.add(fibonnaci);
        thingsThatCanPrint.add(new House("red", 4, 8, "123 Street"));


        for(Printable printer : thingsThatCanPrint){
            printer.print();
            System.out.println();
        }
    }
}
