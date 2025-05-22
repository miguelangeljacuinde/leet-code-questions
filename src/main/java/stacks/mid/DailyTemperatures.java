package stacks.mid;

/*
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that
    answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
    If there is no future day for which this is possible, keep answer[i] == 0 instead.

    - Example 1:
        Sample Input: temperatures = [73,74,75,71,69,72,76,73]
        Sample Output: [1,1,4,2,1,1,0,0]

    - Example 2:
        Sample Input: temperatures = [30,40,50,60]
        Sample Output: [1,1,1,0]

    - Example 3:
        Sample Input: temperatures = [30,60,90]
        Sample Output: [1,1,0]

    - Constraints:
        1 <= temperatures.length <= 105
        30 <= temperatures[i] <= 100
*/

import java.util.Stack;

public class DailyTemperatures {

    /**
     * This method calculates the number of days until a warmer temperature for each day.
     *
     * @param temperatures - the input array of daily temperatures
     * @return - an array where each element represents the number of days until a warmer temperature
     */
    public static int[] dailyTemperaturesWithStack(int[] temperatures) {
        int tempLength = temperatures.length;
        int[] result = new int[tempLength];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < tempLength; i++) {
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                int index = indexStack.pop();
                result[index] = i - index;
            }
            indexStack.push(i);
        }
        return result;
    }

    /**
     * This method calculates the number of days until a warmer temperature for each day using a brute-force approach.
     *
     * @param temperatures - the input array of daily temperatures
     * @return - an array where each element represents the number of days until a warmer temperature
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int tempLength = temperatures.length;
        int[] result = new int[tempLength];

        for (int i = 0; i < tempLength; i++) {
            for (int j = i + 1; j < tempLength; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Original temperatures: ");
        printArray(temperatures);
        int[] result = dailyTemperatures(temperatures);
        System.out.println("Result: ");
        printArray(result);

        int[] temperatures2 = {30, 40, 50, 60};
        System.out.println("\nOriginal temperatures: ");
        printArray(temperatures2);
        int[] result2 = dailyTemperaturesWithStack(temperatures2);
        System.out.println("Result: ");
        printArray(result2);

        int[] temperatures3 = {30, 60, 90};
        System.out.println("\nOriginal temperatures: ");
        printArray(temperatures3);
        int[] result3 = dailyTemperaturesWithStack(temperatures3);
        System.out.println("Result: ");
        printArray(result3);
    }

    public static void printArray(int[] temperatures) {
        for (int temp : temperatures) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }


}

/*
    With Stack:
    O(n) time | O(n) space
        n = length of the input temperatures.
    1. Initialize a stack to hold the indices of the temperatures.
    2. Initialize an array to hold the result.
    3. Iterate through the temperatures array:
        a. While the stack is not empty and the current temperature is greater than the temperature at the index
          stored at the top of the stack:
            i. pop the index from the stack and calculate the difference between the current index and the popped index.
        b. Push the current index onto the stack.
    4. Return the result array.
    Note: No need to explicitly set the remaining indices in the result array to 0, as they are already initialized to
    0 in the array.when we created the result array.

    With Brute-force:
    O(n^2) time | O(1) space
        n = length of the input temperatures.
    1. Initialize an array to hold the result.
    2. Iterate through the temperatures array:
        a. For each temperature, iterate through the remaining temperatures to find the next warmer temperature.
        b. If a warmer temperature is found, calculate the difference between the indices and store it in the result
            array.
    3. Return the result array.
*/