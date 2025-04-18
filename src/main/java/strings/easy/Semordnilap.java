package strings.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
    Write a function that takes in a list of unique strings and returns a list of semordnilap pairs.

    A semordnilap pair is defined as a set of different strings where the reverse of one word is the same as the
    forward version of the other.
        e.g. "diaper" and "repaid" are semordnilap pairs.
            as are the words "palindromes" and "semordnilap".

    Note: The order of the returned pairs and the order of the strings within each pair does not matter.

    Sample Input: words = ["diaper", "abc", "test", "cba", "repaid"]

    Sample Output: [["diaper", "repaid"], ["abc", "cba"]]
*/

public class Semordnilap {

    public static void main(String[] args) {
        String[] words = new String[]{"diaper", "abc", "test", "cba", "repaid"};
        System.out.println(semordnilap(words));

        String[] edgeCase1 = new String[]{};
        System.out.println(semordnilap(edgeCase1));

        String[] edgeCase2 = new String[]{"semordnilap"};
        System.out.println(semordnilap(edgeCase2));
    }

    /**
     * @param words - the input words array
     * @return - an arraylist of semordnilap pairs
     */
    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        HashSet<String> wordsSet = new HashSet<>(List.of(words));
        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<>();

        for (String word : words) {
            String reversedWord = String.valueOf(new StringBuilder(word).reverse());

            if (wordsSet.contains(reversedWord) && !reversedWord.equals(word)) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(reversedWord);
                semordnilapPairs.add(pair);

                wordsSet.remove(word);
                wordsSet.remove(reversedWord);
            }
            wordsSet.remove(word);
        }
        return semordnilapPairs;
    }

}

/*
    O(n*m) time | O(n*m) space
        n = number of words,
        m = length of the longest word

    1. Init. HashSet of strings using the words we are given in the input array.
    2. Init. Arraylist that holds an Arraylist of strings to store all the pairs.
    3. Traverse each word in the words array, and check for the reversed word of the current word using StringBuilder.
        a. If the set contains the reversed word and that reversed word != the current word,
            i. Init. a new Arraylist of strings to store the current pair.
            ii. Add the current word and the reversed word to the current pair.
            iii. Add the current pair to the pairs Arraylist.
            iv. Remove the current word and the reversed word from the set.
        b. Else, remove the current word from the set and continue traversing.
    4. Return the final pairs list.
*/