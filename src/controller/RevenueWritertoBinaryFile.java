package controller;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RevenueWritertoBinaryFile {


        // Phương thức tính và ghi tổng doanh thu vào file nhị phân
        public static void writeRevenueToBinaryFile(List<String> moneyNames, String fileName) {
            double totalRevenue = 0.0;

            // Tính tổng doanh thu từ danh sách moneyNames
            for (String money : moneyNames) {
                try {
                    // Chuyển đổi từng phần tử từ chuỗi thành số thực và cộng vào tổng doanh thu
                    totalRevenue += Double.parseDouble(money.replace(".", "").replace(",", "."));
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi chuyển đổi giá tiền: " + money);
                }
            }

            // Ghi tổng doanh thu vào file nhị phân
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
                dos.writeDouble(totalRevenue);
                System.out.println("Đã ghi tổng doanh thu vào file nhị phân thành công để bảo mật thông tin.");
            } catch (IOException e) {
                System.err.println("Lỗi ghi file nhị phân: " + e.getMessage());
            }
        }
    }


