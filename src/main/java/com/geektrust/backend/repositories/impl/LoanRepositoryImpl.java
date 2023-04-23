package com.geektrust.backend.repositories.impl;

import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.repositories.ILoanRepository;

import java.util.HashMap;
import java.util.Map;

public class LoanRepositoryImpl implements ILoanRepository {

    private final Map<Integer, Loan> loanMap;
    private Integer autoIncrementId = 1;

    public LoanRepositoryImpl() {
        loanMap = new HashMap<>();
    }

    public LoanRepositoryImpl(Map<Integer, Loan> loanMap) {
        this.loanMap = loanMap;
    }

    @Override
    public Loan save(Loan loan) {
        Loan loanObj = new Loan(autoIncrementId, loan.getLoanBank(), loan.getLoanPrincipal(), loan.getLoanTenureInYears(), loan.getLoanInterestRate());
        loanMap.put(autoIncrementId, loanObj);
        autoIncrementId++;
        return loanObj;
    }

    @Override
    public Loan findById(Integer id) {
        return loanMap.get(id);
    }
}
