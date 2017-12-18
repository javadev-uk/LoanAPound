package sagetest.loanapound.service;

import sagetest.loanapound.LoanException;
import sagetest.loanapound.service.impl.DefaultDecisionEngine;
import sagetest.loanapound.service.impl.LoanEngineService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoanEngineTest {

    private final ContextModel model = ContextFactory.getInstance();
    private LoanEngineService service = new LoanEngineService();
    private DecisionEngine decisionEngine = new DefaultDecisionEngine(model, 500);

    @Before
    public void setUp() throws Exception {
        service.setDecisionEngine(decisionEngine);
    }

    @Test
    public void approveLoanWithinLimit() {
        try {
            assertTrue(service.approveLoan(ContextFactory.applicantGraham, ContextFactory.threeYearThreePercent, 14000, 3));
        } catch (LoanException e) {
            System.out.println(e.getMessage());
            assert true;
        }
    }

    @Test
    public void rejectLoanOverLimit() {
        try {
            assertFalse(service.approveLoan(ContextFactory.applicantGraham, ContextFactory.threeYearThreePercent, 16000, 3));
        } catch (LoanException e) {
            System.out.println(e.getMessage());
            assert true;
        }
    }

    @Test
    public void notifyApplicant() {
    }
}