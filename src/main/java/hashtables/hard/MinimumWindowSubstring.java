package hashtables.hard;

import java.util.HashMap;
import java.util.Map;

/*
    #76
    Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
    character in t (including duplicates) is included in the window. If there is no such substring, return the empty
    string "".

    The testcases will be generated such that the answer is unique.

    - Example 1:
        Input: s = "ADOBECODEBANC", t = "ABC"
        Output: "BANC"
        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

    - Example 2:
        Input: s = "a", t = "a"
        Output: "a"
        Explanation: The entire string s is the minimum window.

    - Example 3:
        Input: s = "a", t = "aa"
        Output: ""
        Explanation: Both 'a's from t must be included in the window.
        Since the largest window of s only has one 'a', return empty string.

    - Constraints:
        m == s.length
        n == t.length
        1 <= m, n <= 105
        s and t consist of uppercase and lowercase English letters.

    - Follow up: Could you find an algorithm that runs in O(m + n) time?
*/

public class MinimumWindowSubstring {

    /**
     * This method finds the minimum window substring in string s that contains all characters of string t.
     *
     * @param s - the input string from which to find the substring
     * @param t - the string containing characters to be included in the substring
     * @return - the minimum window substring or an empty string if no such substring exists
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] charCountT = new int[128];
        for (char c : t.toCharArray()) {
            charCountT[c]++;
        }

        int required = t.length();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charCountT[currentChar] > 0) {
                required--;
            }
            charCountT[currentChar]--;
            right++;

            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    result = s.substring(left, right);
                }

                char leftChar = s.charAt(left);
                charCountT[leftChar]++;
                if (charCountT[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        return result;
    }

    /**
     * This method finds the minimum window substring in string s that contains all characters of string t using a HashMap.
     *
     * @param s - the input string from which to find the substring
     * @param t - the string containing characters to be included in the substring
     * @return - the minimum window substring or an empty string if no such substring exists
     */
    public static String minWindowWithHashMap(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> charCountT = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountT.put(c, charCountT.getOrDefault(c, 0) + 1);
        }

        int required = t.length();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (charCountT.containsKey(currentChar) && charCountT.get(currentChar) > 0) {
                required--;
            }
            charCountT.put(currentChar, charCountT.getOrDefault(currentChar, 0) - 1);
            right++;

            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    result = s.substring(left, right);
                }

                char leftChar = s.charAt(left);
                charCountT.put(leftChar, charCountT.getOrDefault(leftChar, 0) + 1);
                if (charCountT.get(leftChar) > 0) {
                    required++;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1));

        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow(s2, t2));

        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow(s3, t3));
    }
}

/*
    O(m + n) time | O(1) space
        m = length of string s, n = length of string t.
    1. We create an array to count the characters in t.
    2. We use two pointers to find the minimum window substring.
    3. We expand the right pointer until we have all characters from t.
    4. We contract the left pointer to find the minimum length substring.
    5. We return the result substring.
*/
