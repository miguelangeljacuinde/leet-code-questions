package strings.mid;

/*
    #5
    Given a string s, return the longest palindromic substring in s.

    - Example 1:
        Input: s = "babad"
        Output: "bab"
        Explanation: "aba" is also a valid answer.

    - Example 2:
        Input: s = "cbbd"
        Output: "bb"

    - Constraints:
        1 <= s.length <= 1000
        s consist of only digits and English letters.
*/

public class LongestPalindromicSubstring {

    /**
     * Finds the longest palindromic substring in the given string.
     *
     * @param s the input string
     * @return the longest palindromic substring
     */
    public static String longestPalindromicSubstring(String s) {
        int[] longest = new int[]{0, 1};

        for (int i = 1; i < s.length(); i++) {
            int[] odd = getLongestPalindromeFrom(s, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(s, i - 1, i);
            int[] currentLongest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;

            longest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                    ? currentLongest
                    : longest;
        }
        return s.substring(longest[0], longest[1]);
    }

    /**
     * Helper method to find the longest palindrome substring from a given center.
     *
     * @param s     the input string
     * @param left  the left index of the center
     * @param right the right index of the center
     * @return an array containing the start and end indices of the longest palindrome substring
     */
    private static int[] getLongestPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Input string : " + s);
        System.out.println("Longest Palindromic String : " + longestPalindromicSubstring(s));

        s = "cbbd";
        System.out.println("\nInput string : " + s);
        System.out.println("Longest Palindromic String : " + longestPalindromicSubstring(s));

        s = "a";
        System.out.println("\nInput string : " + s);
        System.out.println("Longest Palindromic String : " + longestPalindromicSubstring(s));

        s = "a xyzzyxyzzyxa";
        System.out.println("\nInput string : " + s);
        System.out.println("Longest Palindromic String : " + longestPalindromicSubstring(s));
    }

}

/*
    O(n^2) time | O(n) space
        n = number of characters in a string.
    1. Initialize an array to keep track of the longest palindrome found.
    2. Iterate through each character in the string starting from the second character.
    3. For each character, check for both odd and even length palindromes.
        a. For odd length, expand around the center character (from i - 1 to i + 1 where i is the center).
        b. For even length, expand around the center between the current character and the previous one
            (from i - 1 to i).
    4. Compare the lengths of the found palindromes and store in currentLongest.
    5. If the current longest palindrome is longer than the longest, update it.
    6. Return the longest palindromic substring using the indices stored in the longest array.
*/
