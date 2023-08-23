package com.Adf.LoanSystem.service;

import com.Adf.LoanSystem.model.Loan;
import com.Adf.LoanSystem.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanServiceImpl implements LoanService{
    private final LoanRepository loanRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void requestLoan(Loan loan) {
        // Implement the logic to process a loan request
        loanRepository.save(loan);
    }

    // Implement other methods for loan-related operations
}
