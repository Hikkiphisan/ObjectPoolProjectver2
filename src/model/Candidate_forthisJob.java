package model;

public class Candidate_forthisJob extends Person {
    public String experiences;
    public String certifications;


    public Candidate_forthisJob(String id, String name, String experiences, String certifications) {
        super(id, name);
        this.experiences = experiences;
        this.certifications = certifications;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    @Override
    public String toString() {
        return "Ứng viên có mã số " + id +
                ". Họ tên là" + name + "" +
                '}';
    }
}
