package com.geektrust.backend.entities;

public class LumpSumPayment {
    private final Double paymentAmount;
    private final Integer emiPaidTillPayment;

    public LumpSumPayment(Double paymentAmount, Integer emiPaidTillPayment) {
        this.paymentAmount = paymentAmount;
        this.emiPaidTillPayment = emiPaidTillPayment;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public Integer getEmiPaidTillPayment() {
        return emiPaidTillPayment;
    }

    public int getNumberOfEmiReducedForLumpSumPayment(int emiPerMonth) {
        return (int) Math.round(paymentAmount / emiPerMonth);
    }
}
