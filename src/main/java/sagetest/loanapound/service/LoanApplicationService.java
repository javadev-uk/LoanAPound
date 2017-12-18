package sagetest.loanapound.service;

import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanApplication;
import sagetest.loanapound.model.LoanDecision;
import sagetest.loanapound.model.LoanType;
import sagetest.loanapound.model.Applicant;

import java.util.List;

public interface LoanApplicationService {
    LoanApplication applyForLoan(Applicant applicant, LoanType loanType, int amount, int term) throws LoanException;
    List listApplications(Applicant applicant) throws LoanException;
    LoanDecision checkApplication(Applicant applicant, LoanApplication application) throws LoanException;
    void cancelApplication(Applicant applicant, LoanApplication application) throws LoanException;
}
