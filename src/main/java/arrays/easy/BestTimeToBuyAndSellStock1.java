package arrays.easy;

import java.util.Arrays;

/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize
    your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    - Example 1:
        Sample Input: prices = [7,1,5,3,6,4]
        Sample Output: 5

        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note: Buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    - Example 2:
        Sample Input: prices = [7,6,4,3,1]
        Sample Output: 0

        Explanation: In this case, no transactions are done and the max profit = 0.

    - Constraints:
        1 <= prices.length <= 105
        0 <= prices[i] <= 104
*/

public class BestTimeToBuyAndSellStock1 {

    public static void main(String[] args) {
        int[] prices1 = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));

        int[] prices3 = new int[]{1};
        System.out.println(maxProfit(prices3));
    }

    /**
     * Finds the profit you can make within an array of stock prices
     *
     * @param prices - the stock prices.
     * @return - the profit if any, else 0
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int price : prices) {
            if (price < buy) {
                buy = price;
            } else if (price - buy > profit) {
                profit = price - buy;
            }
        }
        return profit;
    }

}

/*
    O(n) time | O(1) space
    1. Initialize the profit to 0 and the buy as the first price in the array.
    2. Iterate through the prices.
        a. If the current price < buy, buy = that current price.
        b. Else if the price - buy > profit, profit = price - buy.
        c. Else, continue traversing.
    3. Return the profit if any, else 0.
*/