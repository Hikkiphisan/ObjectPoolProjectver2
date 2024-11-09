package model;

public class Food extends Product{
    private String size;
    private String toping;

    public Food(int id, String name, double price, String size, String toping) {
        super(id, name, price);
        this.size = size;
        this.toping = toping;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getToping() {
        return toping;
    }

    public void setToping(String toping) {
        this.toping = toping;
    }

    @Override
    public String toString() {
        return "Food{" +
                "size='" + size + '\'' +
                ", toping='" + toping + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
