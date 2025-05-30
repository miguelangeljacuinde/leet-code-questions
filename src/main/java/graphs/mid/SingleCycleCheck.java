package graphs.mid;

/*
    You're given an array of integers where each integer represents a jump of its value in the array.
    For instance, the integer 2 represents a jump of two indices forward in the array;
        the integer -3 represents a jump of three backward in the array.

    If a jump spills past the array's bounds, it wraps over to the other side.
    For instance, a jump of -1 at index 0 brings us back to the last index in the array.
    Similarly, a jump of 1 at the last index brings us to index 0.

    Write a function that returns a boolean representing whether the jumps in the array form a single cycle.
    A single cycle occurs if, starting at any index in the array and following the jumps, every element in the array
    is visited exactly once before landing back on the starting index.

    Input: array = [2, 3, 1, -4, -4, 2]

    Output: true
*/
public class SingleCycleCheck {
    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, -4, -4, 2};
        System.out.println(hasSingleCycle(array));

        int[] edgeCase1 = new int[]{2};
        System.out.println(hasSingleCycle(edgeCase1));

        int[] edgeCase2 = new int[]{1, -1, 1, -1};
        System.out.println(hasSingleCycle(edgeCase2));

        int[] edgeCase3 = new int[]{0, 1, 2};
        System.out.println(hasSingleCycle(edgeCase3));

        int[] edgeCase4 = new int[]{-1, -1};
        System.out.println(hasSingleCycle(edgeCase4));
    }

    /**
     * @param array - the input array
     * @return - boolean true if array contains a single cycle
     */
    public static boolean hasSingleCycle(int[] array) {
        int startingIndex = 0;
        int elementsVisited = 0;
        System.out.print(array[startingIndex] + " -> ");

        while (elementsVisited < array.length) {
            if (elementsVisited > 0 && startingIndex == 0) {
                return false;
            }
            elementsVisited++;
            startingIndex = nextIndex(startingIndex, array);
        }
        return startingIndex == 0;
    }

    /**
     * @param startingIndex - the starting index
     * @param array         - the array
     * @return - the next index
     */
    public static int nextIndex(int startingIndex, int[] array) {
        int jump = array[startingIndex];
        int nextIndex = (startingIndex + jump) % array.length;
        if (nextIndex >= 0)
            System.out.print(array[nextIndex] + " -> ");
        else
            System.out.print(array[nextIndex + array.length] + " -> ");
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

}

/*
    O(n) time | O(1) space
        n = length of the input array
    1. Initialize the starting index and the number of elements visited as 0.
    2. While the number of elements visited is less than the total elements in array (array length),
        a. If the number of elements visited is greater than 0 but the starting index does not equal 0 (the first index)
            return false
        b. Else, increase the number of elements visited, and reset the starting index to be equal to the next index
            after calculating the jump.
    3. Initialize the jump variable as: array[starting index]
    4. Initialize the next variable as: (starting index + jump) % length of array (used to wrap around the array when
        index is out of bounds)
    5. Return the next index:
        a. If next is greater than or equal to 0, return next.
        b. Else return next + array length (handles the negative scenarios)
    6. Return true if starting index is back to 0 if number of elements visited is greater than the length of array.
*/
