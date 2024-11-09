package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintInvoiceToTxt {
    public static void printInvoiceToTxt(String clientName, String drinkName, String moneyName) {

            // Tên file hóa đơn cho từng khách hàng
            String fileName = String.format("D:\\CodeGym\\Module 2\\ObjectPoolExample-0beea55077ca17fe958735feb1a9ba178dcaffd1\\ObjectPool\\src\\Hoá đơn của vị khách %s.txt", clientName);

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.printf("%n%-30s%-20s%n", "========== HÓA ĐƠN KHÁCH HÀNG GỌI ĐỒ HIGHLAND NGÀY 11/8/2024 ==========", "");
                writer.printf("| %-30s | %-30s |%n", "Tên khách hàng", clientName);
                writer.printf("| %-30s | %-30s |%n", "Đồ uống", drinkName);
                writer.printf("| %-30s | %-30s |%n", "Giá tiền", moneyName);
                writer.printf("%-30s%-20s%n", "=======================================================", "");
            } catch (IOException e) {
                e.printStackTrace();
            }





    }
    }

