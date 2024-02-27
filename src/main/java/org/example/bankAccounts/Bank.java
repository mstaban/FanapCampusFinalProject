package org.example.bankAccounts;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Bank implements Serializable {

    HashMap<String, BankAccount> accounts;

    public Bank() throws IOException {

        File f = new File("AccountsSaveFile.txt");
        if (f.exists() && !f.isDirectory()) {
            accounts = fetchAccountsFromFile();
        } else {
            accounts = new HashMap<>();
            createFile();
        }
    }

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        saveAccountsInFile();
    }

    public void removeAccount(String accountNumber) {
        accounts.remove(accountNumber);
        saveAccountsInFile();
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public List<BankAccount> listAccounts() {
        List<BankAccount> accountsList = new ArrayList<>();
        for (HashMap.Entry mapElement : accounts.entrySet())
            accountsList.add((BankAccount) mapElement.getValue());
        return accountsList;
    }

    private void createFile() throws IOException{
        {
            Path newFilePath = Paths.get("AccountsSaveFile.txt");
            Files.createFile(newFilePath);
        }
    }
    private void saveAccountsInFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("AccountsSaveFile.txt")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listAccounts());
            objectOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private HashMap<String, BankAccount> fetchAccountsFromFile() {
        List<BankAccount> bankAccountList;

        try (FileInputStream fileInputStream = new FileInputStream("AccountsSaveFile.txt")) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bankAccountList = (List<BankAccount>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            // Handle the exceptions
            e.printStackTrace();
            bankAccountList = new ArrayList<>();
        }

        HashMap<String, BankAccount> accountHashMap = new HashMap<>();
        for (BankAccount bankAccount : bankAccountList) {
            accountHashMap.put(bankAccount.getAccountNumber(), bankAccount);
        }
        return accountHashMap;
    }

    public void printListAccounts() {
        accounts = fetchAccountsFromFile();
        listAccounts().stream()
                .map(
                        (account -> ("Account number: " + account.getAccountNumber() + "\t Holder: " + account.getAccountHolderName())
                        )
                ).forEach(System.out::println);

    }
}
