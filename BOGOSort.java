// WAP to implement BOGO sort

import java.util.Scanner;

public class BOGOSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bogoSort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void bogoSort(int[] arr, int n) {
        while (!isSorted(arr, n)) {
            shuffle(arr, n);
        }
    }

    static boolean isSorted(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    static void shuffle(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * n);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}