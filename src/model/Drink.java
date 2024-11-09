package model;

public class Drink extends Product {
    private String size;

    // Constructor
    public Drink(int id, String name, double price, boolean size) {
        super(id, name, price);  // Call the parent class constructor
        this.size = this.size;
    }

    // Getter and Setter for isAlcoholic
    public String isSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isAlcoholic=" + size +
                '}';
    }
}