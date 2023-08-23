package com.Adf.LoanSystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
//Wake up, Neo...
@Entity
@Table(name = "Loan")
@Data // Lombok annotation to generate getter, setter, toString, and other methods
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lid")
    private int lid; // Loan ID

    @Column(name = "amount")
    private double amount; // Loan amount

    @Column(name = "loan_date")
    private final LocalDate loanDate = LocalDate.now(); // Date when the loan was taken

    @Column(name = "interest_rate")
    private final int interestRate = 2; // Fixed interest rate for the loan

    @Column(name = "term")
    private int term; // Loan term (duration)

    @Column(name = "type")
    private String type; // Type of loan (e.g., personal, mortgage, etc.)

    @ManyToOne
    @JoinColumn(name = "nid")
    private User user; // Reference to the User entity who took the loan

    public Loan() {
    }

    // Constructor to initialize essential loan attributes
    public Loan(double amount, String type, int term) {
        this.amount = amount;
        this.type = type;
        this.term = term;
    }

    // Getter and setter methods for various attributes
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public int getInterestRate() {
        return interestRate;
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

    @Override
    public String toString() {
        return "Loan{" +
                "lid=" + lid +
                ", amount=" + amount +
                ", loanDate=" + loanDate +
                ", interestRate=" + interestRate +
                ", term=" + term +
                ", type='" + type + '\'' +
                ", user=" + user +
                '}';
    }
}
