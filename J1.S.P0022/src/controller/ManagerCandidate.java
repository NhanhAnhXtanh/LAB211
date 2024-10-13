package controller;

import java.util.ArrayList;
import models.Candidate;
import models.Experience;
import models.Fresher;
import models.Internship;

public class ManagerCandidate {

    private ArrayList<Candidate> candidateList = new ArrayList<>();

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
    }

    public boolean isEmpty() {
        return candidateList.isEmpty();
    }

    public String displayCandidateList(String experien, String fresher, String intern) {
        String result = experien + "\n";

        for (Candidate candidate : candidateList) {
            if (candidate instanceof Experience) {
                result += candidate.getFirstName() + " " + candidate.getLastName() + "\n";
            }
        }

        result += fresher + "\n";
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Fresher) {
                result += candidate.getFirstName() + " " + candidate.getLastName() + "\n";
            }
        }

        result += intern + "\n";
        for (Candidate candidate : candidateList) {
            if (candidate instanceof Internship) {
                result += candidate.getFirstName() + " " + candidate.getLastName() + "\n";
            }
        }
        return result;
    }

    public boolean checkIdExist(String id) {
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public String displayCandidate(String name, int type) {
        String result = "";
        for (Candidate candidate : candidateList) {
            if (candidate.getCandidateType() == type
                    && (candidate.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || (candidate.getLastName()).toUpperCase().contains(name.toUpperCase()))) {
                result += candidate.toString() + "\n";
            }
        }
        return result;
    }
}
