package com.techelevator.inventory.reader;

import com.techelevator.BaseCandyApplicationTests;
import com.techelevator.inventory.StockItem;
import com.techelevator.inventory.exceptions.InventoryNotFoundException;

import java.util.Map;

public class MockInventoryReader extends BaseCandyApplicationTests implements InventoryReader {

    @Override
    public Map<String, StockItem> read() throws InventoryNotFoundException {
        return buildTestInventoryMap();
    }
}
