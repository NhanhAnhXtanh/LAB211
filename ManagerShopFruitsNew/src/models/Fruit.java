package models;

public class Fruit {
//    : Fruit Id, Fruit Name, Price, Quantity and Origin.

    private String fruitId;
    private String fruitName;
    private Double price;
    private int Quantity;
    private String Origin;

    public Fruit() {
    }

    public Fruit(String fruitId, String fruitName, Double price, int Quantity, String Origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.Quantity = Quantity;
        this.Origin = Origin;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    @Override
    public String toString() {
        String price = (int) getPrice() + "$";
        return String.format("%-15s%-13s%-10s\n", getFruitName(),
                getOrigin(), price);
    }

}
