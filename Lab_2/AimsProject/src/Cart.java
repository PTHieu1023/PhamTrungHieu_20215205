public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    private int qtyOrdered;

    //Add DVD and sort by created date
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBER_ORDERED){
            System.out.println("The cart is almost full");
        }else{
            for(int i = qtyOrdered; i>0; i--){
                itemsOrdered[i] = itemsOrdered[i-1];
            }
            itemsOrdered[0] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");     
        }
    }

    //Add a array of discs into cart
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (DigitalVideoDisc dvd : dvdList)
            if(dvd != null)
                addDigitalVideoDisc(dvd);
    } 

    //remove all discs be the same as parameter disc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int i = 0;
        boolean flag = false;
        while(i < qtyOrdered) {
            if (itemsOrdered[i] == disc){
                for (int j = i; j < qtyOrdered-1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                qtyOrdered -= 1;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("Disc has been delete from cart!");
                flag = true;
            }else{
                i += 1;
            }   
        }
        if (!flag)
            System.out.println("Not found the disc in cart!\nNo disc was removed");
    }

    //Return sum of dvd's cost existing in cart
    public float totalCost(){
        float sumCost = 0;
        for (int i = 0; i < qtyOrdered; i++){
            sumCost += itemsOrdered[i].getCost();
        }
        return sumCost;
    }
    

    //Show all item existing in cart
    public void showItemsOrdered(){
        System.out.println("Order Items:");
        
        for (int i = 0; i < qtyOrdered; i++){
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        
    }
}