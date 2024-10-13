package models;

public class Internship extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public Internship() {
        super();
    }

    public Internship(String candidateId, String firstName, String lastName, int yearOfBirth,
            String address, String phone, String email, int candidateType,
            String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, yearOfBirth, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getName() {
        return super.getFirstName() + super.getLastName();
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
