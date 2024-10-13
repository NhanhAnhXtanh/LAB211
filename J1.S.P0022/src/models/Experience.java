package models;

public class Experience extends Candidate {

    private int experienceYear;
    private String professionalSkil;

    public Experience() {
        super();
    }

    public Experience(String candidateId,
            String firstName, String lastName, int yearOfBirth, String address,
            String phone, String email, int candidateType, int experienceYear, String professionalSkil) {
        super(candidateId, firstName, lastName, yearOfBirth, address, phone, email, candidateType);
        this.experienceYear = experienceYear;
        this.professionalSkil = professionalSkil;
    }

    public String getName() {
        return super.getFirstName() + super.getLastName();
    }

    public int getExpInYear() {
        return experienceYear;
    }

    public void setExpInYear(int expInYear) {
        this.experienceYear = expInYear;
    }

    public String getProSkill() {
        return professionalSkil;
    }

    public void setProSkill(String proSkill) {
        this.professionalSkil = proSkill;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
