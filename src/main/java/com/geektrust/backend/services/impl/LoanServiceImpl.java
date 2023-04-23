package com.geektrust.backend.services.impl;

import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.repositories.ILoanRepository;
import com.geektrust.backend.services.ILoanService;


public class LoanServiceImpl implements ILoanService {

    private final ILoanRepository loanRepository;

    public LoanServiceImpl(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan saveLoan(String bankName, Double principal, Integer years, Double interestRate) {
        Loan loan = new Loan(bankName, principal, years, interestRate);
        return loanRepository.save(loan);
    }
}
