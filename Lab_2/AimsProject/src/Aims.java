public class Aims {
    
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd[] = new DigitalVideoDisc[30];
        dvd[0] = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        dvd[1] = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        dvd[2] = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        anOrder.addDigitalVideoDisc(dvd);
        anOrder.showItemsOrdered();

        //anOrder.removeDigitalVideoDisc(dvd1);
        
        //System.out.println("Total cost is: " + anOrder.totalCost());  
    }
}
//Checking upadate