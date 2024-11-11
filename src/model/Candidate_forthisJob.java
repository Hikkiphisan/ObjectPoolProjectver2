package model;

public class Candidate_forthisJob extends Person {
    public String experiences;
    public String certifications;
    public int priority;

    public int getPriority() {
        return priority;
    }



    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Candidate_forthisJob(String id, String name, String experiences, String certifications) {
        super(id, name);
        this.experiences = experiences;
        this.certifications = certifications;
    }

    public String getNameCandidate() {
        return name;
    }


    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    // Phương thức để lấy số năm kinh nghiệm dưới dạng số nguyên
    public int getExperienceAsInt() {
        String experience = this.experiences.replaceAll("[^0-9]", ""); // Giữ lại các ký tự số
        return Integer.parseInt(experience); // Chuyển chuỗi thành số nguyên
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "Ứng viên có mã số [" + id + "]" +
                ". Họ tên là " + name + ", nguời này có " + experiences + " kinh nghiệm trong nghề và " + "có chứng chỉ: " + certifications;
    }


    public String toEditedString() {
        return "Hồ sơ xin việc của " + this.name + " được ưu tiên thứ " + this.priority + " vì có " +
                this.getExperienceAsInt() + " năm kinh nghiệm trong nghề và có chứng chí " + this.getCertifications()  ;

    }
    public String toStringApplied() {
        System.out.println("===================================");
        System.out.println("ĐANG TUYỂN DỤNG ỨNG VIÊN....:");
        System.out.println("===================================");


        try {
            Thread.sleep(3000); // Chờ trong 12 giây (12000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Xử lý nếu gặp lỗi khi ngủ
        }


        return "[" + this.name + "]";

    }

}
