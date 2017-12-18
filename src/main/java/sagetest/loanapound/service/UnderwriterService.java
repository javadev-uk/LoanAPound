package sagetest.loanapound.service;

import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanApplication;
import sagetest.loanapound.model.LoanDecision;

/**
 * Service to process a queue of pending applications, to approve or reject
 */
public interface UnderwriterService {
    LoanDecision underwriteLoanApplication(LoanApplication application) throws LoanException;
}
