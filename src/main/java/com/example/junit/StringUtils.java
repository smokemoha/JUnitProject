package com.example.junit;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        return str.trim().split("\\s+").length;
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static List<String> findCommonWords(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return new ArrayList<>();
        }
        
        String[] words1 = text1.toLowerCase().split("\\s+");
        String[] words2 = text2.toLowerCase().split("\\s+");
        
        List<String> common = new ArrayList<>();
        
        for (String word1 : words1) {
            for (String word2 : words2) {
                if (word1.equals(word2) && !common.contains(word1)) {
                    common.add(word1);
                }
            }
        }
        
        return common;
    }
}

