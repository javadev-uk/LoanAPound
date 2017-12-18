package sagetest.loanapound.model;

public class LoanApplication {
    long id;
    LoanType loanType;
    Applicant applicant;
    int creditScore;

    enum status {inProgress, referred, rejected, accepted, notified}

    Underwriter underwriter;
    LoanProvider provider;
    
    LoanDecision decision;
}
