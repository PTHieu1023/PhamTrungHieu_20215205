package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.screen.SceenController;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        new SceenController(store, cart);
    }
}