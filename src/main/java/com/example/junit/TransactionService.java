package com.example.junit;

public class TransactionService {

    private BankAccount bankAccount;

    public TransactionService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean transferFunds(double amount, String fromAccountNum, String toAccountNum) {
        // In a real application, we would fetch accounts by their numbers
        // For this example, we'll assume the bankAccount passed in is the 'from' account
        // and we're just simulating the transfer logic.

        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        if (bankAccount.getBalance() < amount) {
            return false; // Insufficient funds
        }

        bankAccount.withdraw(amount);
        // THis just simulate deposit to another account (not implemented here as we're focusing on mocking the withdrawal)
        // BankAccount toAccount = findAccount(toAccountNum);
        // toAccount.deposit(amount);
        return true;
    }
}



/*
public boolean transferFunds(double amount, String fromAccountNum, String toAccountNum) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Transfer amount must be positive");
    }

    // Fetch both accounts from a repository or database
    BankAccount fromAccount = findAccount(fromAccountNum);
    BankAccount toAccount = findAccount(toAccountNum);

    if (fromAccount == null || toAccount == null) {
        throw new IllegalArgumentException("Account not found");
    }

    if (fromAccount.getBalance() < amount) {
        return false; // Insufficient funds
    }

    fromAccount.withdraw(amount);
    toAccount.deposit(amount);

    // Optionally, persist the changes to the database here

    return true;
}

// Example stub for account lookup
private BankAccount findAccount(String accountNum) {
    // In a real app, this would query a database or repository
    // For example: return accountRepository.findByAccountNumber(accountNum);
    return null;
}
*/