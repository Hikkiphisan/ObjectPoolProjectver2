package controller;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReaderRevenue {
    // Phương thức đọc tổng doanh thu từ file nhị phân
    public static double readRevenueFromBinaryFile(String fileName) {
        double totalRevenue = 0.0;

        // Đọc file nhị phân
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            totalRevenue = dis.readDouble();
            System.out.printf("Tổng doanh thu đã đọc từ file nhị phân: %.2f%n", totalRevenue);
        } catch (IOException e) {
            System.err.println("Lỗi đọc file nhị phân: " + e.getMessage());
        }

        return totalRevenue;
    }
}
