public class Media {
    private static int nbItems = 0;
    private int id = 0;
    private String title;
    private String category;
    private float cost;
    
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
}
