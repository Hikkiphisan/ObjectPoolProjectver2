package controller;

import java.io.*;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.Candidate_forthisJob;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {


     public void readExcelFile() {
         // Đường dẫn đến file Excel cần truy cập
        Path filePath = Paths.get("D:\\CodeGym\\Module 2\\ObjectPoolExample-0beea55077ca17fe958735feb1a9ba178dcaffd1\\ObjectPool\\Job_Application_Coffee_Shop.xlsx");
         List<Candidate_forthisJob> candidates = new ArrayList<>();

        // Đọc file Excel
        try (FileInputStream fis = new FileInputStream(filePath.toFile());
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Lấy trang tính đầu tiên trong file
            Sheet sheet = workbook.getSheetAt(0);

            // Duyệt qua từng hàng trong trang tính, bỏ qua tiêu đề
            boolean isFirstRow = true;
            for (Row row : sheet) {
                if (isFirstRow) { // Skip the header row
                    isFirstRow = false;
                    continue;
                }
                // Lấy thông tin của các cột cần thiết
                Cell idCell = row.getCell(0);  // ID
                Cell nameCell = row.getCell(1);  // Họ tên
                Cell experienceCell = row.getCell(5);  // Kinh nghiệm làm việc
                Cell certificationCell = row.getCell(9);  // Chứng chỉ


                // Xử lý ID để loại bỏ ".0" nếu là số
                String id;
                if (idCell != null && idCell.getCellType() == CellType.NUMERIC) {
                    id = String.valueOf((int) idCell.getNumericCellValue());
                } else {
                    id = idCell != null ? idCell.toString() : "N/A";
                }



                // Kiểm tra và lấy giá trị của từng ô (nếu không có thì để trống)
//              String id = idCell != null ? idCell.toString() : "N/A";
                String name = nameCell != null ? nameCell.getStringCellValue() : "N/A";
                String experience = experienceCell != null ? experienceCell.getStringCellValue() : "N/A";
                String certifications = certificationCell != null ? certificationCell.getStringCellValue() : "N/A";


                // Tạo đối tượng Candidate và thêm vào danh sách
                Candidate_forthisJob candidate = new Candidate_forthisJob(id, name, experience, certifications);
                candidates.add(candidate);
            }

            // In ra thông tin của tất cả các ứng viên
            for (Candidate_forthisJob candidate : candidates) {
                System.out.println(candidate.toString());
            }





        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
     }
}