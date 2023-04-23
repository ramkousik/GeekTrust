package com.geektrust.backend.services.impl;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.entities.LumpSumPayment;
import com.geektrust.backend.services.IBalanceService;
import com.geektrust.backend.services.IBorrowerService;


public class BalanceServiceImpl implements IBalanceService {

    private final IBorrowerService borrowerService;

    public BalanceServiceImpl(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Override
    public String getBalanceForBorrower(String borrowerName, String bankName, Integer emiNumber) {
        Borrower borrower = borrowerService.findBorrowerByName(borrowerName);
        Loan loan = borrower.getBorrowerLoanByBank(bankName);
        /*
            Display Balance Logic
            1. If balance is requested for the month before Lump-sum Payment, do not include calculation for
               payment and its reduced emi.
        */
        double amountPaid;
        int emiRemaining;
        int emiPerMonth = loan.getEMIPerMonth();
        int totalLoanEmi = loan.getTotalEMIs();
        LumpSumPayment lumpSumPayment = loan.getLumpSumPayment();

        if (lumpSumPayment == null || emiNumber < lumpSumPayment.getEmiPaidTillPayment()) {
            amountPaid = emiPerMonth * (double) emiNumber;
            emiRemaining = totalLoanEmi - emiNumber;
        } else {

            amountPaid = (emiPerMonth * emiNumber) + lumpSumPayment.getPaymentAmount();
            emiRemaining = (int) Math.ceil((loan.getTotalLoanAmount() - amountPaid) / emiPerMonth);
            // Override amountPaid with TotalLoanAmount if emiRemaining is zero
            int zeroEmiPending = 0;
            if (emiRemaining == zeroEmiPending)
                amountPaid = loan.getTotalLoanAmount();
        }

        return loan.getLoanBank() + " " +
                borrower.getBorrowerName() + " " +
                (int) amountPaid + " " +
                emiRemaining;
    }
}
