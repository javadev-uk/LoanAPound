package sagetest.loanapound.service.impl;

import sagetest.loanapound.CreditAgenciesException;
import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanApplication;
import sagetest.loanapound.model.LoanDecision;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.model.LoanType;

import sagetest.loanapound.service.ContextModel;
import sagetest.loanapound.service.DecisionEngine;
import sagetest.loanapound.service.LoanEngine;

public class LoanEngineService implements LoanEngine {

    DecisionEngine decisionEngine;
    ContextModel model;

    /**
     * Using a DecisionEngine, approve or reject this loan application
     *
     * @param applicant
     * @param loanType
     * @param amount
     * @param termYears
     * @return
     */
    public boolean approveLoan(Applicant applicant, LoanType loanType, int amount, int termYears) throws LoanException{
        try {
            LoanDecision decision = decisionEngine.getDecision(applicant, loanType, amount, termYears);
            //TODO: work needed here to persist the decision and notify the applicant
            return decision.isAccepted();
        } catch (CreditAgenciesException e) {
            throw new LoanException(e.getMessage());
        }
    }

    public void notifyApplicant(LoanApplication loanApplication) {
        //TODO: complete this
    }

    public DecisionEngine getDecisionEngine() {
        return decisionEngine;
    }

    public void setDecisionEngine(DecisionEngine decisionEngine) {
        this.decisionEngine = decisionEngine;
    }

    public ContextModel getModel() {
        return model;
    }

    public void setModel(ContextModel model) {
        this.model = model;
    }

}
