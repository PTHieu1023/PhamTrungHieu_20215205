package hust.soict.globalict.aims.cart;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int qtyOrdered = 0;

    //Add DVD and sort by created date
    public void addItem(Media item){
        if(qtyOrdered >= MAX_NUMBER_ORDERED){
            System.out.println("The cart is almost full");
        }else if (itemsOrdered.contains(item)) {
            System.out.println("This item is already exist in cart");
        }else{
            itemsOrdered.add(item);
            System.out.println("Item is added into cart");
            
        }
    }

    //Add a array of discs into cart
    public void addItems(Media [] items){
        for (Media item : items)
            if(item != null)
                addItem(item);
    } 

    //remove all discs be the same as parameter disc
    public void removeItem(Media disc){
        boolean flag = false;
        if(itemsOrdered.contains(disc)) {
            qtyOrdered--;
            itemsOrdered.remove(disc);
            flag = true;
        }
        if (!flag)
            System.out.println("Not found the disc in cart!\nNo disc was removed");
    }

    //Return sum of dvd's cost existing in cart
    public float totalCost(){
        float sumCost = 0;
        for (Media item : itemsOrdered){
            sumCost += item.getCost();
        }
        return sumCost;
    }
    

    //Show all item existing in cart
    public void showItemsOrdered() {
        System.out.println("Order Items:");
        
        for (Media item : itemsOrdered){
            System.out.println(item.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
    }

    //Search item by id
    public void searchItem(int id) {
        boolean found = false;
        for (Media item : itemsOrdered)
        {
            if (item.isMatch(id)){
                System.out.println(item.toString());
                found = true;
            }
        } 
        if (!found)
            System.out.println("No item match!");
    }

    //Search item by title
    public void searchItem(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.isMatch(title)){
                System.out.println(item.toString());
                found = true;
            }
        } 
        if (!found)
            System.out.println("No item match!");
    }


}