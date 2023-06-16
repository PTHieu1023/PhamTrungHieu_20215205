package hust.soict.globalict.aims.store;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Store {
    private static int MAX_NUMBER_ITEMS_IN_STORE = 1000000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();     
    private int numberOfItemsInStore = 0;
    
    public Media findByTitle(String title) {
        for(Media item : itemsInStore)
            if (item.getTitle().equals(title))
                return item;
        return null;
    }
    //Add a new dvd into store
    public void addItem(Media item)
    {
        if(numberOfItemsInStore == MAX_NUMBER_ITEMS_IN_STORE){
            System.out.println("Number of disc in store has reached the limit!");
        
        } else if (itemsInStore.contains(item)) {
            System.out.println("This item is already existed in store");
            
        } else {
            itemsInStore.add(item);
            numberOfItemsInStore++;
        }
    }

    //Remove a disc from store (remove object has the same address to dvd not the same properties to dvd)
    public void removeItem(Media item){
        boolean changed = false;
        if(itemsInStore.contains(item)) {
            itemsInStore.remove(item);
            numberOfItemsInStore--;
            changed = true;
        }
        if (!changed)
            System.out.println("No item was remove!");        
    }

    //Show items in store
    public void showItems(){
        System.out.println("Items:");
        for (Media item : itemsInStore){
            System.out.println(item.toString());
        }
    }
}
