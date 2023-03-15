// parallel sorting using metal GPU

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelSort {

    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }
        long start = System.currentTimeMillis();
        Arrays.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Time taken by sequential sort: " + (end - start) + "ms");
        start = System.currentTimeMillis();
        parallelSort(arr);
        end = System.currentTimeMillis();
        System.out.println("Time taken by parallel sort: " + (end - start) + "ms");
    }

    public static void parallelSort(int[] arr) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelSortTask(arr, 0, arr.length - 1));
    }

    private static class ParallelSortTask extends RecursiveAction {

        private static final int THRESHOLD = 1000;
        private final int[] arr;
        private final int start;
        private final int end;

        public ParallelSortTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start < THRESHOLD) {
                Arrays.sort(arr, start, end + 1);
            } else {
                int mid = (start + end) / 2;
                ParallelSortTask left = new ParallelSortTask(arr, start, mid);
                ParallelSortTask right = new ParallelSortTask(arr, mid + 1, end);
                left.fork();
                right.compute();
                left.join();
            }
        }
    }
}
