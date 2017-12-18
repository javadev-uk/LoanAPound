package sagetest.loanapound.model;

import sagetest.loanapound.service.CreditAgency;

public class LoanDecision {

	public enum LoanStatus { ACCEPTED, REJECTED };

    private Applicant applicant;
    private CreditAgency creditAgency;
    private LoanStatus status;
    private int score;

    public LoanDecision(Applicant applicant, CreditAgency creditAgency, LoanStatus status, int score) {
        this.applicant = applicant;
        this.creditAgency = creditAgency; //null if not accepted
        this.status = status;
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
        return status == LoanStatus.ACCEPTED;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
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
