package org.example.bankAccounts;

import org.example.exeptions.InsufficientFundsException;
import org.example.exeptions.InvalidTransactionException;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class SavingAccount extends BankAccount {
    final double interestRate;
    protected double minimumBalance;

    public SavingAccount(String accountNumber, String accountHolderName, double balance, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
        runApplyInterest();
    }

    public SavingAccount(String accountNumber, String accountHolderName, double interestRate) {
        super(accountNumber, accountHolderName);
        this.interestRate = interestRate;
        runApplyInterest();

    }

    public void applyInterest (){
        balance += (balance * (interestRate / 100));

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

     public void runApplyInterest() {
         Timer timer = new Timer();

         TimerTask task = new TimerTask() {
             @Override
             public void run() {
                 applyInterest();
             }
         };

         Calendar date = Calendar.getInstance();
         date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), 1, 0, 0, 0);
         timer.schedule(task, date.getTime(), 1000L * 60 * 60 * 24 * 30);
     }
}
