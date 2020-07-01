package data_structures.arrays_and_strings;

import java.lang.StringBuilder;
import java.util.Arrays;

public class InterviewQuestions {

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * What if you cannot use additional data structures?
   *
   * runTime: O(n * log_n)
   *
   * @param str - the string to check
   * @return true if unique chars, otherwise false
   */
  public static boolean isUnique(String str) {
    if (str.length() == 0) { return true; }
    char arr[] = str.toCharArray();
    Arrays.sort(arr);
    char prev = arr[0];
    for (int i = 1; i < arr.length; ++i) {
      if (prev == arr[i]) { return false; }
    }
    return true;
  }

  /**
   * Given two strings, write a method to decide if one is a permutation of the other.
   *
   * Hint: there are 128 unique characters in English (ASCII characters)
   *
   * runTime: O(n)
   * @return true if permutation, false otherwise
   */
  public static boolean checkPermutation(String str1, String str2) {
    int charCount[] = new int[128];
    Arrays.fill(charCount, -1);
    for (int i = 0; i < str1.length(); ++i) {
      ++charCount[str1.charAt(i)];
    }
    for (int i = 0; i < str2.length(); ++i) {
      --charCount[str2.charAt(i)];
      if (charCount[str2.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Write a method to replace all spaces in a string with '%20'.
   * You may assume that the string has sufficient space at the end to hold the additional characters,
   * and that you are given the "true" length of the string.
   * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
   *
   * runtime: O(n)
   * @return the URL version of the string
   */
  public static String URLify(char[] str) {
    if (str.length == 0) {
      return null;
    }
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < str.length; ++i) {
      char c = str[i];
      if (c != ' ') {
        output.append(c);
      } else {
        output.append("%20");
      }
    }

    return output.toString();
  }

  /**
   * Given a string, write a function to check if it is a permutation of a palindrome.
   * A palindrome is a word or phrase that is the same forwards and backwards.
   * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
   *
   * Runtime: O(n)
   *
   * @return true if palindrome, false otherwise
   */
  public static boolean palindromePermutation(String str) {
    int count = 0;
    int arr[] = new int[128];
    for (int i = 0; i < str.length(); ++i) {
      int index = str.charAt(i);
      if (++arr[index] % 2 != 0) {
        ++count;
      } else {
        --count;
      }
    }
    return str.length()%2 == 0 ? count == 0 : count == 1;
  }

  /**
   * There are three types of edits that can be performed on strings:
   * insert a character, remove a character, or replace a character.
   * Given two strings, write a function to check if they are one edit (or zero edits) away.
   *
   * @return true if one edit away, false otherwise
   */
  public static boolean oneAway(String str1, String str2) {
    if (Math.abs(str1.length() - str2.length()) > 1) return false;
    if (str1.equals(str2)) return true;
    /**
     * Part 1: Insert or remove a character. Runtime O(n)
     * means difference in length of strings is 1 char
     * Create hash table for longer string, where key is character and value is occurrence
     * loop through shorter string, search hash table for each character and subtract from the value
     * if the value of any key is negative, return false
     * Part 2: replace a character - strings are same length. Runtime O(n)
     * create hash table for str1 w/ key as char, value as occurrence
     * search hash table for each character in str2 and decrement 1 from the value of each char
     * only allow one value to be -1, if more than one value is -1 return false
     */
    int map[] = new int[128];
    if (str1.length() != str2.length()) { // insert or remove
      String longer, shorter;
      if (str1.length() > str2.length()) {
        longer = str1;
        shorter = str2;
      } else {
        longer = str2;
        shorter = str1;
      }
      for (int i = 0; i < longer.length(); ++i) {
        ++map[longer.charAt(i)];
      }
      for (int i = 0; i < shorter.length(); ++i) {
        if (--map[shorter.charAt(i)] < 0) return false;
      }
    } else { // replace
      for (int i = 0; i < str1.length(); ++i) {
        ++map[str1.charAt(i)];
      }
      int count = 0;
      for (int i = 0; i < str2.length(); ++i) {
        if (--map[str2.charAt(i)] < 0) ++count;
        if (count > 1) return false;
      }
    }
    return true;
  }

  /**
   *  Implement a method to perform basic string compression using the counts of repeated characters.
   *  For example, the string aabcccccaaa would become a2blc5a3.
   *  If the "compressed" string would not become smaller than the original string, your method should return the original string.
   *  You can assume the string has only uppercase and lowercase letters (a -z).
   *
   * @param str - the string to compress
   * @return the compressed string
   */
  public static String stringCompression(String str) {
    return null;
  }

}
