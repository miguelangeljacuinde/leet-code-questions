package strings.mid;

import java.util.ArrayList;
import java.util.Arrays;
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
        reverseListRange(characters, 0, characters.length-1);

        int startOfWord = 0;
        while (startOfWord < characters.length) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }
            reverseListRange(characters, startOfWord, endOfWord-1);
            startOfWord = endOfWord + 1;
        }
        return new String(characters);
    }

    /**
     * @param characters - the characters array
     * @param start - the start index
     * @param end - the end index
     * @return - the reversed characters list
     */
    private static char[] reverseListRange(char[] characters, int start, int end) {
        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start += 1;
            end -= 1;
        }
        return characters;
    }

}

/*

*/
