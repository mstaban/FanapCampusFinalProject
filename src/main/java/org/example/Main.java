package org.example;

import org.example.bankAccounts.Bank;
import org.example.bankAccounts.SavingAccount;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Bank bank = new Bank();

        SavingAccount savingAccount = new SavingAccount("1.1.1.1", "Mohammad", 10000, 6, 0);
        SavingAccount savingAccount2 = new SavingAccount("1.1.1.2", "Ali", 10000, 6, 0);
        SavingAccount savingAccount3 = new SavingAccount("1.1.1.3", "Yalda", 10000, 6, 0);
        SavingAccount savingAccount4 = new SavingAccount("1.1.1.4", "kua", 10000, 6, 0);
        SavingAccount savingAccount5 = new SavingAccount("1.1.1.5", "kua", 10000, 6, 0);
        SavingAccount savingAccount6 = new SavingAccount("1.1.1.6", "kua", 10000, 6, 0);

        bank.addAccount(savingAccount);
        bank.addAccount(savingAccount2);
        bank.addAccount(savingAccount3);
        bank.addAccount(savingAccount4);
        bank.addAccount(savingAccount5);
        bank.addAccount(savingAccount6);

        bank.printListAccounts();

        bank.removeAccount("1.1.1.1");

        System.out.println("=====================");
        bank.printListAccounts();

    }
}