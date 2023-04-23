package com.geektrust.backend.repositories.impl;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.exceptions.BorrowerNotFoundException;
import com.geektrust.backend.repositories.IBorrowerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BorrowerRepositoryImpl implements IBorrowerRepository {

    private final Map<String, Borrower> borrowerMap;

    public BorrowerRepositoryImpl() {
        borrowerMap = new HashMap<>();
    }

    // For Unit test
    public BorrowerRepositoryImpl(Map<String, Borrower> borrowerMap) {
        this.borrowerMap = borrowerMap;
    }

    @Override
    public Borrower save(Borrower borrower) {
        borrowerMap.put(borrower.getBorrowerName(), borrower);
        return borrower;
    }

    @Override
    public Borrower findByName(String name) {
        Optional<Borrower> optionalBorrower = borrowerMap.values().stream().filter(borrower -> borrower.getBorrowerName().equals(name)).findAny();
        if (optionalBorrower.isPresent())
            return optionalBorrower.get();

        throw new BorrowerNotFoundException("Expense ID not found in database!");
    }
}
