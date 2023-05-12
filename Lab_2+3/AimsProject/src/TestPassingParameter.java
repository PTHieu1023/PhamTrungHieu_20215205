public class TestPassingParameter {

    public static void swapDVD(Object a, Object b){
        Object tmp = a;
        a = b;
        b = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTilte = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTilte);
    }

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swapDVD(jungleDVD, cinderellaDVD);

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    
}