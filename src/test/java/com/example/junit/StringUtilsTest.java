package com.example.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class StringUtilsTest {

    @Nested
    @DisplayName("Palindrome Tests")
    class PalindromeTests {

        @Test
        @DisplayName("Simple palindrome")
        void simplePalindrome() {
            assertTrue(StringUtils.isPalindrome("racecar"));
        }

        @Test
        @DisplayName("Palindrome with spaces and punctuation")
        void palindromeWithSpacesAndPunctuation() {
            assertTrue(StringUtils.isPalindrome("A man, a plan, a canal: Panama"));
        }

        @Test
        @DisplayName("Not a palindrome")
        void notAPalindrome() {
            assertFalse(StringUtils.isPalindrome("hello"));
        }

        @Test
        @DisplayName("Empty string is palindrome")
        void emptyStringIsPalindrome() {
            assertTrue(StringUtils.isPalindrome(""));
        }

        @Test
        @DisplayName("Null string is not palindrome")
        void nullStringIsNotPalindrome() {
            assertFalse(StringUtils.isPalindrome(null));
        }

        @Test
        @DisplayName("Single character is palindrome")
        void singleCharacterIsPalindrome() {
            assertTrue(StringUtils.isPalindrome("a"));
        }
    }

    @Nested
    @DisplayName("Reverse Tests")
    class ReverseTests {

        @Test
        @DisplayName("Reverse normal string")
        void reverseNormalString() {
            assertEquals("olleH", StringUtils.reverse("Hello"));
        }

        @Test
        @DisplayName("Reverse empty string")
        void reverseEmptyString() {
            assertEquals("", StringUtils.reverse(""));
        }

        @Test
        @DisplayName("Reverse null string")
        void reverseNullString() {
            assertNull(StringUtils.reverse(null));
        }

        @Test
        @DisplayName("Reverse single character")
        void reverseSingleCharacter() {
            assertEquals("a", StringUtils.reverse("a"));
        }
    }

    @Nested
    @DisplayName("Word Count Tests")
    class WordCountTests {

        @Test
        @DisplayName("Count words in normal sentence")
        void countWordsInNormalSentence() {
            assertEquals(4, StringUtils.countWords("Hello world from Java"));
        }

        @Test
        @DisplayName("Count words with extra spaces")
        void countWordsWithExtraSpaces() {
            assertEquals(3, StringUtils.countWords("  Hello   world   Java  "));
        }

        @Test
        @DisplayName("Count words in empty string")
        void countWordsInEmptyString() {
            assertEquals(0, StringUtils.countWords(""));
        }

        @Test
        @DisplayName("Count words in null string")
        void countWordsInNullString() {
            assertEquals(0, StringUtils.countWords(null));
        }

        @Test
        @DisplayName("Count words in single word")
        void countWordsInSingleWord() {
            assertEquals(1, StringUtils.countWords("Hello"));
        }

        @Test
        @DisplayName("Count words in whitespace only string")
        void countWordsInWhitespaceOnlyString() {
            assertEquals(0, StringUtils.countWords("   "));
        }
    }

    @Nested
    @DisplayName("Capitalize Tests")
    class CapitalizeTests {

        @Test
        @DisplayName("Capitalize normal string")
        void capitalizeNormalString() {
            assertEquals("Hello world", StringUtils.capitalize("hello world"));
        }

        @Test
        @DisplayName("Capitalize already capitalized string")
        void capitalizeAlreadyCapitalizedString() {
            assertEquals("Hello world", StringUtils.capitalize("Hello World"));
        }

        @Test
        @DisplayName("Capitalize empty string")
        void capitalizeEmptyString() {
            assertEquals("", StringUtils.capitalize(""));
        }

        @Test
        @DisplayName("Capitalize null string")
        void capitalizeNullString() {
            assertNull(StringUtils.capitalize(null));
        }

        @Test
        @DisplayName("Capitalize single character")
        void capitalizeSingleCharacter() {
            assertEquals("A", StringUtils.capitalize("a"));
        }
    }

    @Nested
    @DisplayName("Find Common Words Tests")
    class FindCommonWordsTests {

        @Test
        @DisplayName("Find common words in normal texts")
        void findCommonWordsInNormalTexts() {
            List<String> common = StringUtils.findCommonWords("Java is great", "Python is also great");
            assertEquals(2, common.size());
            assertTrue(common.contains("is"));
            assertTrue(common.contains("great"));
        }

        @Test
        @DisplayName("Find common words with no common words")
        void findCommonWordsWithNoCommonWords() {
            List<String> common = StringUtils.findCommonWords("Java programming", "Python coding");
            assertEquals(0, common.size());
        }

        @Test
        @DisplayName("Find common words with null first text")
        void findCommonWordsWithNullFirstText() {
            List<String> common = StringUtils.findCommonWords(null, "Python is great");
            assertEquals(0, common.size());
        }

        @Test
        @DisplayName("Find common words with null second text")
        void findCommonWordsWithNullSecondText() {
            List<String> common = StringUtils.findCommonWords("Java is great", null);
            assertEquals(0, common.size());
        }

        @Test
        @DisplayName("Find common words with both texts null")
        void findCommonWordsWithBothTextsNull() {
            List<String> common = StringUtils.findCommonWords(null, null);
            assertEquals(0, common.size());
        }

        @Test
        @DisplayName("Find common words case insensitive")
        void findCommonWordsCaseInsensitive() {
            List<String> common = StringUtils.findCommonWords("Java IS great", "python is ALSO great");
            assertEquals(2, common.size());
            assertTrue(common.contains("is"));
            assertTrue(common.contains("great"));
        }
    }
}

