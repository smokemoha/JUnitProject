package com.example.junit;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private boolean isActive;

    public BankAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.isActive = true;
    }

    public void deposit(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Account is not active");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Account is not active");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void closeAccount() {
        this.isActive = false;
    }

    public void activateAccount() {
        this.isActive = true;
    }
}

