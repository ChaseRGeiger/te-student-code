package com.techelevator;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileObjectExamples {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.print("Enter Folder name >>>");
		String folderName = userInput.nextLine();

		/*
			The file object can be created by passing it a path to either a file or a folder
		 */
		File newFolder = new File(folderName);

		doesFileOrFolderExist(newFolder);

		System.out.println();
		System.out.println("*** Creating new folder");

		/*
			mkdir() can be used to create a new folder
		 */
		newFolder.mkdir();

		doesFileOrFolderExist(newFolder);
		System.out.println();


		System.out.print("Enter File name >>>");
		String fileName = userInput.nextLine();

		/*
			The File object can be created with 2 arguments:  path, fileName
		 */
		File newFile = new File(newFolder, fileName);

		doesFileOrFolderExist(newFile);

		System.out.println();
		System.out.println("*** Creating new file");

		/*
			The createNewFile() method can be used to create a new file
		 */
		newFile.createNewFile();

		doesFileOrFolderExist(newFile);

		/*
			Getting information about the file that was created
			getAbsolutePath() - Returns the absolute to the file on the file system
			getPath() - Returns the relative path to the file, relative to the program location
			getName() - Returns just the name of the file
			length() - Returns the size of the file
			canRead(), canWrite(), canExecute() - returns if the program has permissions to read, write, or execute the file
		 */
		System.out.println();
		System.out.println("New File Details");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("New File Absolute Path: " + newFile.getAbsolutePath());
		System.out.println("File Relative Path (from the program): " + newFile.getPath());
		System.out.println("Just the File Name: " + newFile.getName());
		System.out.println("File Size: " + newFile.length());
		System.out.println("Can you Read the File: " + newFile.canRead());
		System.out.println("Can you Write to the File: " + newFile.canWrite());
		System.out.println("Can you Execute the File: " + newFile.canExecute());


	}

	private static void doesFileOrFolderExist(File file) {
		/*
			exists() returns true if the File or Folder the file object points to exists
			and false if it does not exists
		 */
		if (file.exists()) {
			/*
				getName() returns the name of the file or folder without the path
			 */
			System.out.println(file.getName() + " exists");
			/*
				getAbsoluateFile() returns the absolute path to the file or folder in the file system
			 */
			System.out.println("Absolute Path: " + file.getAbsoluteFile());

			/*
				isDirectory() returns true if the path points to a directory/folder, and false if it
				points to a file.
			 */
			if (file.isDirectory()) {
				System.out.println(file.getName() + " is a directory");
			}
			/*
				isFile() returns true if the path points to a file, and false if it points to a directory
			 */
			if (file.isFile()) {
				System.out.println(file.getName() + " is a file");
			}
		} else {
			System.out.println(file.getName() + " does not exists");
		}
	}

}
