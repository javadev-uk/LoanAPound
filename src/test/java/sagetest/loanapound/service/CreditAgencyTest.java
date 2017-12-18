package sagetest.loanapound.service;

import sagetest.loanapound.UnknownPersonException;
import sagetest.loanapound.model.Applicant;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditAgencyTest {

    private final ContextModel model = ContextFactory.getInstance();

    @Test
    public void getCreditScoreAbove600() {
        assertCreditScore(600, ContextFactory.applicantGraham);
        assertCreditScore(600, ContextFactory.applicantSmith);
    }
    @Test
    public void getCreditScoreAbove900() {

        assertTrue(assertCreditScore(900, ContextFactory.applicantGraham));
        assertFalse(assertCreditScore(900, ContextFactory.applicantSmith));
    }

    private boolean assertCreditScore(int threshold, Applicant applicant) {
        //make sure we have agencies to check
        if (null == model.getCreditAgencies() || model.getCreditAgencies().isEmpty() ) {
            fail("List of available Credit agencies is null or empty");
        }

        model.setApplicant(applicant);
        int score = 0;
        for (CreditAgency agency : model.getCreditAgencies()) {
            try {
                score = agency.getCreditScore(model.getApplicant());
                if (score < threshold) {
                    System.out.println(agency.toString() + " scored " + score + " for " + applicant + ", when threshold was " + threshold);
                }
            } catch (UnknownPersonException e) {
                fail(agency.toString() + " exception: " + e);
            }
        }
        return score >= threshold;

    }

}