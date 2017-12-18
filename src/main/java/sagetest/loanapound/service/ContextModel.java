package sagetest.loanapound.service;

import sagetest.loanapound.model.LoanApplication;
import sagetest.loanapound.model.LoanProvider;
import sagetest.loanapound.model.LoanType;
import sagetest.loanapound.model.Applicant;

import java.util.ArrayList;

public class ContextModel {
    private Applicant applicant;
    private LoanApplication loanApplication;
    private ArrayList<LoanType> loanTypes;
    private ArrayList<LoanProvider> loanProviders;
    private ArrayList<CreditAgency> creditAgencies;
    private int maxLoanAmount = 15000;

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public LoanApplication getLoanApplication() {
        return loanApplication;
    }

    public void setLoanApplication(LoanApplication loanApplication) {
        this.loanApplication = loanApplication;
    }

    public ArrayList<LoanType> getLoanTypes() {
        return loanTypes;
    }

    public void setLoanTypes(ArrayList<LoanType> loanTypes) {
        this.loanTypes = loanTypes;
    }

    public ArrayList<LoanProvider> getLoanProviders() {
        return loanProviders;
    }

    public void setLoanProviders(ArrayList<LoanProvider> loanProviders) {
        this.loanProviders = loanProviders;
    }

    public ArrayList<CreditAgency> getCreditAgencies() {
        return creditAgencies;
    }

    public void setCreditAgencies(ArrayList<CreditAgency> creditAgencies) {
        this.creditAgencies = creditAgencies;
    }

    public int getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(int maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }
}
