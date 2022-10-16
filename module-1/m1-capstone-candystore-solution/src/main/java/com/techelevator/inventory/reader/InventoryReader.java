package com.techelevator.inventory.reader;

import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;

import java.util.Map;

public interface InventoryReader {

    Map<String, StockItem> read() throws InventoryNotFoundException;
}
