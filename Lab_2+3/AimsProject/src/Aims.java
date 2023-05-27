import java.util.Scanner;

public class Aims {
    static Scanner sc = new Scanner(System.in);
    static Cart cart = new Cart();
    static Store store = new Store();
    static Media currentItem;
    static boolean systemRunning = true;

    static String nextLine() {
        String s = sc.nextLine();
        if(s.isEmpty())
            return sc.nextLine();
        else
            return s;
    }

    private static void selectItem() {
        clearScreen();
        System.out.print("Enter title: ");
        String title = nextLine();
        currentItem = store.findByTitle(title);
    }

    private static void createItem() {
        clearScreen();
        System.out.print("Type of media (DVD - Book - CD): ");
        String type = nextLine();
        System.out.print("Title: ");
        String title = nextLine();
        System.out.print("Category: ");
        String category = nextLine();
        System.out.print("Cost: ");
        Float cost = sc.nextFloat();
        if(type.equals("DVD"))
            currentItem = new DigitalVideoDisc(title, category, cost);
        if(type.equals("Book"))
            currentItem = new Book(title, category, cost);
        if(type.equals("CD"))
            currentItem = new CompactDisc(title, category, cost);  
    }

    //Menu: Main
    public static void showMenu(){
        System.out.println("AIMS:");
        System.out.println("_____________________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("_____________________________");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    //Menu: Main -> 1
    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("_____________________________");
        System.out.println("1. See media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Exit");
        System.out.println("_____________________________");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    //Menu: Main -> 1 -> 1
    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("_____________________________");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("Please choose a number: 0-1-2");
    }

    //Exercure: Main -> 1 -> 1
    private static void showMediaDetail() {
        if(currentItem == null)
            System.out.println("Not found item");
        else
            System.out.println(currentItem.toString());
        mediaDetailsMenu();
        int chosen = sc.nextInt();
        switch (chosen) {
            case 0:
                viewStore();
                break;
            case 1:
                cart.addItem(currentItem);
                break;
            case 2:
                currentItem.play();
                break;
            default:
                break;
        }
    }

    //Execure : Main -> 1
    private static void viewStore() {
        clearScreen();
        store.showItems();
        storeMenu();
        int chosen = sc.nextInt();
        switch (chosen) {
            case 0:
                menu();
                break;
            case 1:
                selectItem();
                showMediaDetail();
                break;
            case 2:
                selectItem();
                cart.addItem(currentItem);
                break;
            case 3:
                selectItem();
                currentItem.play();
                break;
            case 4:
                seeCurrentCart();
                break;
            default:
                break;
        }
    }
    // Menu: Main -> 2
    public static void updateStoreMenu() {
        System.out.println("Option:");
        System.out.println("______________________________");
        System.out.println("1. Add a media");
        System.out.println("2. Remove media from store");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("please choose a number: 0-1-2");
    }

    // Exercure: Main -> 2
    private static void updateStore() {
        clearScreen();
        updateStoreMenu();
        int chosen = sc.nextInt();
        switch (chosen) {
            case 0:
                menu();
            case 1:
                createItem();
                store.addItem(currentItem);
                break;
            case 2:
                selectItem();
                store.removeItem(currentItem);
                break;
            default:
                updateStore();;
        }
    }

    // Menu: Main -> 3
    public static void cartMenu() {
        System.out.println("Option:");
        System.out.println("______________________________");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Exit");
        System.out.println("______________________________");
        System.out.println("please choose a number: 0-1-2-3-4-5");      
    }

    //Excercure:Main -> 3 -> 1
    private static void filterCart() {
        //Filter by id

        //Filter by title
        System.out.print("This function will available in future\nEnter 0 to go previous: ");
        sc.nextInt();
        seeCurrentCart();
    }

    //Excerure: Main ->3 -> 2
    private static void sortCart() {
        //Sort by title cost
        //Sort by cost title
        System.out.print("This function will available in future\nEnter 0 to go previous: ");
        sc.nextInt();
        seeCurrentCart();
    }

    // Exercure: Main -> 3 -> 5
    private static void placeOrder() {
        //enter information 
        //create order and clear cart
        System.out.print("This function will available in future\nEnter 0 to go previous: ");
        sc.nextInt();
        seeCurrentCart();
    }

    //Execure: Main -> 1 -> 4 || Main -> 3
    private static void seeCurrentCart() {
        clearScreen();
        cart.showItemsOrdered();
        cartMenu();
        int chosen = sc.nextInt();
        switch (chosen) {
            case 0:
                menu();
                break;
            case 1:
                filterCart();
                break;
            case 2:
                sortCart();
                break;
            case 3:
                selectItem();
                cart.removeItem(currentItem);
                break;
            case 4:
                selectItem();
                currentItem.play();
                break;
            case 5:
                placeOrder();
                break;
            default:
                seeCurrentCart();;
        }
    }

    public static void main(String[] args) {

        //Create and add some dvds to store
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addItem(dvd);
    
        dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addItem(dvd);

        dvd = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addItem(dvd);

        //Create and add some books to store
        Book book = new Book("The Alchemist", "Fiction, Self-help", "Fiction, Self-help", 14.99f);
        store.addItem(book);
        book = new Book("Sapiens: A Brief History of Humankind", "Non-fiction, History", "Yuval Noah Harari", 12.99f);
        store.addItem(book);
        book = new Book("Educated", "Memoir", "Tara Westover", 9.99f);
        store.addItem(book);

        //Create and add some cds to store
        CompactDisc cd = new CompactDisc("Rock Revolution", "Rock", 12.99f, "The Thunder Storm");
        Track track = new Track("High Voltage", 3);
        cd.addTrack(track);
        track = new Track("Guitar Mayhem", 7);
        cd.addTrack(track);
        track = new Track("Rock Anthem", 5);
        cd.addTrack(track);
        store.addItem(cd);

        cd = new CompactDisc("Smooth Jazz Serenade", "Jazz", 10.99f, "The Velvet Groove Quartet");
        track = new Track("Midnight Breeze");
        cd.addTrack(track);
        track = new Track("Satin Sheets", 2);
        cd.addTrack(track);
        track = new Track("Soulful Rendezvous", 4);
        cd.addTrack(track);
        store.addItem(cd);
        //User Interface
        clearScreen();
        while(systemRunning)
            menu();
    }


    private static void menu() {
        showMenu();
        int chosen = sc.nextInt();
        switch (chosen) {
            case 0:
                systemRunning = false;
                break;
            case 1:
                viewStore();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                seeCurrentCart();
                break;
            default:
                menu();
        }
    }

    private static void clearScreen() {
        // Clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}