package sagetest.loanapound.service;

import sagetest.loanapound.CreditAgenciesException;
import sagetest.loanapound.LoanException;
import sagetest.loanapound.model.LoanDecision;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.service.impl.DefaultDecisionEngine;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ALL")
public class DecisionEngineTest {

    private final ContextModel model = ContextFactory.getInstance();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getDecisionNoAgencies() {
        try {
            model.setCreditAgencies(ContextFactory.emptyCreditAgencies);
            DecisionEngine engine = new DefaultDecisionEngine(model,0);
            LoanDecision decision = engine.getDecision(new Applicant("SMITH", "JOHN"),
                    ContextFactory.threeYearThreePercent, 10000,3);
            fail("Should have failed without a list of credit agencies");
        } catch (LoanException ex1) {
            fail("should be within limits");
        } catch (CreditAgenciesException ex2) {
            assert true;
        }
    }
    @Test
    public void getDecisionUnknownPerson() {
        try {
            model.setCreditAgencies(ContextFactory.creditAgencies);
            DecisionEngine engine = new DefaultDecisionEngine(model, DecisionEngine.THRESHOLD_LOW);
            LoanDecision decision = engine.getDecision(new Applicant("DOE", "JOHN"),
                    ContextFactory.threeYearThreePercent, 10000,3);
        } catch (LoanException ex1) {
            fail("should be within limits");
        } catch (CreditAgenciesException ex1) {
            fail("Should not have failed because of credit agencies");
        }
    }
    @Test
    public void getDecisionRejected() {
        try {
            DecisionEngine engine = new DefaultDecisionEngine(model, DecisionEngine.THRESHOLD_HIGH);
            LoanDecision decision = engine.getDecision(ContextFactory.applicantSmith,
                    ContextFactory.threeYearThreePercent, 10000,3);
        } catch (LoanException ex1) {
            fail("should be within limits");
        } catch (CreditAgenciesException ex1) {
            fail("Should not have failed because of credit agencies");
        }
    }
    @Test
    public void getDecisionAccepted() {
        try {
            DecisionEngine engine = new DefaultDecisionEngine(model, DecisionEngine.THRESHOLD_LOW);
            LoanDecision decision = engine.getDecision(ContextFactory.applicantGraham,
                    ContextFactory.threeYearThreePercent, 10000,3);
            assertNotNull (decision);
            assertTrue (decision.isAccepted());
        } catch (LoanException ex1) {
            fail("should be within limits");
        } catch (CreditAgenciesException ex1) {
            fail("Should not have failed because of credit agencies");
        }
    }
    @Test
    public void getDecisionRejectedAmountTooHigh() {
        try {
            DecisionEngine engine = new DefaultDecisionEngine(model, DecisionEngine.THRESHOLD_LOW);
            LoanDecision decision = engine.getDecision(ContextFactory.applicantGraham,
                    ContextFactory.threeYearThreePercent, 100000,3);
            assertNotNull (decision);
            assertFalse (decision.isAccepted());
        } catch (LoanException ex1) {
            assert true;
        } catch (CreditAgenciesException ex1) {
            fail("Should not have failed because of credit agencies");
        }
    }
}