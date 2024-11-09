package controller;

import java.util.List;

public class DisplayDataFromFileTxt {
    // Phương thức hiển thị dữ liệu đã đọc từ file
    public static void displayDataFromFileTxt(List<String> clientNames, List<String> drinkNames, List<String> moneyNames) {
        for (int i = 0; i < clientNames.size(); i++) {
            String clientName = clientNames.get(i);
            String drinkName = drinkNames.get(i);
            String moneyName = moneyNames.get(i);

            System.out.printf("Khách hàng: %-20s | Đồ uống: %-20s | Giá tiền: %-10s%n", clientName, drinkName, moneyName);
        }
    }
}
