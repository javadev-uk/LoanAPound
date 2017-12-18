package sagetest.loanapound.service.impl;

import sagetest.loanapound.UnknownPersonException;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.service.CreditAgency;

import java.util.HashMap;

/**
 * entity for getting credit score from one or more credit scoring companies
 */
public class DefaultCreditAgency implements CreditAgency {
    private final String name;
    
    //is this agency to be used as the default, if there is more than one?
	private boolean defaultAgency; 

    public boolean isDefaultAgency() {
		return defaultAgency;
	}

	public void setDefaultAgency(boolean defaultAgency) {
		this.defaultAgency = defaultAgency;
	}

	private HashMap<Applicant,Integer> knownPeople = new HashMap<Applicant, Integer>();

    public DefaultCreditAgency(String name, boolean isDefault) {
        this.name = name;
        this.defaultAgency = isDefault;
    }

    /**
     * Get the credit score for an applicant
     * @param applicant
     * @return
     * @throws UnknownPersonException
     */
    public int getCreditScore(Applicant applicant) throws UnknownPersonException {
        if (!knownPeople.containsKey(applicant)) {
            throw new UnknownPersonException(applicant + " not known!");
        }
        //return the score
        return knownPeople.get(applicant);
    }

    public void setKnownPeople(HashMap<Applicant, Integer> knownPeople) {
        this.knownPeople = knownPeople;
    }

    public String toString() {
        return name;
    }

}
