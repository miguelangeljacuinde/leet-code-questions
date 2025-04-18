package strings.easy;

/*
    You're given a string of available characters and a string representing a document that you need
    to generate. Write a function that determines whether you can generate the document using the available characters.
    If you can, return true, else false.

    You're only able to generate the document if the frequency of unique characters in the characters string is
    greater than or equal to the frequency of unique characters in the document string.

    The document that you need to create may contain any characters, including special characters, capital letters,
    numbers, and spaces.

    Note: You can always generate the empty string "".

    Sample Input: characters = "abcabc"
                  document = "aabbccc"

    Sample Output: false -> missing one extra c
*/

import java.util.HashMap;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters = "abcabc";
        String document = "aabbccc";
        System.out.println(generateDocumentBruteForce(characters, document));
        System.out.println(generateDocumentWithHashMap(characters, document));

        String edgeCase1 = "helloworld ";
        String documentEdgeCase1 = "hello wOrld";
        System.out.println(generateDocumentWithHashMap(edgeCase1, documentEdgeCase1));

        String edgeCase2 = "";
        String documentEdgeCase2 = "";
        System.out.println(generateDocumentWithHashMap(edgeCase2, documentEdgeCase2));
    }

    /**
     * @param characters - the input characters
     * @param document   - the document we need to generate
     * @return - true if we can generate the document with the input characters
     */
    public static boolean generateDocumentBruteForce(String characters, String document) {
        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);
            int documentFreq = countCharFreq(character, document);
            int charFreq = countCharFreq(character, characters);

            if (documentFreq > charFreq) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param character - the current character
     * @param target    - the target
     * @return - frequency of characters
     */
    private static int countCharFreq(char character, String target) {
        int frequency = 0;
        for (int i = 0; i < target.length(); i++) {
            char currentChar = target.charAt(i);
            if (currentChar == character) {
                frequency += 1;
            }
        }
        return frequency;
    }

    /**
     * @param characters - the input characters
     * @param document   - the document we need to generate
     * @return - true if we can generate the document with the input characters
     */
    public static boolean generateDocumentWithHashMap(String characters, String document) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            char character = characters.charAt(i);
            charCounts.put(character, charCounts.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            char character = document.charAt(i);
            if (!charCounts.containsKey(character) || charCounts.get(character) == 0) {
                return false;
            }
            charCounts.put(character, charCounts.get(character) - 1);
        }
        return true;
    }

}

/*
    Brute Force Approach : O(m*(n+m)) time | O(1) space
        n = number of characters,
        m = length of the document.

    1. Traverse the document string.
    2. Get the current character and init. document frequency and character frequency (Integers).
    3. We count the frequency of each character in both the characters string and the document string and return each
        corresponding value (countCharFreq method).
    4. Compare the frequency of the characters string and the document string.
        a. If the document frequency > characters frequency, return false.
        b. Else, continue traversing the document string.
    5. If you traverse the entire document string return true.

    With HashMap: O(n+m) time | O(c) space
        n = number of characters,
        m = length of the document,
        c = unique number of characters in a string.

    1. Init. a HashMap to store the frequency of characters in the characters string.
    2. Traverse each character in characters string and add it to the HashMap.
        a. If the character is already in the map, get the frequency and set it to frequency += 1.
        b. Else, default = 0, set the frequency to 1.
    3. Traverse the document, checking whether each character in the document is also in the map.
        a. If the map does not contain the character, or if the character frequency in the map = 0, return false.
        b. Else, continue traversing throughout the document.
    4. If we have traversed the entire document then we return true.
*/
