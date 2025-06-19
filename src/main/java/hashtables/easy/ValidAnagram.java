package hashtables.easy;

import java.util.HashMap;
import java.util.Map;

/*
    #242
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    - Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true

    - Example 2:
        Input: s = "rat", t = "car"
        Output: false

    - Constraints:
        1 <= s.length, t.length <= 5 * 104
        s and t consist of lowercase English letters.

    - Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

public class ValidAnagram {

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param s the first string
     * @param t the second string
     * @return true if t is an anagram of s, false otherwise
     */
    public static boolean isAnagramWithHashMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false;
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
        }
        return true;
    }

    /**
     * Checks if two strings are anagrams of each other using ASCII values.
     *
     * @param s the first string
     * @param t the second string
     * @return true if t is an anagram of s, false otherwise
     */
    public static boolean isAnagramWithUsingAsciiValues(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int i : charCount) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println("Input strings: " + s1 + ", " + s2);
        System.out.println("Is anagram? " + isAnagramWithHashMap(s1, s2));

        s1 = "rat";
        s2 = "car";
        System.out.println("Input strings: " + s1 + ", " + s2);
        System.out.println("Is anagram? " + isAnagramWithUsingAsciiValues(s1, s2));
    }

}

/*
    With HashMap : O(n) time | O(1) space
        n = the length of the strings s and t.
    1. If the lengths of s and t are not equal, return false.
    2. Create a HashMap to count the occurrences of each character in s.
    3. Iterate through each character in s, updating the count in the HashMap.
    4. Iterate through each character in t, checking if it exists in the HashMap.
        a. If any character in t does not match the count in the HashMap, return false.
        b. Decrement the count of the current character.
    5. If all characters match, return true.

    With ASCII values : O(n) time | O(1) space
        n = the length of the strings s and t.
    1. If the lengths of s and t are not equal, return false.
    2. Create an array of size 26 to count the occurrences of each character (assuming all lowercase English letters).
    3. Iterate through each character in s and t simultaneously, updating the count in the array.
    4. After processing both strings, check if all counts in the array are zero.
    5. If all counts are zero, return true; otherwise, return false.
*/