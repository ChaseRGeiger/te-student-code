package com.techelevator.services;


import com.techelevator.model.Product;

import java.util.List;
import java.util.Scanner;

public class ConsoleService {

  private static final Scanner in = new Scanner(System.in);

  public void displayAllProducts(List<Product> products){
    displayProductsHeader();
    for (Product product : products){
      displaySingleProductLine(product);
    }
  }

  private void displaySingleProductLine(Product product) {
    System.out.printf("%-10s %-15s %-25s $%-7.2f%n", product.getSku(), product.getProductType(),
            product.getName(), product.getPrice());
  }

  private void displayProductsHeader() {
    System.out.printf("%-10s %-15s %-25s %-7s%n", "Sku", "Type", "Name", "Price");
    System.out.println("-".repeat(60));
  }



}
