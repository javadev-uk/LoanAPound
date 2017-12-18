package sagetest.loanapound.model;

public class LoanProvider {
    private long id;
    private String name;
    private long budget;
    private long allocated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getAllocated() {
        return allocated;
    }

    public void setAllocated(long allocated) {
        this.allocated = allocated;
    }

    public long getAvailable() {
        return budget-allocated;
    }

}
