package controller;

import model.Food;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodFileInfor {

    public static List<Food> menuItemsFood = new ArrayList<>();

    // Phương thức đọc menu đồ ăn từ file
    public static List<Food> readMenuFoodFromFile(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Mỗi dòng trong file sẽ chứa thông tin về một món ăn, phân tách bằng dấu phẩy
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String type = parts[2].trim();  // Giả sử type là loại món ăn (ví dụ: appetizer, main course, etc.)
                    double price = Double.parseDouble(parts[3].trim());
                    Food item = new Food(id, name, price);  // Khởi tạo đối tượng Food
                    menuItemsFood.add(item);  // Thêm món ăn vào danh sách
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayMenuFood(menuItemsFood);  // Hiển thị menu đồ ăn
        return menuItemsFood;
    }

    // Phương thức hiển thị menu đồ ăn
    public static void displayMenuFood(List<Food> menuItemsFood) {
        System.out.println("=========== Food Menu ===========");
        for (Food itemfood : menuItemsFood) {
            System.out.println(itemfood.toString());  // In ra thông tin của mỗi món ăn
        }
        System.out.println("=================================");
    }
}
