package arrays.easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given two non-empty arrays of integers, write a function that determines whether the second
    array is a subsequence of the first.

    A subsequence os an array is a set of numbers that aren't necessarily adjacent in the array
    but that are in the same order as they appear in the array. For instance the numbers
    [1, 3, 4] form a subsequence of [1, 2, 3, 4], and so do the numbers [2, 4].

    Note: A single number in an array and the array itself are both valid subsequences of
    the array.

    Input: array = [5, 1, 22, 25, 6, -1, 8, 10]
                  sequence = [1, 6, -1, 10]

    Output: true
 */

public class ValidateSequence {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(List.of(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList<>(List.of(1, 6, -1, 10));

        System.out.println(isValidSubsequence(array, sequence));
    }

    /**
     * @param array    - the input array
     * @param sequence - the input sequence
     * @return boolean true if sequence is a subset of array
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }
        return sequence.size() == seqIdx;
    }

}

/*
    O(n) time | O(1) space :

    1. Init. pointers for each array
    2. Traverse the array and sequence at the same time once.
    3. If the current numbers are equal, move on to the next number in the sequence. sequence++.
    4. Move on to the next number in the array. array++.
    5. Check whether it is a subsequence. The sequence index and size should be the same.
*/
