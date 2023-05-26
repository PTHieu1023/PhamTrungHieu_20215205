public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private Media itemsOrdered[] = new Media[MAX_NUMBER_ORDERED];
    private int qtyOrdered = 0;

    //Add DVD and sort by created date
    public void addItem(Media item){
        if(qtyOrdered >= MAX_NUMBER_ORDERED){
            System.out.println("The cart is almost full");
        }else{
            itemsOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The item has been added");     
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

    //Search item by id
    public void searchItem(int id)
    {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
        {
            if (itemsOrdered[i].isMatch(id)){
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        } 
        if (!found)
            System.out.println("No item match!");
    }

    //Search item by title
    public void searchItem(String title)
    {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++)
        {
            if (itemsOrdered[i].isMatch(title)){
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        } 
        if (!found)
            System.out.println("No item match!");
    }


}