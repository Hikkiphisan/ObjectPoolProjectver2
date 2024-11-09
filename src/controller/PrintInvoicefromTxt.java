package controller;

import model.ClientThread;
import service.WaiterPool;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintInvoicefromTxt {
    public static void printInvoicefromTxt(List<String> clientNames, List<String> drinkNames, List<String> moneyNames,int NUM_OF_CLIENT, WaiterPool waiterPool) {
        for (int i = 0; i < NUM_OF_CLIENT; i++) {





            String clientName = clientNames.get(i);
            String drinkName = drinkNames.get(i);
            String money = moneyNames.get(i);

            // Tên file hóa đơn cho từng khách hàng
            String fileName = String.format("D:\\CodeGym\\Module 2\\ObjectPoolExample-0beea55077ca17fe958735feb1a9ba178dcaffd1\\ObjectPool\\src\\Hoá đơn của vị khách %s.txt", clientName);

            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                writer.printf("%n%-30s%-20s%n", "========== HÓA ĐƠN KHÁCH HÀNG GỌI ĐỒ HIGHLAND NGÀY 11/8/2024 ==========", "");
                writer.printf("| %-30s | %-30s |%n", "Tên khách hàng", clientName);
                writer.printf("| %-30s | %-30s |%n", "Đồ uống", drinkName);
                writer.printf("| %-30s | %-30s |%n", "Giá tiền", money);
                writer.printf("%-30s%-20s%n", "=======================================================", "");
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Tạo và chạy thread cho từng khách hàng
            Runnable client = new ClientThread(waiterPool, clientName, drinkName, money);
            Thread thread = new Thread(client);
            thread.start();
        }


    }
    }

