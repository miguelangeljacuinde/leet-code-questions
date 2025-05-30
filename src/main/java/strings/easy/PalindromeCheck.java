package strings.easy;

/*
    Write a function that takes in a non-empty string and that returns a boolean representing
    whether the string is a palindrome.
    A palindrome is a string that's written the same forward and backward.

    Note: Single character letters are palindromes.

    Input: string = "abcdcba"

    Output: true
*/

public class PalindromeCheck {
    public static void main(String[] args) {
        String palindrome = "abcba";

        System.out.println(isPalindrome(palindrome));
    }

    /**
     * @param str - the input string
     * @return true if string is a palindrome
     */
    public static boolean isPalindrome(String str) {
        char[] strArr = str.toCharArray();
        int startIndex = 0;
        int endIndex = str.length() - 1;

        while (startIndex <= endIndex) {
            if (strArr[startIndex] == strArr[endIndex]) {
                startIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }

}

/*
    1. Turn string into a char array.
    2. Init a starting and ending index.
    3. Traverse array; while the start idx is <= end idx
        Check if the char at start idx == char at end idx.
        If they are equal, continue traversing until the end.
    4. return true if start idx = end idx, else return false
*/
