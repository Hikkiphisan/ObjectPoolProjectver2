package controller;

import model.Drink;

import java.awt.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodAndDrinkFileInfor {
    public static List<Drink> readMenuDrinkFromFile(String filePath) {
        List<Drink> menuItemsDrink = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Mỗi dòng trong file sẽ chứa thông tin về một món ăn hoặc đồ uống, phân tách bằng dấu phẩy
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String size = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    Drink item = new Drink(id, name, size, price);
                    menuItemsDrink.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        displayMenuDrink(menuItemsDrink);
        return menuItemsDrink;

    }
    // Phương thức hiển thị menu
    public static void displayMenuDrink(List<Drink> menuItemsDrink) {
        System.out.println("=========== Menu ===========");
        for (Drink itemdrink : menuItemsDrink) {
            System.out.println(itemdrink);
        }
        System.out.println("=============================");
    }

}
