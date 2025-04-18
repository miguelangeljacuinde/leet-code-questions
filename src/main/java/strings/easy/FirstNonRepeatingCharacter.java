package strings.easy;

/*
    Write a function that takes in a string of lowercase English-alphabet letters and returns the
    string's first non-repeating character.

    The first non-repeating character is the first character in a string that occurs only once.

    If the input string doesn't have any non-repeating characters, return empty string "";
*/

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String characters = "abcdcdb";
        String input = "Input:  ";
        String output = "Output: ";
        System.out.println(input + "'" + characters + "'");
        System.out.println(output + "'" + firstNonRepeatingCharacter(characters) + "'");

        String edgeCase1 = "";
        System.out.println(input + "'" + edgeCase1 + "'");
        System.out.println(output + "'" + firstNonRepeatingCharacter(edgeCase1) + "'");

        String edgeCase2 = "bbbbbaaaac";
        System.out.println(input + "'" + edgeCase2 + "'");
        System.out.println(output + "'" + firstNonRepeatingCharacter(edgeCase2) + "'");

        String edgeCase3 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy";
        System.out.println(input + "'" + edgeCase3 + "'");
        System.out.println(output + "'" + firstNonRepeatingCharacter(edgeCase3) + "'");

        String edgeCase4 = "aaabbbcccddd";
        System.out.println(input + "'" + edgeCase4 + "'");
        System.out.println(output + "'" + firstNonRepeatingCharacter(edgeCase4) + "'");
    }

    public static String firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            charFreq.put(currentChar, charFreq.getOrDefault(currentChar, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (charFreq.get(currentChar) == 1) {
                return String.valueOf(currentChar);
            }
        }
        return "";
    }

}

/*
    With HashMap : O(n) time | O(1) space
        n = number of elements in string.

    1. Init. HashMap to store the character and its frequency in the string.
    2. Traverse the string and get the current character to place inside the HashMap.
        a. If the current character is in the map already, set the frequency to frequency += 1.
        b. Else, default frequency = 0. Add 1.
    4. Traverse the string again and get the current character.
        a. If the current character's frequency = 1, return that character.
        b. Else, continue traversing.
    5. If we have traversed the entire string, there was no non-repeating character, return empty string "".
*/