package com.geektrust.backend.services;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.entities.Loan;

public interface IBorrowerService {
    Borrower saveBorrower(String borrowerName, Loan borrowerLoan);

    Borrower findBorrowerByName(String borrowerName);
}
