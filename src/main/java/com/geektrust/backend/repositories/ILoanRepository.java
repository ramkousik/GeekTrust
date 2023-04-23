package com.geektrust.backend.repositories;

import com.geektrust.backend.entities.Loan;

public interface ILoanRepository {
    Loan save(Loan loan);
    Loan findById(Integer id);
}
