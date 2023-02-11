// WAP to implement shell sort

import java.util.Scanner;

class shell_sort
{
    public static void sort(int[] arr, int n)
    {
        int gap = n / 2;
        while(gap > 0)
        {
            for(int i = gap; i < n; i++)
            {
                int temp = arr[i];
                int j = i;
                while(j >= gap && arr[j - gap] > temp)
                {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
    public static void visualize(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Shell Sort");
            System.out.println("Made by: Aayush Kumar");
            System.out.println("\nEnter the number of elements: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements: ");
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextInt();
            }
            System.out.println("Before sorting: ");
            visualize(arr, n);
            sort(arr, n);
            System.out.println("After sorting: ");
            visualize(arr, n);
        }
    }
}