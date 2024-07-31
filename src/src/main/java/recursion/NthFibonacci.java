package recursion;

/*
    Write a function that takes in an integer n and returns the nth Fibonacci number.

    Note: The Fibonacci sequence is defined as follows: the first number of the sequence is 0, the second number is 1,
    and the nth number is the sum of the (n-1)th and the (n-2)th numbers.
    The Fibonacci sequence is often defined with its first two numbers as F0 = 0 and F1 = 1.
    For the purpose of this question, the first Fibonacci number is F0; therefore, getNthFib(1) is equal to F0,
    getNthFib(2) is equal to F1, etc...

    Sample Input: n = 5

    Sample Output: 3 // 0, 1, 1, 2, 3
 */

import java.util.HashMap;

public class NthFibonacci {

    public static void main(String[] args) {
        int example1 = 5;  // 5
        int example2 = 10; // 55

        System.out.println(getNthFibBruteForce(example1));
        System.out.println(getNthFibBruteForce(example2));

        System.out.println(getNthFibWithHashMap(example1));
        System.out.println(getNthFibWithHashMap(example2));
    }

    /**
     * @param n - input n
     * @return - the nth number in the Fibonacci sequence
     */
    private static int getNthFibWithHashMap(int n) {
        HashMap<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFibWithHashMap(n, memoize);
    }

    /**
     * @param n       - the nth number in the Fibonacci sequence
     * @param memoize - the caching memoize
     * @return - the nth number in the Fibonacci sequence
     */
    private static int getNthFibWithHashMap(int n, HashMap<Integer, Integer> memoize) {
        if (!memoize.containsKey(n)) {
            memoize.put(n, getNthFibWithHashMap(n - 2, memoize) + getNthFibWithHashMap(n - 1, memoize));
        }
        return memoize.get(n);
    }

    /**
     * @param n - input n
     * @return - the nth number in the Fibonacci sequence
     */
    public static int getNthFibBruteForce(int n) {
        int firstFib = 0;
        int secondFib = 1;
        if (n == 1) {
            return firstFib;
        } else if (n == 2) {
            return secondFib;
        } else {
            return getNthFibBruteForce(n - 2) + getNthFibBruteForce(n - 1);
        }
    }

}
/*
    With HashSet : O(n) time | O(n) space

    1.Initialize first and second fib number as 0, 1 respectively in a HashMap.
        a. if the map does not contain the key, put n in the map as the key and the fib method as the value
            fib(n-1, map) + fib(n-2, map)

    Brute Force : O(2^n) time | O(n) space

    1.Initialize first and second fib number as 0, 1 respectively.
        a. if n = 1, return fib1.
        b. else if n = 2, return fib2.
        c. else n > 2, return fib sequence -> fib(n-1) + fib(n-2).
*/
