public class Aims {
    
    public static void main(String[] args) {
        //Create a new cart
        Cart anOrder = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addItem(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addItem(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addItem(dvd3);
        Book book1 = new Book("One Piece", "Manga Comic", "Eichiro Oda", 1.1f);
        anOrder.addItem(book1);
        Track track1 = new Track("Shape Of You", 3);
        Track track2 = new Track("Happy Now", 7);
        CompactDisc cd1 = new CompactDisc("Album 1", "Audio", 13, "Someone");
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        anOrder.addItem(cd1);
        anOrder.showItemsOrdered();


        anOrder.removeItem(dvd1);
        
        System.out.println("Total cost is: " + anOrder.totalCost());  
    }
}