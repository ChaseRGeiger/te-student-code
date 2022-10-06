package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word?");
        String replaceWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String sourceFile = userInput.nextLine();
        System.out.println("What is the destination file?");
        String destFile = userInput.nextLine();

        File initialFile = new File(sourceFile);
        File destination = new File(destFile);

       try(Scanner fileScanner = new Scanner(initialFile);
        PrintWriter printWriter = new PrintWriter(destination);
        BufferedWriter bufferedWriter = new BufferedWriter(printWriter)){

           while(fileScanner.hasNextLine()) {
               String lineFromFile = fileScanner.nextLine();
               String writeFromFile = replaceStringInEachLine(lineFromFile, searchWord, replaceWord);
               bufferedWriter.write(writeFromFile);
               bufferedWriter.newLine();

           }

           } catch (FileNotFoundException e){
           System.out.println("File Not Found");
           } catch(IOException e){
           System.out.println("Error");
       }



    }

    private static String replaceStringInEachLine(String lineFromFile, String search, String replace){
        String newLine = "";
        String[] words = lineFromFile.split(" ");

        for (String word : words){
            if(word.equals(search)){
                word = replace;
            }

            newLine += word + " ";
        }

        return newLine;
    }

}
