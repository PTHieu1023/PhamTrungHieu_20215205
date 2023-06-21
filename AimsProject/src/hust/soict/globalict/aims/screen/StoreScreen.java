package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private int itemPage;

    private CartScreen cartScreen;
    private AddItemScreen addItemScreen;

    public void setCartScreen(CartScreen cartScreen) {
        this.cartScreen = cartScreen;
    }

    public void setAddItemScreen(AddItemScreen addItemScreen) {
        this.addItemScreen = addItemScreen;
    }

    private Container cp;
    private JPanel content;

    public int getItemPage() {
        return itemPage;
    }
    JButton btnViewCart = new JButton("View Cart");

    public Cart getCart() {
        return cart;
    }

    public JButton getBtnViewCart() {
        return btnViewCart;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem addItem = new JMenuItem("Add Item");

        addItem.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addItemScreen.setVisible(true);
                }
            }
        );

        menu.add(addItem);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        btnViewCart.setPreferredSize(new Dimension(100, 50));
        btnViewCart.setMaximumSize (new Dimension(100, 50));
        JLabel page = new JLabel("Page 1/" + (store.getNumberOfItemsInStore()/9+1));
        JButton prePage = new JButton("<");
        JButton nextPage = new JButton(">");
        if(itemPage == 1)
            prePage.setEnabled(false);
        else
            prePage.setEnabled(true);
        if(itemPage == store.getNumberOfItemsInStore()/9+1)
            nextPage.setEnabled(false);
        else
            nextPage.setEnabled(true);
        prePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp.remove(content);
                itemPage -= 1;
                page.setText("Page " + itemPage +"/" + (store.getNumberOfItemsInStore()/9+1));
                if(itemPage == 1)
                    prePage.setEnabled(false);
                if(itemPage <= store.getNumberOfItemsInStore()/9)
                    nextPage.setEnabled(true);
                content = createCenter(itemPage);
                cp.add(content, BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();
            }
        });

        nextPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cp.remove(content);
                itemPage += 1;
                nextPage.setEnabled(true);
                if(itemPage == store.getNumberOfItemsInStore()/9 + 1)
                    nextPage.setEnabled(false);
                if(itemPage > 1)
                    prePage.setEnabled(true);
                content = createCenter(itemPage);
                content = createCenter(itemPage);
                cp.add(content, BorderLayout.CENTER);
                cp.revalidate();
                cp.repaint();
                page.setText("Page " + itemPage +"/" + (store.getNumberOfItemsInStore()/9+1));
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(prePage);
        header.add(Box.createHorizontalGlue());
        header.add(page);
        header.add(Box.createHorizontalGlue());
        header.add(nextPage);
        header.add(Box.createHorizontalGlue());
        header.add(btnViewCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter(int page) {  
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> medias = store.getItemsInStore();
        for(int i = (page-1)*9; i < page*9; i++) {
            if(i < store.getNumberOfItemsInStore())
            {
                MediaStore cell = new MediaStore(medias.get(i));
                center.add(cell);
            } else {
                break;
            }
        }
        return center;
    }

    public class MediaStore extends JPanel {
        private Media media;

        public Media getMedia() {
            return media;
        }
        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);
            JLabel category = new JLabel(media.getCategory());
            title.setFont(new Font(category.getFont().getName(), Font.PLAIN, 18));
            category.setAlignmentX(CENTER_ALIGNMENT);
            JLabel cost = new JLabel(media.getCost() + "$");
            title.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            JButton btnAddToCart = new JButton("Add to cart");
            btnAddToCart.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cart.addItem(media);
                }
            });
            
            container.add(btnAddToCart);
            if (media instanceof Playable)
                container.add(new JButton("Play"));

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(category);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        this.itemPage = 1;
        this.content = createCenter(itemPage);
        this.cp = getContentPane();
        this.cp.setLayout(new BorderLayout());
        this.cp.add(createNorth(), BorderLayout.NORTH);
        this.cp.add(this.content, BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(960, 720);
    }
}
