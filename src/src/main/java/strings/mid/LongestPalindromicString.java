package strings.mid;

/*
    Write a function that, given a string, returns its longest palindromic string.

    A palindrome is defined as a string that's written the same forward and backward.

    Note: Single-character strings are palindromes.
    Assume there will only be one longest palindromic string.

    Sample Input: string = "it's highnoon"

    Sample Output: "noon"
*/

public class LongestPalindromicString {
    public static void main(String[] args) {
        String string = "babad";
        System.out.println(string);
        System.out.println(longestPalindromicSubstring(string));

        String edgeCase1 = "a";
        System.out.println(edgeCase1);
        System.out.println(longestPalindromicSubstring(edgeCase1));

        String edgeCase2 = "a xyzzyxyzzyxa";
        System.out.println(edgeCase2);
        System.out.println(longestPalindromicSubstring(edgeCase2));
    }

    /**
     * @param string - the input string
     * @return - the longest palindromic substring
     */
    public static String longestPalindromicSubstring(String string) {
        int[] currentLongest = new int[]{0, 1};
        for (int i = 1; i < string.length(); i++) {
            int[] odd = getLongestPalindromeFrom(string, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(string, i - 1, i);
            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currentLongest = currentLongest[1] - currentLongest[0] > longest[1] - longest[0]
                    ? currentLongest
                    : longest;
        }
        return string.substring(currentLongest[0], currentLongest[1]);
    }

    /**
     * @param s     - the input string
     * @param left  - the left index
     * @param right - the right index
     * @return - the longest palindrome from left index to right index
     */
    private static int[] getLongestPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right};
    }

}

/*
    O(n^2) time | O(n) space
        n = number of characters in a string.

    1. Init. a current longest int array with two indexes referring to the left index and right index respectively
        {0, 1}.
    2. Traverse the string starting at index 1.
    3. Init. an odd int array to check for a palindrome with an odd number of characters, looking at i-1 and i+1 to
        be equal.
       Init. an even int array to check for a palindrome with an even number of characters, looking at i-1 and i to
        be equal.
            a. You can get the palindrome by calling getLongestPalindromeFrom method which returns a new int array
            with {left index + 1, right index} (substring can be described as {inclusive, exclusive})
    5. Init. the longest int array which checks which palindrome is longer (odd or even).
        a. You can check by subtracting the right index with the left index.
    6. Store the current longest by comparing the current longest and the longest.
        a. You can check by subtracting the right index with the left index.
    7. Return that actual substring of the current longest array {0, 1}.
*/