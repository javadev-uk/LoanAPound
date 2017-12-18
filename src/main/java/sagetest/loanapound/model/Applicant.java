package sagetest.loanapound.model;

import java.util.List;

public class Applicant {

    //minimal fields for this simple test
    private String surname;
    private String forename;
    private List<LoanApplication> loanApplicationList;

    public Applicant(String surname, String forename) {
        this.surname = surname;
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public List<LoanApplication> getLoanApplicationList() {
        return loanApplicationList;
    }

    public void setLoanApplicationList(List<LoanApplication> loanApplicationList) {
        this.loanApplicationList = loanApplicationList;
    }

    @Override
    public String toString() {
        return surname + "," + forename;
    }
}
