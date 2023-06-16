package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
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

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateMenu = new JMenu("Update Store");
        updateMenu.add(new JMenuItem("Add Book"));
        updateMenu.add(new JMenuItem("Add CD"));
        updateMenu.add(new JMenuItem("Add DVD"));

        menu.add(updateMenu);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("ViewCart"));

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

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize (new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {  
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> medias = store.getItemsInStore();
        for(int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(medias.get(i));
            center.add(cell); 
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

            JLabel cost = new JLabel("" + media.getCost() + "$");
            title.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            container.add(new JButton("Add to cart"));
            if (media instanceof Playable)
                container.add(new JButton("Play"));

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
}