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
    void setKnownPeople(HashMap<Applicant, Integer> knownPeople);
}
