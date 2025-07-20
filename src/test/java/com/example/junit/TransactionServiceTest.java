package com.example.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    private BankAccount mockBankAccount;

    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService(mockBankAccount);
    }

    @Test
    @DisplayName("Successful transfer with sufficient funds")
    void successfulTransferWithSufficientFunds() {
        // Arrange
        double transferAmount = 100.0;
        when(mockBankAccount.getBalance()).thenReturn(500.0);

        // Act
        boolean result = transactionService.transferFunds(transferAmount, "ACC123", "ACC456");

        // Assert
        assertTrue(result);
        verify(mockBankAccount).getBalance();
        verify(mockBankAccount).withdraw(transferAmount);
    }

    @Test
    @DisplayName("Failed transfer with insufficient funds")
    void failedTransferWithInsufficientFunds() {
        // Arrange
        double transferAmount = 600.0;
        when(mockBankAccount.getBalance()).thenReturn(500.0);

        // Act
        boolean result = transactionService.transferFunds(transferAmount, "ACC123", "ACC456");

        // Assert
        assertFalse(result);
        verify(mockBankAccount).getBalance();
        verify(mockBankAccount, never()).withdraw(anyDouble());
    }

    @Test
    @DisplayName("Transfer with zero amount should throw exception")
    void transferWithZeroAmountShouldThrowException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> transactionService.transferFunds(0.0, "ACC123", "ACC456"),
                "Transfer with zero amount should throw IllegalArgumentException");

        // Verify no interactions with the mock
        verifyNoInteractions(mockBankAccount);
    }

    @Test
    @DisplayName("Transfer with negative amount should throw exception")
    void transferWithNegativeAmountShouldThrowException() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> transactionService.transferFunds(-50.0, "ACC123", "ACC456"),
                "Transfer with negative amount should throw IllegalArgumentException");

        // Verify no interactions with the mock
        verifyNoInteractions(mockBankAccount);
    }

    @Test
    @DisplayName("Transfer exactly equal to balance")
    void transferExactlyEqualToBalance() {
        // Arrange
        double transferAmount = 500.0;
        when(mockBankAccount.getBalance()).thenReturn(500.0);

        // Act
        boolean result = transactionService.transferFunds(transferAmount, "ACC123", "ACC456");

        // Assert
        assertTrue(result);
        verify(mockBankAccount).getBalance();
        verify(mockBankAccount).withdraw(transferAmount);
    }
}

