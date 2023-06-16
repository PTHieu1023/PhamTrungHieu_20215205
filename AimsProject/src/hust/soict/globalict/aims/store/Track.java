package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.media.Playable;

public class Track implements Playable{
    private String title;
    private int length;
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public Track(String title) {
        this.title = title;
    }
    
    @Override
    public void play(){
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Track other = (Track) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (length != other.length)
            return false;
        return true;
    }

    
}