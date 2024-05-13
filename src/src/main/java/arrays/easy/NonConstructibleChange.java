package arrays.easy;

/*
    Given an array of positive integers representing the values of coins in your possession,
    write a function that returns the minimum amount of change (the min. amount of money)
    that you cannot recreate. The given coins can have any positive integer value and
    aren't necessarily unique (coins can have the same value).

    For example, if you're given coins = [1, 2, 5], the min. amount of change that you
    cannot create is 4. If you're given no coins, the min. amount you are able to create is 1.

    Sample Input: array = [5, 7, 1, 1, 2, 3, 22]

    Sample Output: 20
*/

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 1, 1, 2, 3, 22};

        System.out.println(nonConstructibleChange(array));
    }

    /**
     * @param coins - the input array
     * @return - the minimum amount of change you cannot create
     */
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChange = 0;

        for (int currentCoin : coins) {
            if (currentCoin > currentChange + 1) {
                return currentChange + 1;
            }
            currentChange += currentCoin;
        }
        return currentChange + 1;
    }

}

/*
    O(n*log(n)) time | O(1) space

    1. Sort the array in place.
    2. Init. the current change
    3. Iterate through the coins one at a time.
        a. If the current coin > current change + 1, return current change + 1
        b. Else, add the current coin to the current change.
    5. We have iterated through all the coins. So we return the current change + 1
*/