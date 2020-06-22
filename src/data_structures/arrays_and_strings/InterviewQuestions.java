package data_structures.arrays_and_strings;

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

}
