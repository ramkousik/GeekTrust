package com.geektrust.backend.services.impl;

import com.geektrust.backend.entities.Borrower;
import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.entities.LumpSumPayment;
import com.geektrust.backend.services.IBorrowerService;
import com.geektrust.backend.services.IPaymentService;

public class PaymentServiceImpl implements IPaymentService {

    private final IBorrowerService borrowerService;

    public PaymentServiceImpl(IBorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @Override
    public void savePaymentToBorrowerLoanAccount(String bankName, String borrowerName, Double payment, Integer emiPaidTillPayment) {
        Borrower borrower = borrowerService.findBorrowerByName(borrowerName);
        Loan loan = borrower.getBorrowerLoanByBank(bankName);

        LumpSumPayment lumpSumPayment = new LumpSumPayment(payment, emiPaidTillPayment);
        loan.setLumpSumPayment(lumpSumPayment);
    }
}
