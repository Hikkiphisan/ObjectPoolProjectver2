package model;

public class Drink extends Product {
    private String size;

    // Constructor
    public Drink(String id, String name, String size, double price) {
        super(Integer.parseInt(id), name, price);  // Call the parent class constructor
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "\n✧･ﾟ: *✧･ﾟ:*  🍹 THỰC ĐƠN ĐỒ UỐNG  *:･ﾟ✧*:･ﾟ✧\n" +
                "┌───────────── •✧✧• ─────────────┐\n" +
                "│  🍸 ID    : " + id + "\n" +
                "│  🍸 Tên món  : '" + name + "'\n" +
                "│  💲 Giá tiền : $" + String.format("%.2f", price) + "\n" +
                "│  📏 Kích cỡ  : '" + size + "'\n" +
                "└───────────── •✧✧• ─────────────┘\n";
    }
}