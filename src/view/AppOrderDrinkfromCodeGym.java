package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.DisplayDataFromFileTxt;
import model.ClientThread;
import service.WaiterPool;
import controller.ReadOrderRequestsDataFromFileTxt;
import controller.PrintInvoiceToTxt;

public class AppOrderDrinkfromCodeGym {
    public static final int NUM_OF_CLIENT = 7;                                                 // số lượng client tối đa được vào cửa tiệm để gọi món

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaiterPool waiterPool = new WaiterPool();


        List<String> clientNames = new ArrayList<>();
        List<String> drinkNames = new ArrayList<>();
        List<String> moneyNames = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("========= MENU =========");
            System.out.println("1. Đọc dữ liệu đơn hàng từ file");
            System.out.println("2. Tạo và chạy luồng cho khách hàng");
            System.out.println("3. In hóa đơn cho khách hàng");
            System.out.println("4. Thoát chương trình");
            System.out.print("Chọn một tùy chọn (1-4): ");


            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng mới để bỏ qua kí tự Enter


            switch (choice) {
                case 1:
                    // Đọc thông tin khách hàng từ file gọi món
                    System.out.println("-----------------------------------\n**Giải thích quá trình**: \n Đang đọc dữ liệu từ file văn bản, chứ không phải là file nhị phân, \n Đang vận dụng regex để tìm kiếm, chỉ lấy ra những thông tin cần thiết của khách hàng trong cái file văn bản rất nhiều thông tin đó.\n-----------------------------------\n");
                    System.out.println("Đang đọc file, xin vui lòng đợi trong giây lát...");


                    // Quá trình "chờ ảo" (fake waiting)
                    try {
                        Thread.sleep(12000); // Chờ trong 12 giây (12000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();  // Xử lý nếu gặp lỗi khi ngủ
                    }


                    ReadOrderRequestsDataFromFileTxt.readOrderRequestsDataFromFileTxt(clientNames, drinkNames, moneyNames);
                    System.out.println("Dữ liệu đã được đọc xong!");
                    break;
                case 2:
                    // Hiển thị dữ liệu đã đọc từ file
                    System.out.println("Dữ liệu đã đọc từ file văn bản:");
                    DisplayDataFromFileTxt.displayDataFromFileTxt(clientNames, drinkNames, moneyNames);
                    break;
                case 3:
                    // Tạo và chạy thread cho từng khách hàng
                    System.out.println("Đang tạo và chạy luồng cho khách hàng...");
                    for (int i = 0; i < NUM_OF_CLIENT; i++) {
                        String clientName = clientNames.get(i);
                        String drinkName = drinkNames.get(i);
                        String moneyName = moneyNames.get(i);

                        Runnable client = new ClientThread(waiterPool, clientName, drinkName, moneyName);
                        Thread thread = new Thread(client);
                        thread.start();

                    }
                    break;
                case 4:
                    // In hóa đơn riêng lẻ cho từng khách hàng
                    for (int i = 0; i < NUM_OF_CLIENT; i++) {
                        String clientName = clientNames.get(i);
                        String drinkName = drinkNames.get(i);
                        String moneyName = moneyNames.get(i);
                        PrintInvoiceToTxt.printInvoiceToTxt(clientName, drinkName, moneyName);

                    }
                    break;
                case 5:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình...");
                    running = false;
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }









        }
        scanner.close();  // Đóng Scanner khi kết thúc
    }
}

