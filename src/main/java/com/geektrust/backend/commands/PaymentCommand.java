package com.geektrust.backend.commands;

import com.geektrust.backend.services.IPaymentService;

import java.util.List;

import static com.geektrust.backend.constants.Constants.*;

public class PaymentCommand implements ICommand {

    private final IPaymentService paymentService;

    public PaymentCommand(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(ONE);
        String borrowerName = tokens.get(TWO);
        Double payment = Double.valueOf(tokens.get(THREE));
        Integer emiPaidTillPayment = Integer.valueOf(tokens.get(FOUR));

        paymentService.savePaymentToBorrowerLoanAccount(bankName, borrowerName, payment, emiPaidTillPayment);
    }
}
