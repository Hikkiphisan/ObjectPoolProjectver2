package model;

public class Food extends Product{
    private String size;
    private String toping;

    public Food(String id, String name, double price, String size, String toping) {
        super(Integer.parseInt(id), name, price);
        this.size = size;
        this.toping = toping;
    }
    public Food(String id, String name, Double price) {
        super(Integer.parseInt(id), name, price);
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
        return "\n✧･ﾟ: *✧･ﾟ:*  🍲 THỰC ĐƠN ĐỒ ĂN  *:･ﾟ✧*:･ﾟ✧\n" +
                "┌───────────── •✧✧• ─────────────┐\n" +
                "│  🍲 ID    : " + id + "\n" +
                "│  🍲 Tên món  : '" + name + "'\n" +
                "│  💲 Giá tiền : $" + String.format("%.2f", price) + "\n" +
                "└───────────── •✧✧• ─────────────┘\n";
    }
}
