package work01;

public class Car {
    public String brand;
    private String model;
    String price;
    protected String color;

    public Car(){
    }

    public Car(String brand, String model, String price, String color){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}
