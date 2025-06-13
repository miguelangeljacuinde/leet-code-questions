package strings.easy;

/*
    #125
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
    non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and
    numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Assume case-insensitivity and ignore spaces.

    - Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.

    - Example 2:
        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.

    - Example 3:
        Input: s = " "
        Output: true
        Explanation: s is an empty string "" after removing non-alphanumeric characters.
        Since an empty string reads the same forward and backward, it is a palindrome.

    - Constraints:
        1 <= s.length <= 2 * 105
        s consists only of printable ASCII characters.
*/

public class ValidPalindrome {

    /**
     * @param s - the input string
     * @return true if string is a palindrome
     */
    public static boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start <= end) {
            while (start < end && !Character.isLetterOrDigit(charArray[start])) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(charArray[end])) {
                end--;
            }

            if (Character.toLowerCase(charArray[start]) != Character.toLowerCase(charArray[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * This method uses regular expressions to check if the string is a valid palindrome.
     *
     * @param s - the input string
     * @return true if the string is a valid palindrome, false otherwise
     */
    public static boolean validPalindromeWithRegex(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Input string : " + s);
        System.out.println("Is the string a valid palindrome? " + validPalindromeWithRegex(s));

        s = "race a car";
        System.out.println("\nInput string : " + s);
        System.out.println("Is the string a valid palindrome? " + validPalindrome(s));

        s = " ";
        System.out.println("\nInput string : " + s);
        System.out.println("Is the string a valid palindrome? " + validPalindrome(s));
    }

}

/*
    With Character Class: O(n) time | O(1) space
        n = number of characters in the string.
    1. Initialize two pointers, one pointing to the start of the string and one pointing to the end of the string.
    2. Loop until the two pointers meet.
        a. Move the start pointer to the right until it points to an alphanumeric character.
        b. Move the end pointer to the left until it points to an alphanumeric character.
    3. Compare the characters at the two pointers :
        a. If they are not equal, return false.
        b. If they are equal, move both pointers inward.
    4. If the loop completes, return true.

    With Regular Expressions: O(n) time | O(1) space
        n = number of characters in the string.
    1. Convert the string to lowercase and remove all non-alphanumeric characters using regular expressions.
    2. Initialize two pointers, one pointing to the start of the string and one pointing to the end of the string.
    3. Loop until the two pointers meet.
        a. Compare the characters at the two pointers.
        b. If they are not equal, return false.
        c. If they are equal, move both pointers inward.
    4. If the loop completes, return true.
*/
