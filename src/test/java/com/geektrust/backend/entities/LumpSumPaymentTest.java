package com.geektrust.backend.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Lump Sum Payment test")
class LumpSumPaymentTest {

    @DisplayName("Save Lump sum payment test")
    @Test
    void saveLumpSumPaymentTest() {
        double paymentAmount = 1000.00;
        int emiPaidTillPayment = 4;
        int emiPerMonth = 500;

        LumpSumPayment lumpSumPaymentTest = new LumpSumPayment(paymentAmount, emiPaidTillPayment);

        int expectedOutput = 2;
        assertEquals(expectedOutput, lumpSumPaymentTest.getNumberOfEmiReducedForLumpSumPayment(emiPerMonth));
    }
}
