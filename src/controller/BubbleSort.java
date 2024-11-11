//package controller;
//
//import model.Candidate_forthisJob;
//
//import java.util.List;
//
//public class BubbleSort {
//
//
//
//
//    public static void bubbleSortByExperience(List<Candidate_forthisJob> candidates ) {
//
//
//        int n = candidates.size();
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                // Lấy số kinh nghiệm của các ứng viên
//                int experienceJ = candidates.getExperienceAsInt(candidates.get(j).getExperiences());
//                int experienceJPlus1 = candidates.getExperienceAsInt(candidates.get(j + 1).getExperiences());
//
//                // Đổi chỗ nếu ứng viên hiện tại có kinh nghiệm ít hơn ứng viên kế tiếp
//                if (experienceJ < experienceJPlus1) {
//                    Candidate_forthisJob temp = candidates.get(j);
//                    candidates.set(j, candidates.get(j + 1));
//                    candidates.set(j + 1, temp);
//                }
//            }
//        }
//    }
//}
