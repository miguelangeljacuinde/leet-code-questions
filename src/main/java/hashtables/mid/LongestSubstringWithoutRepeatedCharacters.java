package hashtables.mid;

import java.util.HashMap;
import java.util.Map;

/*
    #3
    Given a string s, find the length of the longest substring without duplicate characters.

    - Example 1:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

    - Example 2:
        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

    - Example 3:
        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    - Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
*/

public class LongestSubstringWithoutRepeatedCharacters {

    /**
     * This method finds the length of the longest substring without repeating characters.
     *
     * @param s - the input string
     * @return - the length of the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int start = 0;
        int end = 0;

        Map<Character, Integer> uniqueCharMap = new HashMap<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            if (uniqueCharMap.containsKey(currentChar)) {
                start = Math.max(start, uniqueCharMap.get(currentChar) + 1);
            }
            uniqueCharMap.put(currentChar, end++);
            longest = Math.max(longest, end - start);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }

}

/*
    O(n) time | O(min(n, m)) space
        n = length of the input string s.
    1. Initialize an integer to keep track of the longest substring, a start and end pointer (both starting at 0), and
        a HashMap to store the characters and their latest indices.
    2. Iterate through the string using the end pointer.
    3. If the character at the end pointer is already in the HashMap, update the start pointer to point to the maximum
        of the start index or the index of the character + 1.
    4. Add the character and its index to the HashMap.
    5. Update the longest substring length to the maximum of the current longest substring or the difference between
        the end and start pointers.
    6. Return the longest substring length.
*/
