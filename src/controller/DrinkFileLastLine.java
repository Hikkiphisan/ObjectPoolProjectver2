package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DrinkFileLastLine {

        // Phương thức lấy đồ uống cuối cùng từ file
        public static String getLastDrinkFromFile(String filePath) {
            String lastLine = "";
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    lastLine = currentLine;  // Cập nhật dòng cuối mỗi khi đọc được dòng mới
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Phân tách các phần của dòng cuối cùng để lấy tên đồ uống
            if (!lastLine.isEmpty()) {
                String[] parts = lastLine.split(",");
                if (parts.length >= 2) {
                    return parts[1].trim();  // Trả về tên đồ uống
                }
            }
            return "Đồ uống không xác định";  // Trường hợp không đọc được đúng định dạng
        }
    }


