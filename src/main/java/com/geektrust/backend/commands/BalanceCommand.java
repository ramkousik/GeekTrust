package com.geektrust.backend.commands;

import com.geektrust.backend.services.IBalanceService;

import java.util.List;

import static com.geektrust.backend.constants.Constants.*;

public class BalanceCommand implements ICommand {

    private final IBalanceService balanceService;

    public BalanceCommand(IBalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(ONE);
        String borrowerName = tokens.get(TWO);
        Integer emiPaid = Integer.valueOf(tokens.get(THREE));

        String output = balanceService.getBalanceForBorrower(borrowerName, bankName, emiPaid);
        System.out.println(output);
    }
}
