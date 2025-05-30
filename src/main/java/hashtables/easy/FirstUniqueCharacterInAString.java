package hashtables.easy;

/*
    #387
    Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
    return -1.

    - Example 1:
        Input: s = "leetcode"
        Output: 0
        Explanation:
            The character 'l' at index 0 is the first character that does not occur at any other index.

    - Example 2:
        Input: s = "loveleetcode"
        Output: 2

    - Example 3:
        Input: s = "aabb"
        Output: -1

    - Constraints:
        1 <= s.length <= 105
        s consists of only lowercase English letters.
*/

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    /**
     * Finds the index of the first unique character in the given string.
     *
     * @param s the input string
     * @return the index of the first unique character, or -1 if no unique character exists
     */
    public static int firstUniqChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (charCount.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "leetcode";
        int result = firstUniqChar(input);
        System.out.println("The index of the first unique character is : " + result);

        input = "loveleetcode";
        result = firstUniqChar(input);
        System.out.println("The index of the first unique character is : " + result);

        input = "aabb";
        result = firstUniqChar(input);
        System.out.println("The index of the first unique character is : " + result);
    }

}

/*
    O(n) time | O(1) space
        n = the length of the string s.
    1. Initialize a HashMap to store the count of each character in the string.
    2. Convert the string to a character array for easy iteration.
    3. Iterate through the character array and populate the HashMap with character counts (either with a default of
        0 + 1, count + 1).
    4. Iterate through the character array again and check the count of each character in the HashMap.
        a. If the count is 1, return the index of that character.
    6. If no unique character is found, return -1.
*/