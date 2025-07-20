package com.example.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("ACC123", 1000.0);
    }

    @Test
    @DisplayName("Account creation with valid parameters")
    void createAccountWithValidParameters() {
        assertEquals("ACC123", account.getAccountNumber());
        assertEquals(1000.0, account.getBalance());
        assertTrue(account.isActive());
    }

    @Test
    @DisplayName("Account creation with null account number should throw exception")
    void createAccountWithNullAccountNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount(null, 100.0),
                "Account creation with null account number should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Account creation with empty account number should throw exception")
    void createAccountWithEmptyAccountNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("", 100.0),
                "Account creation with empty account number should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Account creation with negative balance should throw exception")
    void createAccountWithNegativeBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("ACC123", -100.0),
                "Account creation with negative balance should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Deposit positive amount")
    void depositPositiveAmount() {
        account.deposit(250.0);
        assertEquals(1250.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit zero amount should throw exception")
    void depositZeroAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0.0),
                "Depositing zero amount should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Deposit negative amount should throw exception")
    void depositNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-50.0),
                "Depositing negative amount should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Withdraw valid amount")
    void withdrawValidAmount() {
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw amount greater than balance should throw exception")
    void withdrawAmountGreaterThanBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(1500.0),
                "Withdrawing amount greater than balance should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Withdraw zero amount should throw exception")
    void withdrawZeroAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0.0),
                "Withdrawing zero amount should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Withdraw negative amount should throw exception")
    void withdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-50.0),
                "Withdrawing negative amount should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Close account")
    void closeAccount() {
        account.closeAccount();
        assertFalse(account.isActive());
    }

    @Test
    @DisplayName("Deposit to closed account should throw exception")
    void depositToClosedAccount() {
        account.closeAccount();
        assertThrows(IllegalStateException.class,
                () -> account.deposit(100.0),
                "Depositing to closed account should throw IllegalStateException");
    }

    @Test
    @DisplayName("Withdraw from closed account should throw exception")
    void withdrawFromClosedAccount() {
        account.closeAccount();
        assertThrows(IllegalStateException.class,
                () -> account.withdraw(100.0),
                "Withdrawing from closed account should throw IllegalStateException");
    }

    @Test
    @DisplayName("Activate closed account")
    void activateClosedAccount() {
        account.closeAccount();
        assertFalse(account.isActive());
        account.activateAccount();
        assertTrue(account.isActive());
    }
}

