package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.screen.SceenController;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            store.addItem(new Book("Sample " + i, "Sample Book", i));
            store.addItem(new DigitalVideoDisc("Sample DVD " + i, "Sample DVD", i));
        }
        new SceenController(store, cart);
    }
}