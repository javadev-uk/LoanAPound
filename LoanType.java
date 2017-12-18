package sagetest.loanapound.model;

import java.util.Date;

public class LoanType {
    private long id;
    private String name;
    private int termYears;
    private float rate;

    //potential / optional...

    /* Maximum budget this loan can be allocated against */
    long maxBudget;

    /* If not null then this loan is only available after this date */
    private Date validFrom;
    /* If not null then this loan is not available after this date */
    private Date validTo;

    /* ID of the loan provider */
    private long providerId;

    /* minimum score to be eligible */
    private int minimumCreditScore;

    public LoanType(String name, int termYears, float rate) {
        this.name = name;
        this.termYears = termYears;
        this.rate = rate;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTermYears() {
        return termYears;
    }

    public void setTermYears(int termYears) {
        this.termYears = termYears;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public int getMinimumCreditScore() {
        return minimumCreditScore;
    }

    public void setMinimumCreditScore(int minimumCreditScore) {
        this.minimumCreditScore = minimumCreditScore;
    }

}
