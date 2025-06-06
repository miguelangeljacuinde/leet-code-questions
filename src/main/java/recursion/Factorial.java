package recursion;

/*
    Write a function that takes in an integer n and returns the factorial of n.

    Note: The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
    It is denoted as n! and defined as follows:
        1. 0! = 1
        2. n! = n * (n-1)! for n > 0

    - Example 1:
        Input: n = 5
        Output: 120 // 5! = 5 * 4 * 3 * 2 * 1 = 120

    - Example 2:
        Input: n = 0
        Output: 1 // 0! = 1

    - Constraints:
        0 <= n <= 20
*/

public class Factorial {

    /**
     * Calculates the factorial of a non-negative integer n using recursion.
     *
     * @param n - input n
     * @return - the factorial of n
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int example1 = 5;
        int example2 = 0;

        System.out.println(factorial(example1));
        System.out.println(factorial(example2));
    }

}

/*
    O(n) time | O(n) space
        n = input number
    1. Define the base case: if n is 0, return 1 (0! = 1).
    2. For n > 0, return n multiplied by the factorial of (n - 1).
        a. The recursion continues until it reaches the base case.
 */