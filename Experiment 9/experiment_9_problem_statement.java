/*
Write a program for N-Queen’s problem using Backtracking.
*/

import java.util.Scanner;
import java.util.ArrayList;

/**
 * experiment_9_problem_statement
 */
public class experiment_9_problem_statement {

    // isSafe function to check if a queen can be placed on board[row][column]
    private static boolean isSafe(int[][] board, int row, int column) {
        // check if there is a queen in the same row
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }

        // check if there is a queen in the upper left diagonal
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // check if there is a queen in the lower left diagonal
        for (int i = row, j = column; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check if there is a queen in the lower right diagonal
        for (int i = row, j = column; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // check if there is a queen in the upper right diagonal
        for (int i = row, j = column; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // printSolution function to print the solution
    private static void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    // saveSolution function to save the solution
    private static void saveSolution(int[][] board, ArrayList<int[][]> solutions) {
        int[][] solution = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                solution[i][j] = board[i][j];
            }
        }
        solutions.add(solution);
    }

    // solveNQueenHelper function to solve N Queen problem
    private static void solveNQueenHelper(int[][] board, int column, ArrayList<int[][]> solutions) {
        // if all queens are placed then return true and print the solution
        if (column >= board.length) {
            saveSolution(board, solutions);
            return;
        }

        // place the queen in the column and check if it is safe
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, column)) {
                board[i][column] = 1;
                solveNQueenHelper(board, column + 1, solutions);
                board[i][column] = 0;
            }
        }
    }

    // solveNQueen function to solve N Queen problem
    public static void solveNQueen(int n) {
        int[][] board = new int[n][n];
        ArrayList<int[][]> solutions = new ArrayList<int[][]>();
        solveNQueenHelper(board, 0, solutions);
        if (solutions.size() == 0) {
            System.out.println("Solution does not exist");
            return;
        }
        System.out.println("Total Solutions: " + solutions.size() + "\n");

        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            printSolution(solutions.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Queens: ");
        int n = sc.nextInt();
        System.out.println();
        solveNQueen(n);
        sc.close();
    }
}