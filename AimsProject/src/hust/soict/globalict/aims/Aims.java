package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.screen.SceenController;
import hust.soict.globalict.aims.store.Store;

public class Aims {
    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        for(int i = 0; i<99; i++){
            store.addItem(new Book("Sample Book " + i, "Sample", (float)i));
        }
        SceenController screenController = new SceenController(store, cart);
    }
}