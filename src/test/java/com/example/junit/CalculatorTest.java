package com.example.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Addition of two positive numbers")
    void addTwoPositiveNumbers() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    @DisplayName("Addition of positive and negative numbers")
    void addPositiveAndNegativeNumbers() {
        assertEquals(-1, calculator.add(2, -3), "2 + (-3) should equal -1");
    }

    @Test
    @DisplayName("Addition with zero")
    void addWithZero() {
        assertEquals(5, calculator.add(5, 0), "5 + 0 should equal 5");
    }

    @Test
    @DisplayName("Subtraction of two positive numbers")
    void subtractTwoPositiveNumbers() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    @DisplayName("Subtraction resulting in negative number")
    void subtractResultingInNegative() {
        assertEquals(-5, calculator.subtract(5, 10), "5 - 10 should equal -5");
    }

    @Test
    @DisplayName("Multiplication of two positive numbers")
    void multiplyTwoPositiveNumbers() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    @DisplayName("Multiplication with zero")
    void multiplyWithZero() {
        assertEquals(0, calculator.multiply(5, 0), "5 * 0 should equal 0");
    }

    @Test
    @DisplayName("Division of two positive numbers")
    void divideTwoPositiveNumbers() {
        assertEquals(2.0, calculator.divide(6, 3), "6 / 3 should equal 2.0");
    }

    @Test
    @DisplayName("Division by zero should throw IllegalArgumentException")
    void divideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0),
                "Division by zero should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Division resulting in a decimal number")
    void divideResultingInDecimal() {
        assertEquals(2.5, calculator.divide(5, 2), "5 / 2 should equal 2.5");
    }
}

