/*
3.1 Write a program to implement merge sort algorithm.
*/

import java.util.Scanner;

/**
 * experiment_3_problem_statement_1
 */
public class experiment_3_problem_statement_1 {

    // Recursive merge sort function to sort the array

    /*
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n) - Recusrive Stack Space
     */
    private static void recursiveMergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            recursiveMergeSort(arr, start, mid);
            recursiveMergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void recursiveMegreSort(int[] arr) {
        recursiveMergeSort(arr, 0, arr.length - 1);
    }

    // merge function to merge two subarrays
    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
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

        recursiveMegreSort(arr);

        System.out.print("Sorted Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}