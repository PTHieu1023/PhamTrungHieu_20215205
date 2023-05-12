public class Store {
    private static int MAX_NUMBER_ITEMS_IN_STORE = 1000000;
    DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBER_ITEMS_IN_STORE];     
    private int numberOfItemsInStore = 0;
    
    //Add a new dvd into store
    void addDVD(DigitalVideoDisc dvd)
    {
        if(numberOfItemsInStore == MAX_NUMBER_ITEMS_IN_STORE){
            System.out.println("Number of disc in store has reached the limit!");
        }else{
            itemsInStore[numberOfItemsInStore] = dvd;
            numberOfItemsInStore++;
        }
    }

    //Remove a disc from store (remove object has the same address to dvd not the same properties to dvd)
    void removeDVD(DigitalVideoDisc dvd){
        boolean changed = false;
        for(int i = 0; i < numberOfItemsInStore; i++)
            if(itemsInStore[i] == dvd){
                for(int j = i; j < numberOfItemsInStore; j++)
                    itemsInStore[j] = itemsInStore[j+1];
                changed = true;
                numberOfItemsInStore--;
            }
        if (!changed)
            System.out.println("No item was remove!");        
    }

    //Show items in store
    public void showItems(){
        System.out.println("Items:");
        
        for (int i = 0; i < numberOfItemsInStore; i++){
            System.out.println(itemsInStore[i].toString());
        }
    }
}
