package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		FlowerShopOrder test = new FlowerShopOrder("Mothers Day Bouquet", 5);

		double check = test.deliveryTotal(true, "25156");

		double total = check + test.subtotal();

		System.out.println("Thank you for your order of: " + test.toString() + " with delivery fees, your total is: " + total);

		List<String> fileOrderList = new ArrayList<>();

		String initialFile = "FlowerInput.csv";
		File newFile = new File(initialFile);

		Scanner fileScanner = new Scanner(newFile);

			while (fileScanner.hasNextLine()){
				fileOrderList.add(fileScanner.nextLine());
			}
			fileScanner.close();



		}

}
