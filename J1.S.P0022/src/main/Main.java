package main;

import ui.Menu;
import models.Candidate;
import models.Experience;
import models.Fresher;
import models.Internship;
import controller.ManagerCandidate;
import util.Validation;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        ManagerCandidate candidateList = new ManagerCandidate();
        Menu menu = new Menu();
        menu.addTitleMenu("CANDIDATE MANAGEMENT SYSTEM");
        menu.addOptionMenu("1. Experience");
        menu.addOptionMenu("2. Fresher");
        menu.addOptionMenu("3. Internship");
        menu.addOptionMenu("4. Searching");
        menu.addOptionMenu("5. Exit");
        int choice;
        while (true) {
            if (menu.isEmpty()) {
                System.err.println("No have option");
                break;
            }
            System.out.print(menu.toString());
            choice = Validation.getAnIntegerLimit("Enter an option: ", "Enter again ", 1, menu.size());
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    Candidate candidate = createCandidate(candidateList, choice);
                    if (candidate == null) {
                        break;
                    }
                    candidateList.addCandidate(candidate);
                    System.err.println("Add successfully");
                    break;
                case 4:
                    if (candidateList.isEmpty()) {
                        System.err.println("No have candidate");
                        break;
                    }
                    System.out.print(candidateList.displayCandidateList("===========EXPERIENCE CANDIDATE============",
                            "==========FRESHER CANDIDATE==============", "===========INTERN CANDIDATE=============="));
                    String name = Validation.getString("Enter Candidate Name: ", "Enter again [Srting]");
                    int type = Validation.getAnIntegerLimit("Enter type: ", "Enter again", 0, 2);
                    System.out.print(candidateList.displayCandidate(name, type));
                    break;
                case 5:
                    System.out.println("EXITED");
                    return;

            }
        }
    }

    private static Candidate createCandidate(ManagerCandidate candidateList, int type) {
        String id = Validation.getValidString("Enter Candidate id: ", "Enter again [HEXXXXX || HAXXXXXX || HSXXXXXX] X is number: ", "H[EAS]\\d{6}");
        if (candidateList.checkIdExist(id)) {
            System.err.println("Candidate id exists");
            return null;
        }

        String firstName = Validation.getString("Enter First Name: ", "Enter again [String]");
        String lastName = Validation.getString("Enter Last Name: ", "Enter again [String]");
        int yearOfBirth = Validation.getAnIntegerLimit("Enter year of birth: ", "Enter again", 1900, LocalDate.now().getYear());
        String address = Validation.getString("Enter Candidate address: ", "Enter again [String]");
        String phone = Validation.getValidString("Enter phone: ", "Enter again [10 number]", "\\d{10}");
        String email = Validation.getValidString("Enter email: ", "Format of email is <account name>@<domain>.", "^[A-Za-z0-9+._-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$");

        switch (type) {
            case 1: // Experience
                int experienceYear = Validation.getAnIntegerLimit("Enter year of experience: ", "Enter again", 1, 100);
                String professionalSkill = Validation.getString("Enter skill: ", "Enter again [String]");
                return new Experience(id, firstName, lastName, yearOfBirth, address, phone, email, 0, experienceYear, professionalSkill);
            case 2: // Fresher
                int graduationDate = Validation.getAnIntegerLimit("Enter year of graduation: ", "Enter again", 1900, LocalDate.now().getYear());
                String graduationRank = Validation.getRank("Enter graduation rank: ", "Enter again [Excellence, Good, Fair, Poor]");
                String university = Validation.getString("Enter University: ", "Enter again");
                return new Fresher(id, firstName, lastName, yearOfBirth, address, phone, email, 1, graduationDate, graduationRank, university);
            case 3: // Internship
                String majors = Validation.getString("Enter major: ", "Enter again");
                String semester = "" + Validation.getAnIntegerLimit("Enter semester: ", "Enter again", 1, 9);
                String universityName = Validation.getString("Enter university: ", "Enter again");
                return new Internship(id, firstName, lastName, yearOfBirth, address, phone, email, 2, majors, semester, universityName);
            default:
                return null;
        }
    }

}
