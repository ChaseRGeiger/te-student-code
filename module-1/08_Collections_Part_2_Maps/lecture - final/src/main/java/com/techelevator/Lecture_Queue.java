package com.techelevator;

import java.util.LinkedList;
import java.util.Queue;

public class Lecture_Queue {

    public static void main(String[] args) {

        /*
            Queues are a Collections Data Structure that holds data in a
            First In First Out order.  Queues are optimized for insertion and deletion.
            Searching or selecting by index is not available.

            Similar to a line at a cash register.  The first in the line is the
            first person to be checked out.

            Real world examples:  Print Queue, Email Queue
         */
        System.out.println("####################");
        System.out.println("        QUEUE");
        System.out.println("####################");
        System.out.println();

        /*
            Queues are declared using the Queue interface.
            The most common Queue implementation class is LinkedList.
            Queues take a generic data type <T> that defines what type of Object they
            can hold.
         */
        Queue<String> tasks = new LinkedList<String>();

        /*
            Items are added to the queue using the offer() method
         */
        tasks.offer("Clean dishes");
        tasks.offer("Sweep floor");
        tasks.offer("Clean counters");
        tasks.offer("Scrub ceiling");


        /////////////////////
        // PROCESSING ITEMS IN A QUEUE
        /////////////////////

        /*
            Since queues can not be accessed by index, they are processed
            by looping over them with a while() loop that continues until
            isEmpty() returns true
         */
        while ( !tasks.isEmpty() ) {

            /*
                Items are retrieved from the Queue using poll().
                poll() returns the next item and removes it from the queue.
             */
            String nextTask = tasks.poll();
            System.out.println("Next task: " + nextTask);
            /*
                .size() can be used to determine how many items remain in the queue
             */
            System.out.println("Tasks remaining after poll: " + tasks.size());

            /*
                peek() returns the next item in the Queue, but does not remove it.
                It is used to see what the next item will be without effecting the Queue.
             */
            String taskAfterThat = tasks.peek();
            if (taskAfterThat != null) {
                System.out.println("After that: " + taskAfterThat);
                System.out.println("Tasks remaining after peek: " + tasks.size());
            } else {
                System.out.println("No further tasks!");
            }
            System.out.println();
        }

    }
}
