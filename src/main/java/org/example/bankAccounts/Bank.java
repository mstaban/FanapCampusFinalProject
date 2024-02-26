package org.example.bankAccounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    HashMap <String, BankAccount> bankAccount = new HashMap<>();
    public void addAccount (BankAccount account){
        bankAccount.put(account.getAccountNumber(), account);
    }
    public void removeAccount (String accountNumber){
        bankAccount.remove(accountNumber);
    }
    public BankAccount findAccount (String accountNumber){
        return bankAccount.get(accountNumber);
    }
    public void listAccounts (){
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (HashMap.Entry mapElement: bankAccount.entrySet())
            bankAccounts.add((BankAccount) mapElement.getValue());
        System.out.println(bankAccounts.toArray());
    }
}
