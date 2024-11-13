package controller;

import java.io.*;

public class FoodAndDrinkFileHandler {

    // Phương thức thêm món mới vào file
    public static void addDishToFile(String dishName, String price, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            int newId = generateNewId(filePath);  // Sinh id mới cho món ăn/đồ uống
            String newEntry = newId + "," + dishName + "," + price;
            writer.write(newEntry);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int generateNewId(String filePath) {
        int lastId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Kiểm tra nếu dòng không rỗng và chứa ít nhất 2 phần tử
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    // Kiểm tra nếu phần tử đầu tiên có thể chuyển đổi thành số
                    try {
                        int currentId = Integer.parseInt(parts[0].trim());
                        if (currentId > lastId) {
                            lastId = currentId;
                        }
                    } catch (NumberFormatException e) {
                        // Nếu không thể chuyển đổi, bỏ qua dòng này và tiếp tục
                        System.err.println("Dòng dữ liệu không hợp lệ: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId + 1;  // Tăng id lên 1
    }


    /*
    // Phương thức sinh id mới cho món
    private static int generateNewId(String filePath) {
        int lastId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int currentId = Integer.parseInt(parts[0].trim());
                if (currentId > lastId) {
                    lastId = currentId;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastId + 1;  // Tăng id lên 1
    }


     */
}
