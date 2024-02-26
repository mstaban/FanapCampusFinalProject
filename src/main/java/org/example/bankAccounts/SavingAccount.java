package org.example.bankAccounts;

import org.example.exeptions.InsufficientFundsException;
import org.example.exeptions.InvalidTransactionException;

public class SavingAccount extends BankAccount {
    final double interestRate;
    protected double minimumBalance;

    public SavingAccount(String accountNumber, String accountHolderName, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public SavingAccount(String accountNumber, String accountHolderName, double interestRate) {
        super(accountNumber, accountHolderName);
        this.interestRate = interestRate;

    }

    public void applyInterest (double years){
        super.balance+= (1 + years * interestRate) * super.balance;

    }
     @Override
     public void withdraw (double amount) throws InsufficientFundsException, InvalidTransactionException {
         if (amount > balance)
             throw new InsufficientFundsException("insufficient balance ");
         else if (amount < 0)
             throw new InsufficientFundsException("not valid amount ");
         else if (balance- amount < minimumBalance)
             throw new InvalidTransactionException("your balance should maintain bigger than minimumBalance");
         else
             balance -= amount;
     }
}
