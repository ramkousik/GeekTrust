package com.geektrust.backend.services.impl;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.exceptions.BorrowerNotFoundException;
import com.geektrust.backend.repositories.IBorrowerRepository;
import com.geektrust.backend.services.IBorrowerService;

public class BorrowerServiceImpl implements IBorrowerService {

    private final IBorrowerRepository borrowerRepository;

    public BorrowerServiceImpl(IBorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public Borrower saveBorrower(String borrowerName, Loan borrowerLoan) {

        Borrower borrower;
        try {
            borrower = findBorrowerByName(borrowerName);
        } catch (BorrowerNotFoundException e) {
            borrower = new Borrower(borrowerName);
        }

        borrower.addBorrowerLoan(borrowerLoan);
        return borrowerRepository.save(borrower);
    }

    @Override
    public Borrower findBorrowerByName(String borrowerName) {
        return borrowerRepository.findByName(borrowerName);
    }
}
