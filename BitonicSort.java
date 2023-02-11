// WAP to implement Bitonic sort

import java.util.Scanner;

public class BitonicSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bitonicSort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bitonicSort(int[] arr, int n) {
        bitonicSort(arr, 0, n, 1);
    }

    static void bitonicSort(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(arr, low, k, 1);
            bitonicSort(arr, low + k, k, 0);
            bitonicMerge(arr, low, cnt, dir);
        }
    }

    static void bitonicMerge(int[] arr, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++) {
                compare(arr, i, i + k, dir);
            }
            bitonicMerge(arr, low, k, dir);
            bitonicMerge(arr, low + k, k, dir);
        }
    }

    static void compare(int[] arr, int i, int j, int dir) {
        if ((arr[i] > arr[j] && dir == 1) || (arr[i] < arr[j] && dir == 0)) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}