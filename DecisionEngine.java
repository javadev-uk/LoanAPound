package sagetest.loanapound.service;

import sagetest.loanapound.CreditAgenciesException;
import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanType;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.model.LoanDecision;

/**
 * For checking credit score and assessing
 * whether loan can be referred to underwriter
 */

public interface DecisionEngine {

    int THRESHOLD_LOW = 0;
    int THRESHOLD_MED = 500;
    int THRESHOLD_HIGH = 900;

    /**
     * Interact with a collection of credit agencies until we get a credit score higher
     * than the required threshold
     *
     * @param applicant
     * @param loanType
     * @param amount
     * @param termYears
     * @return
     * @throws LoanException
     * @throws CreditAgenciesException
     */
    LoanDecision getDecision(Applicant applicant, LoanType loanType, int amount, int termYears) throws LoanException, CreditAgenciesException;
}
