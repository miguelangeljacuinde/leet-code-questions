package stacks.mid;

/*
    #853
    There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
    You are given two integer array position and speed, both of length n, where position[i] is the starting mile of the
    ith car and speed[i] is the speed of the ith car in miles per hour.
    A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
    A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car
    in the fleet.
    If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
    Return the number of car fleets that will arrive at the destination.

    - Example 1:
        Sample Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        Sample Output: 3

        Explanation:
            The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
            The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
            The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.

    - Example 2:
        Sample Input: target = 10, position = [3], speed = [3]
        Sample Output: 1
        Explanation:
        There is only one car, hence there is only one fleet.

    - Example 3:
        Sample Input: target = 100, position = [0,2,4], speed = [4,2,1]
        Sample Output: 1

        Explanation:
            The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at
            4 (speed 1) travels to 5.
            Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6.
            The fleet moves at speed 1 until it reaches target.

    - Constraints:
        n == position.length == speed.length
        1 <= n <= 105
        0 < target <= 106
        0 <= position[i] < target
        All the values of position are unique.
        0 < speed[i] <= 106
*/

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    /**
     * This method calculates the number of car fleets that will arrive at the destination.
     *
     * @param target   - the target mile
     * @param position - the starting positions of the cars
     * @param speed    - the speeds of the cars
     * @return - the number of car fleets
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] time = new double[target + 1];

        for (int i = 0; i < n; i++) {
            time[position[i]] = (double) (target - position[i]) / speed[i];
        }

        double prev = 0.0;
        int fleets = 0;

        for (int i = target; i >= 0; i--) {
            if (time[i] > prev) {
                fleets++;
                prev = time[i];
            }
        }
        return fleets;
    }

    /**
     * This method calculates the number of car fleets that will arrive at the destination using a stack.
     *
     * @param target   - the target destination
     * @param position - the starting positions of the cars
     * @param speed    - the speeds of the cars
     * @return - the number of car fleets that will arrive at the destination
     */
    public static int carFleetWithStack(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();

        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));

        target = 10;
        position = new int[]{3};
        speed = new int[]{3};
        System.out.println(carFleet(target, position, speed));

        target = 100;
        position = new int[]{0, 2, 4};
        speed = new int[]{4, 2, 1};
        System.out.println(carFleetWithStack(target, position, speed));
    }
}

/*
    Without Stack:
    O(n log n) time | O(n) space
        n = length of the input position array.
    1. Create a double array of size target + 1 to hold the time taken for each position to reach the target.
    2. For each position, calculate the time taken to reach the target and store it in the array :
        (target - position[i]) / speed[i]
    3. Initialize a variable prev to 0.0 and fleets to 0.
    4. Traverse the road array from the end to the beginning.
        a. If the current time is greater than prev, increment fleets and update prev to the current time.
    5. Return the number of fleets.

    With Stack:
    O(n log n) time | O(n) space
        n = length of the input position array.
    1. Create a 2D array pair of size n to hold the position and speed of each car.
    2. For each car, store its position and speed in the pair array.
    3. Sort the pair array in descending order based on the position.
    4. Initialize a stack to hold the time taken for each car to reach the target.
    5. For each car in the sorted pair array:
        a. Calculate the time taken to reach the target and push it onto the stack.
        b. If the stack size is greater than or equal to 2 and the top element is less than or equal to the second
            top element, pop the top element from the stack.
    6. Return the size of the stack as the number of fleets.
*/
