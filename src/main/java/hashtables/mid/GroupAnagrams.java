package hashtables.mid;

/*
    #49
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    - Example 1:
        Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        Explanation:
            There is no string in strs that can be rearranged to form "bat".
            The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
            The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

    - Example 2:
        Input: strs = [""]
        Output: [[""]]

    - Example 3:
        Input: strs = ["a"]
        Output: [["a"]]

    - Constraints:
        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] consists of lowercase English letters.
*/

import java.util.*;

public class GroupAnagrams {

    /**
     * Groups anagrams from the given array of strings.
     *
     * @param strs the input array of strings
     * @return a 2D array containing grouped anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.putIfAbsent(sortedStr, new ArrayList<>());
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Input: " + Arrays.toString(input));
        List<List<String>> result = groupAnagrams(input);
        printResult(result);

        String[] input2 = {""};
        System.out.println("Input: " + Arrays.toString(input2));
        List<List<String>> result2 = groupAnagrams(input2);
        printResult(result2);

        String[] input3 = {"a"};
        System.out.println("Input: " + Arrays.toString(input3));
        List<List<String>> result3 = groupAnagrams(input3);
        printResult(result3);
    }

    /**
     * Prints the grouped anagrams.
     *
     * @param result the list of grouped anagrams
     */
    private static void printResult(List<List<String>> result) {
        System.out.println("Anagrams : ");
        for (List<String> group : result) {
            System.out.println("        " + group);
        }
    }

}

/*
    O(n * k log k) time | O(n * k) space
        n = the number of strings and k is the maximum length of a string.
    1. Initialize a HashMap to store sorted strings as keys and lists of anagrams as values.
    2. For each string in the input array:
        a. Convert the string to a character array.
        b. Sort the character array.
        c. Convert the sorted character array back to a string.
        d. Create this sorted string as a key in the HashMap if absent.
        e. Add the original string to the list of anagrams for this sorted key.
    3. Return the values of the HashMap as a list of lists.
*/