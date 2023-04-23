package com.geektrust.backend.commands;

public enum CommandKeyword {

    LOAN_COMMAND("LOAN"),
    BALANCE_COMMAND("BALANCE"),
    PAYMENT_COMMAND("PAYMENT");

    private final String name;

    private CommandKeyword(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
