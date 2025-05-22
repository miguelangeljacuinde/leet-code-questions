package stacks.easy;

import java.util.Stack;

/*
    #1475
    You are given an integer array prices where prices[i] is the price of the ith item in a shop.

    There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount
    equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you
    will not receive any discount at all.

    Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop,
    considering the special discount.

    - Example 1:
        Sample Input: prices = [8,4,6,2,3]
        Sample Output: [4,2,4,2,3]
        Explanation:
            For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
            For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
            For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
            For items 3 and 4 you will not receive any discount at all.

    - Example 2:
        Sample Input: prices = [1,2,3,4,5]
        Sample Output: [1,2,3,4,5]
        Explanation: In this case, for all items, you will not receive any discount at all.

    - Example 3:
        Sample Input: prices = [10,1,1,6]
        Sample Output: [9,0,1,6]

    - Constraints:
        1 <= prices.length <= 500
        1 <= prices[i] <= 1000
*/

public class FinalPricesWithASpecialDiscountInAShop {

    /**
     * This method calculates the final prices after applying the special discount.
     *
     * @param prices - the input array of prices
     * @return - the final prices after applying the discount
     */
    public static int[] finalPricesWithStack(int[] prices) {
        Stack<Integer> indexStack = new Stack<>();
        int pricesLength = prices.length;
        int[] result = new int[pricesLength];

        for (int i = 0; i < pricesLength; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] >= prices[i]) {
                int index = indexStack.pop();
                result[index] = prices[index] - prices[i];
            }
            indexStack.push(i);
        }
        while (!indexStack.isEmpty()) {
            int index = indexStack.pop();
            result[index] = prices[index];
        }
        return result;
    }

    /**
     * This method calculates the final prices after applying the special discount using a brute-force approach.
     *
     * @param prices - the input array of prices
     * @return - the final prices after applying the discount
     */
    public static int[] finalPrices(int[] prices) {
        int pricesLength = prices.length;
        int[] result = new int[pricesLength];

        for (int i = 0; i < pricesLength; i++) {
            result[i] = prices[i];
            for (int j = i + 1; j < pricesLength; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        System.out.println("Original prices: ");
        printArray(prices);

        int[] result = finalPricesWithStack(prices);
        System.out.println("\nFinal prices after discount: ");
        printArray(result);

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("\n\nOriginal prices: ");
        printArray(prices2);

        int[] result2 = finalPricesWithStack(prices2);
        System.out.println("\nFinal prices after discount: ");
        printArray(result2);

        int[] prices3 = {10, 1, 1, 6};
        System.out.println("\n\nOriginal prices: ");
        printArray(prices3);

        int[] result3 = finalPrices(prices3);
        System.out.println("\nFinal prices after discount: ");
        printArray(result3);
    }

    /**
     * This method prints the elements of an integer array.
     *
     * @param array - the input array to be printed
     */
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}

/*
    With Stack:
    O(n) time | O(n) space
        n = length of the input prices.
    1. Initialize a stack to hold the indices of the prices.
    2. Initialize an array to hold the final prices.
    3. Traverse the input prices array.
        a. While the stack is not empty and the current price is less than the price at the index on top of the stack,
            i. Pop the index from the stack.
            ii. Update the final price at that index by subtracting the current price from it.
        b. Push the current index onto the stack.
    4. After traversing the prices array, pop any remaining indices from the stack and set their final prices to the
        original prices.
    5. Return the final prices array.

    Without Stack:
    O(n^2) time | O(1) space:
        n = length of the input prices.
    1. Initialize an array to hold the final prices.
    2. Traverse the input prices array.
        a. For each price, set the final price to the original price.
        b. Traverse the remaining prices to find the first price that is less than or equal to the current price.
            i. If found, update the final price by subtracting the found price from it and break the loop.
    3. Return the final prices array.
*/
