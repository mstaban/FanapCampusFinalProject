package bank;

import java.util.Optional;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolderName;
    public void deposit(int newBalance){
        if (newBalance<0)
            throw new IllegalArgumentException("amount of deposit can not be negative");
        else
            balance+= newBalance;
    }
    public void withdraw(double withdrawAmount){
        if (withdrawAmount>balance)
            throw new IllegalArgumentException("insufficient balance ");
        else
            balance-= withdrawAmount;
    }

    public BankAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        Optional.ofNullable(this.balance);
    }
}
