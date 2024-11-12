package view;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import accountLogin.AdminLogin;
import accountLogin.AdminMenu;
import accountLogin.CustomerLogin;
import accountLogin.CustomerMenu;
import controller.*;
import model.Candidate_forthisJob;
import model.ClientThread;
import model.Manager;
import service.WaiterPool;



public class AppOrderDrinkfromCodeGym {
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





    public static void main(String[] args) {


        // Đăng nhập
        Scanner scanner = null;
        scanner = new Scanner(System.in);

        // Mở menu chính để chọn đăng nhập
        System.out.println("======= APP CODEGYM COFFEE =======");
        System.out.println("1. Đăng nhập Admin");
        System.out.println("2. Đăng nhập Khách hàng");
        System.out.print("Chọn một tùy chọn (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        if (choice == 1) {
            // Đăng nhập Admin
            System.out.print("Nhập tên đăng nhập Admin: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Nhập mật khẩu Admin: ");
            String adminPassword = scanner.nextLine();

            AdminLogin adminLogin = new AdminLogin(adminUsername, adminPassword);
            if (adminLogin.login()) {
                System.out.println("Đăng nhập Admin thành công!");
                System.out.println("Đang tải dữ liệu để chạy ứng dụng....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Manager manager =new Manager("1", "Nguyễn Khánh Tùng");
                System.out.println("Đăng nhập thành công!");
                System.out.println("\u001B[31mQuản lý [" + manager.getName() + "] đang sử dụng app!\u001B[0m");
                AdminMenu.showAdminMenu(scanner);  // Hiển thị menu của Admin



            } else {
                System.out.println("Đăng nhập thất bại. Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        } else if (choice == 2) {
            // Đăng nhập Khách hàng
            System.out.print("Nhập tên đăng nhập Khách hàng: ");
            String customerUsername = scanner.nextLine();
            System.out.print("Nhập mật khẩu Khách hàng: ");
            String customerPassword = scanner.nextLine();



            CustomerLogin customerLogin = new CustomerLogin(customerUsername, customerPassword);
            if (customerLogin.login()) {
                System.out.println("Đăng nhập khách hàng thành công!");
                CustomerMenu.showCustomerMenu(scanner);  // Hiển thị thông báo cho khách hàng
            } else {
                System.out.println("Đăng nhập thất bại. Tên đăng nhập hoặc mật khẩu không đúng.");
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }

        scanner.close();  // Đóng scanner khi kết thúc
    }
}






