import java.util.Comparator;

public class Media {
    private static int nbItems = 0;
    private int id = 0;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatoebyCostTitle();
    
    //Getter
    public int getNbItem() {
        return nbItems;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    //Setters
    public void incItem() {
        nbItems++;
    }
    public void setId() {
        this.id = nbItems;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    
    //Matching methods
    boolean isMatch(int id)
    {
        return getId() == id;
    }

    boolean isMatch(String title)
    {
        return getTitle() == title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    public void play() {
        if (this instanceof Book) {
            System.out.println("Play is not available for \"Book\" items");
        }
        if (this instanceof DigitalVideoDisc) {
            DigitalVideoDisc obj = (DigitalVideoDisc) this;
            obj.play();
        }
        if (this instanceof CompactDisc) {
            CompactDisc obj = (CompactDisc) this;
            obj.play();
        }
    }

}
