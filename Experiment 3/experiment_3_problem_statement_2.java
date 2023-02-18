/*
3.2 Write a program to implement quick sort algorithm.
*/

import java.util.Scanner;

/**
 * experiment_3_problem_statement_2
 */
public class experiment_3_problem_statement_2 {

    // Recursive quick sort function to sort the array

    /*
     * Time Complexity: O(n^2) 
     * Space Complexity: O(n) - Recusrive Stack Space
     */
    private static void recursiveQuickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            recursiveQuickSort(arr, start, pivot - 1);
            recursiveQuickSort(arr, pivot + 1, end);
        }
    }

    public static void recursiveQuickSort(int[] arr) {
        recursiveQuickSort(arr, 0, arr.length - 1);
    }

    // partition function to partition the array
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter the Elements of Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();

        System.out.print("Unsorted Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        recursiveQuickSort(arr);

        System.out.print("Sorted Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}