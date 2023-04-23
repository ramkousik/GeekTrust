package com.geektrust.backend.services;

import com.geektrust.backend.entities.Loan;

public interface ILoanService {
    Loan saveLoan(String bankName, Double principal, Integer years, Double interestRate);
}
