package strings.easy;

import java.util.*;

/*
    Write a function that takes in a non-empty list of non-empty strings and returns a list
    of characters that are common to all strings in the list, ignoring multiplicity.

    Not: Strings are not guaranteed to only contain alphanumeric characters. The list can
    be in anu order.

    Sample Input: strings = ["abc", "bcd", "cbaccd"]

    Sample Output: ["b", "c"] <- the characters can be ordered differently.
*/
public class CommonCharacters {
    public static void main(String[] args) {
        String[] strings = new String[]{"abc", "bcd", "cbaccd"};
        String[] edgeCase1 = new String[]{"*abcd ", "def* ", "******d *****"};
        String[] edgeCase2 = new String[]{"abcde", "aa", "foobar", "foobaz", "and this is a string", "aaaaaaaa", "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeea"};
        String[] edgeCase3 = new String[]{"z"};

        System.out.println(Arrays.toString(commonCharactersApproach1(strings)));
        System.out.println(Arrays.toString(commonCharactersApproach2(edgeCase1)));
        System.out.println(Arrays.toString(commonCharactersApproach2(edgeCase2)));
        System.out.println(Arrays.toString(commonCharactersApproach2(edgeCase3)));
    }

    /**
     * @param listOfStrings - the list of strings
     * @return - list of chars. that are common to all strings in the list
     */
    public static String[] commonCharactersApproach1(String[] listOfStrings) {
        HashMap<Character, Integer> charCounts = getCharacterIntegerHashMap(listOfStrings);
        ArrayList<Character> finalCharsList = getfinalCharCountArrayList(listOfStrings, charCounts);
        String[] finalCharArray = new String[finalCharsList.size()];

        for (int i = 0; i < finalCharArray.length; i++) {
            finalCharArray[i] = finalCharsList.get(i).toString();
        }

        return finalCharArray;
    }

    /**
     * @param listOfStrings - the list of strings
     * @return - HashMap of character counts
     */
    private static HashMap<Character, Integer> getCharacterIntegerHashMap(String[] listOfStrings) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (String string : listOfStrings) {
            HashSet<Character> uniqueCharStrings = new HashSet<>();
            for (int i = 0; i < string.length(); i++) {
                uniqueCharStrings.add(string.charAt(i));
            }

            for (char character : uniqueCharStrings) {
                if (!charCounts.containsKey(character)) {
                    charCounts.put(character, 0);
                }
                charCounts.put(character, charCounts.get(character) + 1);
            }
        }
        return charCounts;
    }

    /**
     * @param listOfStrings - the list of strings
     * @param charCounts    - the character count
     * @return - arraylist of final characters
     */
    private static ArrayList<Character> getfinalCharCountArrayList(String[] listOfStrings, HashMap<Character, Integer> charCounts) {
        ArrayList<Character> finalCharsList = new ArrayList<>();

        for (Map.Entry<Character, Integer> charCount : charCounts.entrySet()) {
            Character character = charCount.getKey();
            Integer count = charCount.getValue();
            if (count.equals(listOfStrings.length)) {
                finalCharsList.add(character);
            }
        }
        return finalCharsList;
    }

/*************************************************************************************************************************************/

    /**
     * @param listOfStrings - the list of strings
     * @return - list of chars. that are common to all strings in the list
     */
    public static String[] commonCharactersApproach2(String[] listOfStrings) {
        String smallestString = getSmallestString(listOfStrings);
        HashSet<Character> potentialCommonChars = new HashSet<>();
        for (int i = 0; i < smallestString.length(); i++) {
            potentialCommonChars.add(smallestString.charAt(i));
        }

        for (String string : listOfStrings) {
            removeNonexistentChars(string, potentialCommonChars);
        }

        String[] output = new String[potentialCommonChars.size()];
        int i = 0;
        for (Character character : potentialCommonChars) {
            output[i] = character.toString();
            i++;
        }
        return output;
    }

    /**
     * @param listOfStrings - the list of strings
     * @return - smallest string within the list of strings
     */
    private static String getSmallestString(String[] listOfStrings) {
        String smallestString = listOfStrings[0];
        for (String string : listOfStrings) {
            if (string.length() < smallestString.length()) {
                smallestString = string;
            }
        }
        return smallestString;
    }

    /**
     * @param string               - the current string
     * @param potentialCommonChars - the set of potential common characters
     */
    private static void removeNonexistentChars(String string, HashSet<Character> potentialCommonChars) {
        HashSet<Character> uniqueStringChars = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            uniqueStringChars.add(string.charAt(i));
        }

        HashSet<Character> charsToRemove = new HashSet<>();
        for (char character : potentialCommonChars) {
            if (!uniqueStringChars.contains(character)) {
                charsToRemove.add(character);
            }
        }
        for (char character : charsToRemove) {
            potentialCommonChars.remove(character);
        }
    }

}

/*
    Common Characters Approach 1 : O(n*m) time | O(c) space
        n = num of strings,
        m = len of longest string,
        c = num of unique chars across all strings.

    1. Init. HashMap to keep count of each char.
    2. Traverse every string in list of strings and convert to HashSet to filter duplicate chars.
    3. For each char in set, init. count with 0. Then put the count of that char to 1.
    4. Init. final char arraylist.
    5. Traverse HashMap and get the char and count for each entry set.
        a. If the count = strings length, we add it to the final char arraylist.
    6. Init final char array with length of arraylist.
    7. Traverse array and place each char as a string.
    8. Return the string array.

    Common Characters Approach 2 : O(n*m) time | O(m) space
        n = num of strings,
        m = len of longest string.

    1. Find the smallest string in the list.
    2. Init. HashSet to get potential common characters.
    3. Traverse smallest string and add each character to the set.
    4. Traverse list of strings and remove non-existing chars from the set.
        a. Init new HashSet of unique chars for each string in list of strings.
        b. Check if potential char set contains char in unique char set. If it does not, remove it from potential char set.
    5. Init output array and iterator.
    6. Traverse every char in potential char set and add it to array as a string.
    7. Return the string array.
*/