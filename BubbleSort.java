// WAP to implement bubble sort

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        // Use the answer of RandomArray.java for array input
        int[] arr = RandomArray.solution(1000, 34567);
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}