import java.util.ArrayList;

public class Store {
    private static int MAX_NUMBER_ITEMS_IN_STORE = 1000000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();     
    private int numberOfItemsInStore = 0;
    
    //Add a new dvd into store
    void addItem(Media item)
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
    void removeItem(Media item){
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
