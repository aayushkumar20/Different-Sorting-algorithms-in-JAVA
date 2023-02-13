// WAP to demonstrate the parrallel sorting using multiple threads
// Use RandomArray.java file to generate random array within range of n and m.

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelSort {
    public static void main(String[] args) {
        int[] arr = RandomArray.solution(50000, 10000);
        System.out.println(Arrays.toString(arr));
        parallelSort(arr);
        System.out.println(Arrays.toString(arr));
        // Print the time taken to sort the array
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Time taken to sort the array: " + (end - start) + "ms");

    }

    public static void parallelSort(int[] arr) {
        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> Arrays.sort(arr1));
        executor.submit(() -> Arrays.sort(arr2));
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int[] arr3 = new int[arr.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
        System.arraycopy(arr3, 0, arr, 0, arr.length);
    }
}