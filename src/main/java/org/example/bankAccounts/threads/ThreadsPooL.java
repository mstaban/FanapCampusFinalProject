package org.example.bankAccounts.threads;

import org.example.bankAccounts.BankAccount;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsPooL {
    public ThreadsPooL(int numberOfPools) {
        this.numberOfPools = numberOfPools;
    }

    protected int numberOfPools;
    protected double balanceSum;
    ExecutorService executor =  Executors.newFixedThreadPool(numberOfPools);
    public double sum (List<BankAccount> bankAccounts){
        executor.submit(() ->{
            for (BankAccount bankAccount : bankAccounts)
                balanceSum+= bankAccount.getBalance();
        });
        return balanceSum;
    }
}
