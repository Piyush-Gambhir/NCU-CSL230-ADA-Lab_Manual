/*
1.2	Write a program for Fibonacci series (Recursive) and calculate the time and space complexity of the program
*/

import java.util.Scanner;

/**
 * experiment_1_problem_statement_1
 */
public class experiment_1_problem_statement_2 {

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

    // Optimized Recursive function to calculate the Fibonacci of a number

    /*
     * Time Complexity: O(n) - Linear Time - Number of recursive calls
     * Space Complexity: O(n) - Recusive Stack Space to store the recursive calls +
     * Array to store the values
     */
    private static int optimizedRecursiveFibonacci(int n, int[] temp) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (temp[n] != -1) {
            return temp[n];
        } else {
            temp[n] = optimizedRecursiveFibonacci(n - 1, temp) + optimizedRecursiveFibonacci(n - 2, temp);
            return temp[n];
        }
    }

    public static int optimizedRecursiveFibonacci(int n) {
        int[] temp = new int[n + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }
        return optimizedRecursiveFibonacci(n, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci(Recursive) of " + n + " is " + recursiveFibonacci(n) + ".");
        System.out.println("Fibonacci(Optimized Recursive) of " + n + " is " + optimizedRecursiveFibonacci(n) + ".");
    }
}