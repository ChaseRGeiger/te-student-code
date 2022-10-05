package com.techelevator.writing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterExample {

    public static void main(String[] args) {
        /*
         * Step 1:  Create a File object that represents the file being written to
         *          If the file does not exist, PrintWriter will create it
         */
        String pathToFile = "numbers.txt";
        File fileToWriteTo = new File( pathToFile );



        /*
         * Step 2: Create a PrintWriter (or other FileWriter) in a try-with-resource and
         *         pass it the File object that represents the file to write to.
         */
        try ( PrintWriter printerWriter = new PrintWriter( fileToWriteTo ) ) {
            /*
             * Step 3:  Call the print(), println(), or printf() method on the print writer
             *          and pass it the string to write to the file.  We can repeat this
             *          as many times as needed.  Each call to println() will write to a
             *          new line.
             */

            printerWriter.println("1 2 3 4 5 6 7 8");


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}
