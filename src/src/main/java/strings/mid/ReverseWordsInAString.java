package strings.mid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Write a function that takes in a string of words separated by one or more whitespaces and returns a
    string that has these words in reverse order.

    For this problem, a word can contain special characters, punctuation, and numbers. The words in the
    string will be separated by one or more whitespaces, and the reversed string must contain the same
    number of whitespaces as the original string.

    Note: You are not allowed to use any built-in "split" or "reverse" methods/functions. However, you
    are allowed to use a built-in join method/function.
    Also, the input isn't guaranteed to always contain words.

    Sample Input: "Reverse this string."

    Sample Output: "string. this Reverse"
*/

public class ReverseWordsInAString {

    public static void main(String[] args) {
        String stringToReverse = "Reverse this string.";
        String edgeCase1 = " Reverse this  string.  ";
        String edgeCase2 = "";
        String edgeCase3 = "    ";

        String input = "Input: ";
        String output = "Output: ";

        System.out.println(input + "'" + stringToReverse + "'");
        System.out.println(output + "'" + reverseWordsInString1(stringToReverse) + "'");
        System.out.println(output + "'" + reverseWordsInString2(stringToReverse) + "'");
        System.out.println(input + "'" + edgeCase1 + "'");
        System.out.println(output + "'" + reverseWordsInString2(edgeCase1) + "'");
        System.out.println(input + "'" + edgeCase2 + "'");
        System.out.println(output + "'" + reverseWordsInString2(edgeCase2) + "'");
        System.out.println(input + "'" + edgeCase3 + "'");
        System.out.println(output + "'" + reverseWordsInString2(edgeCase3) + "'");
    }

    /**
     * @param stringToReverse - the input string to reverse.
     * @return - the reversed string
     */
    public static String reverseWordsInString1(String stringToReverse) {
        List<String> words = new ArrayList<>();
        int startOfWord = 0;

        for (int i = 0; i < stringToReverse.length(); i++) {
            if (stringToReverse.charAt(i) == ' ') {
                words.add(stringToReverse.substring(startOfWord, i));
                startOfWord = i;
            } else if (stringToReverse.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = i;
            }
        }
        words.add(stringToReverse.substring(startOfWord));
        Collections.reverse(words);

        return String.join("", words);
    }

    /**
     * @param stringToReverse - the input string to reverse.
     * @return - the reversed string
     */
    public static String reverseWordsInString2(String stringToReverse) {
        char[] characters = stringToReverse.toCharArray();
        reverseArrayWithRange(characters, 0, characters.length-1);

        int startOfWord = 0;
        while (startOfWord < characters.length) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }
            reverseArrayWithRange(characters, startOfWord, endOfWord-1);
            startOfWord = endOfWord + 1;
        }
        return new String(characters);
    }

    /**
     * @param characters - the characters array
     * @param start - the start index
     * @param end - the end index
     */
    private static void reverseArrayWithRange(char[] characters, int start, int end) {
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}

/*
    Reverse Words In String Approach 1 : O(n) time | O(n) space
        n = length of string

    1. Init. words list.
    2. Init. start of word index = 0.
    3. Traverse string checking the char at the current index.
        a. If the character at current index = ' ', add the word (substring from start of word to current index).
            Reset start of word to current index.
        b. Else if the character at start fo word = ' ', add the space.
            Reset start of word to current index.
        c. If neither, continue traversing the string.
     4. Once we have traversed the entire string, we must add the last word (substring beginning at start fo word).
     5. Reverse this words list.
     6. Use Join method with "" as a delimiter on words list.

    Reverse Words In String Approach 2 : O(n) time | O(n) space
        n = length of string

    1. Init. characters array with input string.
    2. Reverse the characters array with range.
        a. traverse array while start range < end range.
        b. Init temp char variable = array[start].
        c. Set array[start] = array[end]
        d. Set array[end] = temp.
        e. start = start + 1 && end = end - 1
    3. Init start of word index = 0.
    3. Traverse array while start of word index > length of array.
        a. Init end of word index = start of word index.
        b. While the end of word index < array length && array[end of word index] != ' ', end of word index += 1.
     4. Reverse the characters array with range start of word and end of word - 1 (we don't want the white space,
        hence -1).
     5. Set start of word index = end of word index + 1 (we want to continue traversing the array, hence the +1).
     6. Return new String(array).
*/
