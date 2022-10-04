package com.techelevator.writing;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) {

        /*
         * Create a file and PrintWriter
         */
        String pathToFile = "writtenWithBuffer.txt";
        File fileToWriteTo = new File(pathToFile);

        /*
         * To add buffering a Print Writer is still needed and will still do the writing.
         * A BufferedWriter is added and passed the Print Writer.  The Print Writer will still
         * write to the file and the buffered writer will provide buffering.
         */
        try ( PrintWriter printWriter = new PrintWriter( fileToWriteTo );
              BufferedWriter bufferedWriter = new BufferedWriter( printWriter) ) {

            bufferedWriter.write("This line was written to the file");
            bufferedWriter.newLine();
            bufferedWriter.write("This is a second line");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("There was a problem writing the file " + e.getMessage());
        }

    }
}
