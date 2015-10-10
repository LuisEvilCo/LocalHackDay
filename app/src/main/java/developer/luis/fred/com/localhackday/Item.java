package developer.luis.fred.com.localhackday;

public class Item {

    int image;
    String name[];

    public Item(int image, String[] name) {
        super();
        this.image = image;
        this.name = name;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String[] getName() {
        return name;
    }
    public void setName(String[] name) {
        this.name = name;
    }

}