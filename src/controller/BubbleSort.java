package controller;

import model.Candidate_forthisJob;

import java.util.List;

public class BubbleSort {




    public static List<Candidate_forthisJob> bubbleSortByExperience(List<Candidate_forthisJob> filteredCandidates ) {


        int n = filteredCandidates.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Lấy số kinh nghiệm của các ứng viên
                int experienceJ = filteredCandidates.get(j).getExperienceAsInt();
                int experience_J_cong_1 = filteredCandidates.get(j + 1).getExperienceAsInt();

                // Đổi chỗ nếu ứng viên hiện tại có kinh nghiệm ít hơn ứng viên kế tiếp
                if (experienceJ < experience_J_cong_1) {
                    Candidate_forthisJob temp = filteredCandidates.get(j);
                    filteredCandidates.set(j, filteredCandidates.get(j + 1));
                    filteredCandidates.set(j + 1, temp);
                }
            }
        }
        

        // In kết quả sau khi lọc và sắp xếp
        int priority = 1; // Chỉ số ưu tiên
        for (Candidate_forthisJob candidate : filteredCandidates) {
            candidate.setPriority(priority); // Cập nhật lại thứ tự ưu tiên
            System.out.println(candidate.toEditedString()); // In thông tin ứng viên
            priority++; // Tăng thứ tự ưu tiên cho ứng viên tiếp theo
        }




       return filteredCandidates;
    }
}
