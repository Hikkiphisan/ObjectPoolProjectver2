package controller;

import model.Candidate_forthisJob;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterbyRegex {


    // Phương thức lọc ứng viên có trên 1 năm kinh nghiệm và có chứng chỉ IELTS hoặc TOEIC
    public static List<Candidate_forthisJob> filterCandidates(List<Candidate_forthisJob> candidates) {
        List<Candidate_forthisJob> filteredCandidates = new ArrayList<>();

        // Biểu thức chính quy để tìm chứng chỉ IELTS hoặc TOEIC
        Pattern pattern = Pattern.compile("(IELTS\\s*\\d+\\.\\d+)|(TOEIC\\s*\\d+)", Pattern.CASE_INSENSITIVE);

        for (Candidate_forthisJob candidate : candidates) {
            String experience = candidate.getExperiences(); // Cột kinh nghiệm
            String certificates = candidate.getCertifications(); // Cột chứng chỉ

            // Kiểm tra nếu ứng viên có hơn 1 năm kinh nghiệm
            if (experience.matches(".*(3|4|5) năm.*")) {
                // Sử dụng regex để kiểm tra chứng chỉ IELTS hoặc TOEIC
                Matcher matcher = pattern.matcher(certificates);
                if (matcher.find()) {
                    filteredCandidates.add(candidate);
                }
            }
        }


        // Phương thức in kết quả sau khi lọc
        for (Candidate_forthisJob candidate : filteredCandidates) {
            System.out.println(candidate.toString());
        }

        return filteredCandidates;


    }


}
