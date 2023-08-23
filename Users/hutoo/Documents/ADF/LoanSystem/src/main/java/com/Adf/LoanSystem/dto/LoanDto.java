package com.Adf.LoanSystem.dto;

import com.Adf.LoanSystem.model.User;

public class LoanDto {

    private double amount;
    private int term; // Loan term (duration)
    private String type; // Type of loan (e.g., personal, mortgage, etc.)
    private User user; // Reference to the User entity who took the loan

    public LoanDto() {
    }

    // Constructor to initialize essential loan attributes
    public LoanDto(double amount, String type, int term) {
        this.amount = amount;
        this.type = type;
        this.term = term;
    }

    // Getter and setter methods for various attributes
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
