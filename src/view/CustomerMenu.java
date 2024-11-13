package view;

import controller.DrinkFileLastLine;
import model.Candidate_forthisJob;
import model.ClientThread;
import observer.CustomerObserver;
import observer.Subject;
import service.WaiterPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu implements CustomerObserver {


    public static final int NUM_OF_CLIENT = 7;                                                 // số lượng client tối đa được vào cửa tiệm để gọi món
    static List<Candidate_forthisJob> candidates;
    static List<Candidate_forthisJob> filteredCandidates;          // candidate đã lọc
    static List<Candidate_forthisJob> sortedCandidates;          // candidate đã sapxep theo muc do ưu tiên
    public static Candidate_forthisJob selectedCandidate;
    public static String[] nameWaiter = {
            "Trần Minh Trí", "Phí Hữu Lộc", "Nguyễn Đức Thắng", "Lê Tuấn Dũng", "Đào Văn Huy Hưng",
            "Hoàng Minh Nhật", "Thành"
    };

    public static List<String> nameWaiters = List.of(new String[]{
            "Trần Minh Trí", "Phí Hữu Lộc", "Nguyễn Đức Thắng", "Lê Tuấn Dũng", "Đào Văn Huy Hưng",
            "Hoàng Minh Nhật", "Thành"});





    public static void showCustomerMenu(Scanner scanner) {


        boolean running = true;

        while (running) {
            System.out.println("========= TÀI KHOẢN CUSTOMER: CẬP NHẬT THÔNG TIN VÀ ĐẶT MÓN ONLINE =========");
            System.out.println("1. Nhận thông báo đồ uống, đồ ăn mới");
            System.out.println("2. Đặt món <chưa xong> ");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn một tùy chọn (1-4): ");


            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng mới để bỏ qua kí tự Enter


            switch (choice) {
                case 0:
                    break;

                case 1:
                    AdminMenu menuNotifier = new AdminMenu();
                    menuNotifier.addObserver(new CustomerMenu());
                    System.out.println("Bạn đã đăng ký nhận thông báo món mới.");
                    CustomerObserver customerObserver = new CustomerMenu();
                    String filePath = "D:\\CodeGym\\Module 2\\ObjectPoolExample-0beea55077ca17fe958735feb1a9ba178dcaffd1\\ObjectPool\\src\\resources\\DrinkMenuInforNEw.txt";
                    String newDrink = DrinkFileLastLine.getLastDrinkFromFile(filePath);     //hứng phần tử, phương pháp hữu hieu nhat
                    customerObserver.update(newDrink);
                    break;

            }

        }
    }






    @Override
    public void update(String newDrink) {
        System.out.println("==============================================================================");
        System.out.println("\033[0;31mThông báo: Đã có đồ uống mới: - " + newDrink + "! Hãy thử ngay!\033[0m");
        System.out.println("==============================================================================");

    }
}











