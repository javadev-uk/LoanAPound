package sagetest.loanapound.model;

import sagetest.loanapound.service.CreditAgency;

public class LoanDecision {

    public static final boolean ACCEPTED = true;
    public static final boolean REJECTED = false;

    private Applicant applicant;
    private CreditAgency creditAgency;
    private boolean accepted;
    private int score;

    public LoanDecision(Applicant applicant, CreditAgency creditAgency, boolean accepted, int score) {
        this.applicant = applicant;
        this.creditAgency = creditAgency; //null if not accepted
        this.accepted = accepted;
        this.score = score;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public CreditAgency getCreditAgency() {
        return creditAgency;
    }

    public void setCreditAgency(CreditAgency creditAgency) {
        this.creditAgency = creditAgency;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return ("agency: " + creditAgency + ", accepted: " + isAccepted() + ", score: " + score);
    }

}
