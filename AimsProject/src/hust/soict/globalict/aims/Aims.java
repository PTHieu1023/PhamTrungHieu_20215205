package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.screen.SceenController;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        for(int i = 0; i < 20; i ++) {
            store.addItem(new Book("Book " + i, "Sample book", (float)i));
        }
        new SceenController(store, cart);
    }
}