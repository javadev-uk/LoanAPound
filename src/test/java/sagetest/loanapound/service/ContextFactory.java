package sagetest.loanapound.service;

import sagetest.loanapound.model.LoanType;
import sagetest.loanapound.model.Applicant;
import sagetest.loanapound.service.impl.DefaultCreditAgency;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("SpellCheckingInspection")

/**
 * This is a helper class to hold all test data required by the unit tests
 */
class ContextFactory {

    private static ContextModel model = null;

    public static ArrayList<CreditAgency> emptyCreditAgencies;
    public static ArrayList<CreditAgency> creditAgencies;
    private static final HashMap<Applicant, Integer> knownPeople = new HashMap<Applicant, Integer>();

    public static final Applicant applicantSmith = new Applicant("SMITH", "JOHN");
    public static final Applicant applicantGraham = new Applicant("GRAHAM", "JOHN");
    public static final LoanType threeYearThreePercent = new LoanType("3year3%", 3, 3.0f);

    static ContextModel getInstance() {
        if (model == null) {
            initContextModel();
        }
        return model;
    }

    static void initContextModel() {

        model = new ContextModel();

        //initialise the known people
        knownPeople.put(applicantSmith, 600);
        knownPeople.put(applicantGraham, 900);

        //build some credit agencies
        DefaultCreditAgency experian = new DefaultCreditAgency("Experian", true); //default
        DefaultCreditAgency equifax = new DefaultCreditAgency("Equifax", false);
        experian.setKnownPeople(knownPeople);
        equifax.setKnownPeople(knownPeople);

        emptyCreditAgencies = new ArrayList<CreditAgency>();
        creditAgencies = new ArrayList<CreditAgency>();
        creditAgencies.add(experian);
        creditAgencies.add(equifax);
        model.setCreditAgencies(creditAgencies);

        //initialise with one load type..
        ArrayList<LoanType> loansTypes = new ArrayList<LoanType>();
        loansTypes.add(threeYearThreePercent);
        model.setLoanTypes(loansTypes);
    }
}
