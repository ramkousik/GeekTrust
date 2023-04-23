package com.geektrust.backend.services;

public interface IBalanceService {
    String getBalanceForBorrower(String borrowerName, String bankName, Integer emiNumber);
}
