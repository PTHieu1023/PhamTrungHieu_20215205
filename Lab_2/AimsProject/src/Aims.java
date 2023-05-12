public class Aims {
    
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd[] = new DigitalVideoDisc[30];



        for (int i = 0; i<30; i++)
            dvd[i] = dvd1;
        anOrder.addDigitalVideoDisc(dvd);
        System.out.println("Total cost is: " + anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd1);
        
        System.out.println("Total cost is: " + anOrder.totalCost());  
    }
}
//Checking upadate