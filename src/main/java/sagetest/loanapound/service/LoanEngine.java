package sagetest.loanapound.service;

import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanApplication;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.model.LoanType;

/**
 * a service to process loan applications
 *
 * 3.	As a loan engine, I want to get a credit score from a third party system, so that it can be used to inform whether or not the applicant will get his loan accepted or rejected
 The Loan Engine can retrieve a list of unprocessed loans by looking at the status in the LoanTable.
 A set of rules will determine which CreditChecker should be used for the check.
 (These rules are currently held within the application. If these vary frequently then perhaps they could be held in the database instead).

 4.	As a loan engine, I want to be able to implement multiple credit score third party system, so that I can chose to use any of them based on various creiteria

 As above.

 5.	As loan engine, I want to be able to approve the loan or not based on the credit score&loan amount so that I can refer it to the underwriter decision or not

 */
public interface LoanEngine {
    /**
     * Using a DecisionEngine, approve or reject this loan application
     *
     * @param applicant
     * @param loanType
     * @param amount
     * @param termYears
     * @return
     */
    boolean approveLoan(Applicant applicant, LoanType loanType, int amount, int termYears) throws LoanException;
    void notifyApplicant(LoanApplication loanApplication);
}
