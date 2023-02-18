/*
1.2	Write a program for Fibonacci series (Recursive) and calculate the time and space complexity of the program
*/

import java.util.Scanner;

/**
 * experiment_1_problem_statement_1
 */
public class experiment_1_problem_statement_2 {

    // Iterative function to calculate the Fibonacci of a number

    /*
     * Time Complexity: O(n) - Linear Time - Number of iterations
     * Space Complexity: O(1) - Constant Space - No extra space is used
     */

    public static int iterativeFibonacci(int n) {
        int a = 0, b = 1, c = 0;
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    // Recursive function to calculate the Fibonacci of a number

    /*
     * Time Complexity: O(2^n) - Exponential Time - Number of recursive calls
     * Space Complexity: O(n) - Recusive Stack Space to store the recursive calls
     */
    public static int recursiveFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci(Recursive) of " + n + " is " + recursiveFibonacci(n) + ".");
        System.out.println("Fibonacci(Iterative) of " + n + " is " + iterativeFibonacci(n) + ".");
    }
}