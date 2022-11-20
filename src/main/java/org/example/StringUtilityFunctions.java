package org.example;

public class StringUtilityFunctions {

    // A function that returns true if the string is null or empty.
    public static boolean isNullOrEmpty(String word) {
        return word == null || word.trim().isEmpty();
    }
}
