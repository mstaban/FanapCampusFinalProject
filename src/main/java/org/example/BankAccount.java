package org.example;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;


    public void deposit (double amount){
        if (amount < 0)
            throw new IllegalArgumentException("amount of deposit can not be negative");
        else
            balance += amount;
    }

    public void withdraw (double amount){
        if (amount > balance)
            throw new InsufficientFundsException("insufficient balance ");
        else if (amount < 0)
            throw new InsufficientFundsException("not valid amount ");
        else
            balance -= amount;
    }

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        balance = 0;
    }

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }


    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
