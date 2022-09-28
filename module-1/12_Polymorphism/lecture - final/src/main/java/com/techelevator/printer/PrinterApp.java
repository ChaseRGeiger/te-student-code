package com.techelevator.printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterApp {

    public static void main(String[] args) {

        Product product = new Product("A01", "Surviving TE Book", 12.99, "", 2);
        Animal cat = new Animal("Cat", "Meow");
        StringReverse stringReverse = new StringReverse("Reverse This String");
        Fibonnaci fibonnaci = new Fibonnaci(100);

        List<Printable> thingsThatCanPrint = new ArrayList<Printable>();
        thingsThatCanPrint.add(product);
        thingsThatCanPrint.add(cat);
        thingsThatCanPrint.add(stringReverse);
        thingsThatCanPrint.add(fibonnaci);
        thingsThatCanPrint.add( new House("red", 4, 8, "123 Street"));

        for (Printable printer : thingsThatCanPrint) {
            printer.print();
            System.out.println();
        }
    }
}
