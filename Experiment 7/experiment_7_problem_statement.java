/*
Write a program for 0/1 Knapsack problem using Dynamic Programming.

The 0-1 knapsack problem is a variation of the knapsack problem in which each item can only be included in the knapsack once or not at all (i.e., it must be either 0 or 1). The problem is stated as follows:

Given a set of n items, each with a weight w_i and a value v_i, and a knapsack with a maximum capacity W, the goal is to find the subset of items that maximizes the total value of the knapsack while keeping the total weight less than or equal to W. 
*/

import java.util.Scanner;

/**
 * experiment_7_problem_statement
 */
public class experiment_7_problem_statement {

    // Function to find the maximum value that can be put in a knapsack of capacity
    // capacity
    public static int knspsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] K = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                if (i == 0 || j == 0) {
                    K[i][j] = 0;
                } else if (weight[i - 1] <= j) {
                    K[i][j] = Math.max(value[i - 1] + K[i - 1][j - weight[i - 1]], K[i - 1][j]);
                } else {
                    K[i][j] = K[i - 1][j];
                }
            }
        }

        return K[n][maxWeight];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items");
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        System.out.println("Enter the weight of each item");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter the value of each item");
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack");
        int capacity = sc.nextInt();

        System.out.println("The maximum value that can be put in a knapsack of capacity " + capacity + " is "
                + knspsack(weight, value, n, capacity));
        sc.close();
    }
}