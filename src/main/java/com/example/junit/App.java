package com.example.junit;

import java.util.List;

/**
 * Demo application showcasing the implemented classes
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=== JUnit Testing Demo Application ===\n");
        
        // Calculator demo
        Calculator calc = new Calculator();
        System.out.println("Calculator Demo:");
        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("10 - 4 = " + calc.subtract(10, 4));
        System.out.println("6 * 7 = " + calc.multiply(6, 7));
        System.out.println("15 / 3 = " + calc.divide(15, 3));
        System.out.println();
        
        // BankAccount demo
        System.out.println("BankAccount Demo:");
        BankAccount account = new BankAccount("ACC123", 1000.0);
        System.out.println("Initial balance: $" + account.getBalance());
        account.deposit(250.0);
        System.out.println("After depositing $250: $" + account.getBalance());
        account.withdraw(100.0);
        System.out.println("After withdrawing $100: $" + account.getBalance());
        System.out.println();
        
        // StringUtils demo
        System.out.println("StringUtils Demo:");
        String testString = "A man a plan a canal Panama";
        System.out.println("Is '" + testString + "' a palindrome? " + StringUtils.isPalindrome(testString));
        System.out.println("Reverse of 'Hello': " + StringUtils.reverse("Hello"));
        System.out.println("Word count in 'Hello world from Java': " + StringUtils.countWords("Hello world from Java"));
        System.out.println("Capitalize 'hello world': " + StringUtils.capitalize("hello world"));
        
        List<String> common = StringUtils.findCommonWords("Java is great", "Python is also great");
        System.out.println("Common words between 'Java is great' and 'Python is also great': " + common);
    }
}
