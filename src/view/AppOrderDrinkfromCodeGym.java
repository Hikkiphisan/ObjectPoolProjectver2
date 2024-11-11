package view;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.*;
import model.Candidate_forthisJob;
import model.ClientThread;
import service.WaiterPool;

public class AppOrderDrinkfromCodeGym {
    public static final int NUM_OF_CLIENT = 7;                                                 // số lượng client tối đa được vào cửa tiệm để gọi món
    static List<Candidate_forthisJob> candidates;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaiterPool waiterPool = new WaiterPool();


        List<String> clientNames = new ArrayList<>();
        List<String> drinkNames = new ArrayList<>();
        List<String> moneyNames = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("========= MENU =========");
            System.out.println("1. Đọc đơn ứng tuyển");
            System.out.println("2. Cơ chế lọc đơn ứng tuyển tự động (Applicant Tracking Systems - ATS) ");
            System.out.println("3. Idea: Dùng thuât toán sắp xếp để sắp xếp theo chế độ ưu tiên tuyển dụng, ai có tiêu chí cao hơn sẽ xếp hàng đầu.");
            System.out.println("3.5. Idea: Chọn được ứng viên bằng cách nhập chỉ số rồi thêm vào danh sách nhân viên");
            System.out.println("4. Đọc dữ liệu đơn hàng từ file");
            System.out.println("5. Hiển thị dữ liệu đã được đọc từ file văn bản");
            System.out.println("6. Tạo và chạy luồng cho khách hàng");
            System.out.println("7. In hóa đơn cho khách hàng");
            System.out.println("8. Thoát chương trình");
            System.out.print("Chọn một tùy chọn (1-4): ");


            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng mới để bỏ qua kí tự Enter


            switch (choice) {
                case 1:

                    ReadExcelFile readExcel = new ReadExcelFile();
                    candidates = readExcel.readExcelFile();
                    break;
                case 2:
                    System.out.println("=================================================================================================================");
                    System.out.println("LỌC HỒ SƠ ỨNG VIÊN TỰ ĐỘNG, CHỈ LẤY NHỮNG ỨNG VIÊN CÓ 3 NĂM KINH NGHIỆM TRỞ LÊN, CÓ CHỨNG CHỈ IELTS, TOEIC, ...");
                    System.out.println("=================================================================================================================");
                    FilterbyRegex.filterCandidates(candidates);
                    break;
                case 3:
                    break;
                case 4:
                    // Đọc thông tin khách hàng từ file gọi món
                    System.out.println("-----------------------------------\n**Giải thích quá trình**: \n Đang đọc dữ liệu từ file văn bản, chứ không phải là file nhị phân, \n Đang vận dụng regex để tìm kiếm, chỉ lấy ra những thông tin cần thiết của khách hàng trong cái file văn bản rất nhiều thông tin đó.\n-----------------------------------\n");
                    System.out.println("Đang đọc file, xin vui lòng đợi trong giây lát...");


                    // Quá trình "chờ ảo" (fake waiting)
                    try {
                        Thread.sleep(2000); // Chờ trong 12 giây (12000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();  // Xử lý nếu gặp lỗi khi ngủ
                    }


                    ReadOrderRequestsDataFromFileTxt.readOrderRequestsDataFromFileTxt(clientNames, drinkNames, moneyNames);
                    System.out.println("Dữ liệu đã được đọc xong!");
                    break;
                case 5:

                    // Hiển thị dữ liệu đã đọc từ file

                    System.out.println("Đang tải dữ liệu để hiện thị lên hệ thống....");

                    // Quá trình "chờ ảo" (fake waiting)
                    try {
                        Thread.sleep(2000); // Chờ trong 12 giây (12000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();  // Xử lý nếu gặp lỗi khi ngủ
                    }



                    System.out.println("Dữ liệu đã đọc từ file văn bản:");
                    DisplayDataFromFileTxt.displayDataFromFileTxt(clientNames, drinkNames, moneyNames);
                    break;
                case 6:

                    System.out.println("======================================================================================");
                    System.out.println("DANH SÁCH NHỮNG KHÁCH HÀNG ĐANG GỌI MÓN HIỆN TẠI, TRIỆU TẬP NHÂN VIÊN ĐỂ PHỤC VỤ HỌ!!");
                    System.out.println("======================================================================================");
                    // Tạo và chạy thread cho từng khách hàng
                    List<Thread> threads = new ArrayList<>(); // Tạo danh sách để lưu trữ các luồng khách hàng
                    for (int i = 0; i < NUM_OF_CLIENT; i++) {
                        String clientName = clientNames.get(i);
                        String drinkName = drinkNames.get(i);
                        String moneyName = moneyNames.get(i);



                        Runnable client = new ClientThread(waiterPool, clientName, drinkName, moneyName);
                        Thread thread = new Thread(client);
                        threads.add(thread); // Thêm luồng vào danh sách
                        thread.start();

                    }

                    WaiterPool.waitingForWaiterToArriveStatus();

                    // Chờ cho tất cả các luồng hoàn thành trước khi tiếp tục
                    for (Thread thread : threads) {
                        try {
                            thread.join(); // Đợi luồng hoàn tất
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("#############################################################################################");
                    System.out.println("TẤT CẢ CÁC LUỒNG KHÁCH HÀNG HIỆN TẠI ĐÃ ĐƯỢC PHỤC VỤ, HÃY IN HÓA ĐƠN ĐỂ YÊU CẦU THANH TOÁN. #");
                    System.out.println("#############################################################################################");

                    break;


                case 7:

                    System.out.println("Đang xuất hoá đơn, vui lòng chờ trong giây lát... \n");



                    // In hóa đơn riêng lẻ cho từng khách hàng
                    for (int i = 0; i < NUM_OF_CLIENT; i++) {
                        String clientName = clientNames.get(i);
                        String drinkName = drinkNames.get(i);
                        String moneyName = moneyNames.get(i);
                        PrintInvoiceToTxt.printInvoiceToTxt(clientName, drinkName, moneyName);

                    }

                    // Quá trình "chờ ảo" (fake waiting)
                    try {
                        Thread.sleep(2000); // Chờ trong 12 giây (12000 milliseconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();  // Xử lý nếu gặp lỗi khi ngủ
                    }


                    System.out.println("Đã in xong hoá đơn, hãy đưa cho khách hàng để yêu cầu khách thanh toán!!!");


                    // Thoát chương trình

                    running = false;    // hàm khiến chương trình chạy mãi không ngừng để hiện lại menu
                    break;
                case 8:   //da thoát chương trình, phuong thuc nay khong cần thiết
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

