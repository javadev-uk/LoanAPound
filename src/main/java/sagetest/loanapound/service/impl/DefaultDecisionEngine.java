package sagetest.loanapound.service.impl;

import sagetest.loanapound.CreditAgenciesException;
import sagetest.loanapound.LoanException;
import sagetest.loanapound.UnknownPersonException;
import sagetest.loanapound.model.LoanType;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.model.LoanDecision;
import sagetest.loanapound.service.ContextModel;
import sagetest.loanapound.service.CreditAgency;
import sagetest.loanapound.service.DecisionEngine;

/**
 * For checking credit score and assessing
 * whether loan can be referred to underwriter
 */
public class DefaultDecisionEngine implements DecisionEngine {

    private final ContextModel model;
    private final int creditScoreThreshold;

    public DefaultDecisionEngine(ContextModel model, int threshold) {
        this.model = model;
        this.creditScoreThreshold = threshold;
    }

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
    public LoanDecision getDecision(Applicant applicant, LoanType loanType, int amount, int termYears) throws LoanException, CreditAgenciesException {

        //check if within limit
        if (amount > model.getMaxLoanAmount()) {
            throw new LoanException("Amount exceeds borrowing limit");
        }

        //make sure we have agencies to check
        if (null == model.getCreditAgencies() || model.getCreditAgencies().isEmpty() ) {
            throw new CreditAgenciesException("List of available Credit agencies is null or empty");
        }

        // main loop: iterate through the collection of credit agencies
        // return the first where credit score is above the threshold
        //
        LoanDecision decision = new LoanDecision(applicant, null, LoanDecision.REJECTED, 0);
        int score;
        for (CreditAgency agency : model.getCreditAgencies()) {
            try {
                score = agency.getCreditScore(applicant);
                if (score >= creditScoreThreshold) {
                    decision = new LoanDecision(applicant, agency, LoanDecision.ACCEPTED, score);
                    break; //Winner!
                } else {
                    decision.setCreditAgency(agency);
                    decision.setScore(score);
                }
            } catch (UnknownPersonException e) {
                System.out.println(agency.toString() + " exception: " + e);
            }
        }
        //TODO: refer to underwriter
        return decision;
    }
}
