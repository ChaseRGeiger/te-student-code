package com.techelevator;

import java.util.Stack;

public class Lecture_Stack {

    public static void main(String[] args) {

        /*
            Stacks are a Collections Data Structure that holds data in a
            Last In First Out order.  Stacks are optimized for insertion and deletion.
            Searching or selecting by index is not available.

            Similar to a stack of books.  The last book added is placed on top of the pile
            and the top book is the first removed from the pile.

            Real world examples:  Browser back button,  Undo in a document
         */
        System.out.println("####################");
        System.out.println("        STACK");
        System.out.println("####################");
        System.out.println();

        /*
            Stacks do not have an interface.  (Why?  nobody but the author knows for sure)
            So they are both declared and instantiated with the Stack implementation class.
            Stack take a generic data type <T> that defines what type of Object they
            can hold.
         */
        Stack<String> history = new Stack<String>();

        /*
            Items are added to the stack using the push() method
         */
        history.push("http://www.google.com");
        history.push("http://stackoverflow.com");
        history.push("http://techelevator.com");
        history.push("https://blog.codinghorror.com");
        history.push("http://git.techelevator.com");


        /*
            Since stack can not be accessed by index, they are processed
            by looping over them with a while() loop that continues until
            isEmpty() returns true
         */
        while ( ! history.isEmpty() ) {
            /*
                Items are retrieved from the Stack using pop().
                pop() returns the next item and removes it from the stack.

                similar to Queue, peek() can be used to retrieve the next item without
                removing it or changing the stack.   size() can be used to determine how
                many items are in the stack();
             */

            System.out.println("There are " + history.size() + " remaining in the stack");
            System.out.println("The next item is: " + history.peek());

            String previousPage = history.pop();
            System.out.println("Previous Page: " + previousPage);

        }



        System.out.println("\n------------------------------------");
        System.out.println(" STACK USE CASE - REVERSING VALUES");
        System.out.println("------------------------------------");
        /*
            A common problem Stack solves is reversing an array or collection, since
            items pop() from the stack in the reverse order they are added (push())
         */
        int[] nums = { 10, 20, 30 , 40, 50 };
        Stack<Integer> numStack = new Stack<Integer>();
        for (int num : nums) {
            numStack.push(num);
        }
        while ( !numStack.isEmpty() ) {
            System.out.println(numStack.pop());
        }

    }

}
