package com.geektrust.backend.commands;

import com.geektrust.backend.entities.Loan;
import com.geektrust.backend.services.IBorrowerService;
import com.geektrust.backend.services.ILoanService;

import java.util.List;

import static com.geektrust.backend.constants.Constants.*;

public class LoanCommand implements ICommand {

    private final IBorrowerService borrowerService;
    private final ILoanService loanService;

    public LoanCommand(IBorrowerService borrowerService, ILoanService loanService) {
        this.borrowerService = borrowerService;
        this.loanService = loanService;
    }

    @Override
    public void execute(List<String> tokens) {
        String bankName = tokens.get(ONE);
        String borrowerName = tokens.get(TWO);
        Double loanPrincipal = Double.valueOf(tokens.get(THREE));
        Integer loanTenureInYears = Integer.valueOf(tokens.get(FOUR));
        Double loanInterestRate = Double.valueOf(tokens.get(FIVE));

        Loan loan = loanService.saveLoan(bankName, loanPrincipal, loanTenureInYears, loanInterestRate);
        borrowerService.saveBorrower(borrowerName, loan);
    }
}
