package arrays.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Write a function that takes in a non-empty array of arbitrary intervals, merges any overlapping intervals, and
    returns the new intervals in no particular order.

    Each interval is an array of two integers, with interval[0] as the start of the interval and interval[1] as the end
    of the interval.

    Note: Back-to-back intervals aren't considered to be overlapping. For example, [1, 5] and [6, 7] aren't overlapping;
    however, [1, 6] and [6, 7] are indeed overlapping. Also, note that the start of any particular interval will always
    be less than or equal to the end of that interval.

    Input: intervals = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]

    Output: [[1, 2], [3, 8], [9, 10]]    // Merge the intervals [3, 5], [4, 7], [6, 8].
                                                // The intervals can be ordered differently.
*/

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[5][2];
        intervals[0][0] = 1;
        intervals[0][1] = 2;
        intervals[1][0] = 3;
        intervals[1][1] = 5;
        intervals[2][0] = 4;
        intervals[2][1] = 7;
        intervals[3][0] = 6;
        intervals[3][1] = 8;
        intervals[4][0] = 9;
        intervals[4][1] = 10;

        System.out.println(Arrays.deepToString(intervals));
        System.out.println(Arrays.deepToString(mergeOverlappingIntervals(intervals)));
        System.out.println();
    }

    /**
     * @param intervals - the input intervals array
     * @return - merged overlapping intervals array
     */
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        mergedIntervals.add(currentInterval);

        for (int[] nextInterval : intervals) {
            int currentIntervalEnd = currentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];

            if (currentIntervalEnd >= nextIntervalStart) {
                currentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                currentInterval = nextInterval;
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}

/*
    O(nlog(n)) time | O(n) space
        n = length of the input array
    1. Sort the intervals in the input array.
    2. Traverse the intervals array using i as index.
        Init. arraylist of new int arrays[1][2].
    2. The first new array index should be new int[intervals[i, 0], ?]
    3. While intervals[i, 1] >= intervals[i+1, 0],
        merge the intervals. -> [intervals[i, 0], intervals[i+1, 1]]
    4. Else, add new int array[1][2] interval to arraylist.
*/
