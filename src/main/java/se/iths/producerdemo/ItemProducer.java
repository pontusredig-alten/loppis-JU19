package se.iths.producerdemo;

import se.iths.entity.Item;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

public class ItemProducer {

    List<Item> listOfItems = new ArrayList<Item>();

    @Produces
    List<Item> getProducedItems() {
        listOfItems.add(new Item("Stol", "Möbel", 2, 3.45));
        listOfItems.add(new Item("Bänk", "Möbel", 3, 4.45));
        return listOfItems;
    }

}
