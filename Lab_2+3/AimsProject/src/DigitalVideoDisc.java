public class DigitalVideoDisc {
    private static int nbDigitalVideoDisc = 0;
    private int id;
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
    public int getId()
    {
        return id;
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
    private void setId()
    {
        this.id = nbDigitalVideoDisc;
    }
    //Build Contructors

    public DigitalVideoDisc(String title){
        setTitle(title);
        nbDigitalVideoDisc++;
        setId();
    }

    public DigitalVideoDisc(String title, String category, float cost){
        setCategory(category);
        setTitle(title);
        setCost(cost);
        nbDigitalVideoDisc++;
        setId();
    }

    public DigitalVideoDisc(String title, String category, String director, float cost){
        setDirector(director);
        setCategory(category);
        setTitle(title);
        setCost(cost);
        nbDigitalVideoDisc++;
        setId();
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
        nbDigitalVideoDisc++;
        setId();
    }

    public String toString()
    {
        String discInfo = getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$"; 
        return discInfo;
    }

    boolean isMatch(int id)
    {
        return getId() == id;
    }

    boolean isMatch(String title)
    {
        return getTitle() == title;
    }
}
