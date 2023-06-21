package hust.soict.globalict.aims.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;

public class SceenController {
    private AddItemScreen addItemScreen;
    private StoreScreen storeScreen;
    private CartScreen cartScreen;
    private Store store;
    private Cart cart;

    
    public SceenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        addItemScreen = new AddItemScreen(store);
        addItemScreen.setVisible(false);
        storeScreen = new StoreScreen(store, cart);
        storeScreen.setVisible(true);
        cartScreen = new CartScreen(cart);
        cartScreen.getCartScreenController().setStoreScreen(storeScreen);
        storeScreen.setAddItemScreen(addItemScreen);
        cartScreen.setVisible(false);
        storeScreen.getBtnViewCart().addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cartScreen.setVisible(true);
                }
            });
    }
}
