package com.geektrust.backend.config;

import com.geektrust.backend.commands.*;
import com.geektrust.backend.repositories.IBorrowerRepository;
import com.geektrust.backend.repositories.ILoanRepository;
import com.geektrust.backend.repositories.impl.BorrowerRepositoryImpl;
import com.geektrust.backend.repositories.impl.LoanRepositoryImpl;
import com.geektrust.backend.services.IBalanceService;
import com.geektrust.backend.services.IBorrowerService;
import com.geektrust.backend.services.ILoanService;
import com.geektrust.backend.services.IPaymentService;
import com.geektrust.backend.services.impl.BalanceServiceImpl;
import com.geektrust.backend.services.impl.BorrowerServiceImpl;
import com.geektrust.backend.services.impl.LoanServiceImpl;
import com.geektrust.backend.services.impl.PaymentServiceImpl;

public class Configuration {
    private static final Configuration instance = new Configuration();
    private final ILoanRepository loanRepository = new LoanRepositoryImpl();
    private final IBorrowerRepository borrowerRepository = new BorrowerRepositoryImpl();
    private final ILoanService loanService = new LoanServiceImpl(loanRepository);
    private final IBorrowerService borrowerService = new BorrowerServiceImpl(borrowerRepository);
    private final IBalanceService balanceService = new BalanceServiceImpl(borrowerService);
    private final BalanceCommand balanceCommand = new BalanceCommand(balanceService);
    private final IPaymentService paymentService = new PaymentServiceImpl(borrowerService);
    private final PaymentCommand paymentCommand = new PaymentCommand(paymentService);
    // Initialize all commands
    private final LoanCommand loanCommand = new LoanCommand(borrowerService, loanService);
    // Initialize command Invoker
    private final CommandInvoker commandInvoker = new CommandInvoker();


    private Configuration() {
    }

    public static Configuration getInstance() {
        return instance;
    }

    private void registerCommands() {
        commandInvoker.registerCommand(CommandKeyword.LOAN_COMMAND.getName(), loanCommand);
        commandInvoker.registerCommand(CommandKeyword.BALANCE_COMMAND.getName(), balanceCommand);
        commandInvoker.registerCommand(CommandKeyword.PAYMENT_COMMAND.getName(), paymentCommand);
    }

    public CommandInvoker getCommandInvoker() {
        registerCommands();
        return commandInvoker;
    }
}
