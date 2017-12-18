package sagetest.loanapound.service;

import sagetest.loanapound.UnknownPersonException;
import sagetest.loanapound.model.Applicant;

import java.util.HashMap;

/**
 * entity for getting credit score from one or more credit scoring companies
 */
public interface CreditAgency {
    /**
     * Get the credit score for an applicant
     * @param applicant
     * @return
     * @throws UnknownPersonException
     */
    int getCreditScore(Applicant applicant) throws UnknownPersonException;
    boolean isDefaultAgency();
	public void setDefaultAgency(boolean defaultAgency);

    void setKnownPeople(HashMap<Applicant, Integer> knownPeople);
}
