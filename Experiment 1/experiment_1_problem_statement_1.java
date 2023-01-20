/*
1.1	Write a program for factorial of a number (Iterative/ Recursive) and calculate the time and space complexity of the program.
*/

import java.util.Scanner;

/**
 * experiment_1_problem_statement_1
 */
public class experiment_1_problem_statement_1 {

    // Recursive function to calculate the factorial of a number
    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * recursiveFactorial(n - 1);
        }
    }

    // Iterative function to calculate the factorial of a number
    public static int iterativeFactorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Factorial(Recursive) of " + n + " is " + recursiveFactorial(n));
        System.out.println("Factorial(Iterative) of " + n + " is " + iterativeFactorial(n));
    }
}