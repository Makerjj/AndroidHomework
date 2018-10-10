package es.source.code.activity;

public class Food {
    private String name;
    private double price;
    private  int imageId;
    private  int id;


    public  Food(String name, double price, int imageId, int id){
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageId() { return imageId; }

    public int getId() {return id;}
}
