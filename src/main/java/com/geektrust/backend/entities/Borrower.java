package com.geektrust.backend.entities;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Borrower {
    private final String borrowerName;
    private final Set<Loan> borrowerLoans;

    public Borrower(String borrowerName) {
        this.borrowerName = borrowerName;
        this.borrowerLoans = new HashSet<>();
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public Set<Loan> getBorrowerLoans() {
        return borrowerLoans;
    }

    public void addBorrowerLoan(Loan loan) {
        borrowerLoans.add(loan);
    }

    public Loan getBorrowerLoanByBank(String bankName) {
        Optional<Loan> loanByBank = borrowerLoans.stream().filter(loan -> loan.getLoanBank().equals(bankName)).findAny();

        if (!loanByBank.isPresent())
            throw new RuntimeException("Loan not found!");

        return loanByBank.get();
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "borrowerName='" + borrowerName + '\'' +
                ", borrowerLoan=" + borrowerLoans +
                '}';
    }
}
