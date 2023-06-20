package hust.soict.globalict.aims;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.screen.StoreScreen;
import hust.soict.globalict.aims.store.Store;
import java.awt.event.ActionEvent;

public class Aims {
    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();
    static Store store = new Store();
    static StoreScreen storeScreen;
    static CartScreen cartScreen;

    public static void main(String[] args) {
        for(int i = 0; i<99; i++){
            store.addItem(new Book("Sample Book " + i, "Sample", (float)i));
        }
        StoreScreen storeScreen = new StoreScreen(store, cart);
        CartScreen cartScreen = new CartScreen(cart);
        cartScreen.setVisible(false);
        JButton btnViewCart = storeScreen.getBtnViewCart();
        btnViewCart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cartScreen.setVisible(true);
                }
            });
    }

    static void btnViewCartPressed() {
        storeScreen.setVisible(false);
        cartScreen = new CartScreen(cart);
    }
}