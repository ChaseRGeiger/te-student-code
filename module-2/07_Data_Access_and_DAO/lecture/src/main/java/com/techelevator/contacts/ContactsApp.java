package com.techelevator.contacts;

import java.util.Scanner;

public class ContactsApp {

    private static final Scanner in = new Scanner(System.in);

    public void run() {
        // Create DataSource

        // Get a list of all persons and show them

        // Get one person by id and display it

        // Add a person

        // Update the person just added

        // Delete a person by id

    }

    private int getPersonIdFromUser() {
        System.out.print("Person id >>>");
        return Integer.parseInt( in.nextLine() );
    }


    public static void main(String[] args) {
        new ContactsApp().run();
    }
}
