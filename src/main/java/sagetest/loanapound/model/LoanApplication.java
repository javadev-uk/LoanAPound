package sagetest.loanapound.model;

public class LoanApplication {
    long id;
    long loanTypeId;
    long applicantId;
    int creditScore;

    enum status {inProgress, referred, rejected, accepted, notified}

    long underwriterId;
    long providerId;
    String decision;
    String reason;
}
