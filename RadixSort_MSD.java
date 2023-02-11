// WAP to implement Radix Sort (MSD)

import java.util.Scanner;

public class RadixSort_MSD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        radixSort(arr, 0, n - 1, getMax(arr, n));
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void radixSort(int[] arr, int low, int high, int max) {
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, low, high, exp);
        }
    }

    static void countSort(int[] arr, int low, int high, int exp) {
        int[] output = new int[high - low + 1];
        int[] count = new int[10];
        for (int i = 0; i < high - low + 1; i++) {
            count[(arr[low + i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = high - low; i >= 0; i--) {
            output[count[(arr[low + i] / exp) % 10] - 1] = arr[low + i];
            count[(arr[low + i] / exp) % 10]--;
        }
        for (int i = 0; i < high - low + 1; i++) {
            arr[low + i] = output[i];
        }
    }

    static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}