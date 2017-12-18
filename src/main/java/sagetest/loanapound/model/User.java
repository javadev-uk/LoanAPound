package sagetest.loanapound.model;

@SuppressWarnings("FieldCanBeLocal")
class User {

    private final Applicant applicant;
    private boolean administrator;

    User(Applicant applicant, boolean administrator) {
        this.applicant = applicant;
        this.administrator = administrator;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
