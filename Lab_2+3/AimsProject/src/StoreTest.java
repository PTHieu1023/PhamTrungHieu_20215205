public class StoreTest {
    public static void main(String[] args) {
        //Create a new store
        Store store = new Store();

        //Create new dvd object and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addItem(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addItem(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addItem(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        Book book = new Book("One Piece", "Comic Book", "Eichiro Oda", 2);
        store.addItem(book);
        CompactDisc cd = new CompactDisc("Something Cool", "IDK", 10, "SomeOne");
        Track track = new Track("Track 1", 10);
        cd.addTrack(track);
        Track track2 = new Track("Track 2", 16);
        cd.addTrack(track2);
        store.addItem(cd);

        
        store.showItems();

        //Remove a object has same properties as an existed object => No object remove in store
        store.removeItem(dvd4);
        store.showItems();

        //Remove a object contained in store => object was removed
        store.removeItem(dvd3);
        store.showItems();
    }
}
