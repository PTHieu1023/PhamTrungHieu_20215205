public class DigitalVideoDisc {
    
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    //Getters
    public String getTitle(){
        return title;
    }
    public String getCategory(){
        return category;
    }
    public String getDirector(){
        return director;
    }
    public int getLength(){
        return length;
    }
    public float getCost(){
        return cost;
    }

    //Setters
    public void setTitle(String title){
        this.title = title;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setCost(float cost){
        this.cost = cost;
    }

    //Build Contructors

    public DigitalVideoDisc(String title){
        setTitle(title);
    }

    public DigitalVideoDisc(String category, String title, float cost){
        setCategory(category);
        setTitle(title);
        setCost(cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost){
        setDirector(director);
        setCategory(category);
        setTitle(title);
        setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
    }
}
