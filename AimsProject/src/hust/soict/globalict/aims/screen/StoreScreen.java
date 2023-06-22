package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javafx.application.Platform;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    private int itemPage;
    private int maxItemPage;

    private CartScreen cartScreen;
    private AddItemScreen addItemScreen;

    private JLabel page;
    private JButton prePage;
    private JButton nextPage;
    private Container cp;
    private JPanel content;

    public JLabel getPage() {
        return page;
    }

    public JButton getNextPageBtn() {
        return nextPage;
    }

    public void setCartScreen(CartScreen cartScreen) {
        this.cartScreen = cartScreen;
    }

    public void setAddItemScreen(AddItemScreen addItemScreen) {
        this.addItemScreen = addItemScreen;
    }

    public int getMaxItemPage() {
        return maxItemPage;
    }

    public void setMaxItemPage() {
        this.maxItemPage = this.store.getNumberOfItemsInStore() / 9 + 
                            (this.store.getNumberOfItemsInStore() % 9 == 0 && store.getNumberOfItemsInStore() > 0 ? 0 : 1);
    }

    public JPanel getContentPanel() {
        return content;
    }

    public void setContentPanel() {
        createCenter(itemPage);
    }
    public int getItemPage() {
        return itemPage;
    }

    public Cart getCart() {
        return cart;
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
        JButton btnViewCart = new JButton("View Cart");
        btnViewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    cartScreen.setVisible(true);
                    setVisible(false);
                } catch (Exception error) {
                    cartScreen = new CartScreen(cart);
                    cartScreen.setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnViewCart.setPreferredSize(new Dimension(100, 50));
        btnViewCart.setMaximumSize (new Dimension(100, 50));
        btnViewCart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cartScreen.setVisible(true);
                }
            });
            
        page = new JLabel("Page 1/" + getMaxItemPage());
        prePage = new JButton("<");
        nextPage = new JButton(">");
        if(itemPage == 1)
            prePage.setEnabled(false);
        else
            prePage.setEnabled(true);
        if(itemPage == getMaxItemPage())
            nextPage.setEnabled(false);
        else
            nextPage.setEnabled(true);
        prePage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemPage -= 1;
                page.setText("Page " + itemPage +"/"  + getMaxItemPage());
                if(itemPage == 1)
                    prePage.setEnabled(false);
                if(itemPage <= store.getNumberOfItemsInStore()/9)
                    nextPage.setEnabled(true);
                resetContentCenter();
            }
        });

        nextPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                itemPage += 1;
                page.setText("Page " + itemPage +"/" + getMaxItemPage());
                nextPage.setEnabled(true);
                if(itemPage == getMaxItemPage())
                    nextPage.setEnabled(false);
                if(itemPage > 1)
                    prePage.setEnabled(true);
                resetContentCenter();;
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

    public void createCenter(int page) {  
        content = new JPanel();
        content.setLayout(new GridLayout(3, 3, 2, 2));

        for(int i = (page-1)*9; i < page*9; i++) {
            if(i < store.getNumberOfItemsInStore())
            {
                MediaStore cell = new MediaStore(store.getItemsInStore().get(i));
                content.add(cell);
            } else {
                break;
            }
        }
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
                    Platform.runLater(() -> {
                        cartScreen.getCartScreenController().setTotalPayText();
                    });
                }
            });
            
            container.add(btnAddToCart);
            if (media instanceof Playable) {
                JButton btnPlay = new JButton("Play");
                btnPlay.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        media.play();
                    }
                    
                });
                container.add(btnPlay);
            }

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
        setMaxItemPage();
        this.itemPage = 1;
        createCenter(itemPage);
        this.cp = getContentPane();
        this.cp.setLayout(new BorderLayout());
        this.cp.add(createNorth(), BorderLayout.NORTH);
        this.cp.add(this.content, BorderLayout.CENTER);
        setTitle("Store");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void  resetContentCenter() {
        cp.remove(content);
        createCenter(itemPage);
        cp.add(content, BorderLayout.CENTER);
        cp.revalidate();
        cp.repaint();
    }
}
