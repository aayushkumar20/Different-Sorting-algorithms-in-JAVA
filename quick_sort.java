// WAP to implement quick sort (LR partitioning)

import java.util.Scanner;

class sort
{
    int a[];
    int n;
    sort()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        a = new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
    }
    void quicksort(int low,int high)
    {
        int pivot;
        if(low<high)
        {
            pivot = partition(low,high);
            quicksort(low,pivot-1);
            quicksort(pivot+1,high);
        }
    }
    int partition(int low,int high)
    {
        int pivot = a[low];
        int i = low+1;
        int j = high;
        int temp;
        while(i<=j)
        {
            while(a[i]<=pivot && i<=high)
            {
                i++;
            }
            while(a[j]>pivot && j>=low)
            {
                j--;
            }
            if(i<j)
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        temp = a[low];
        a[low] = a[j];
        a[j] = temp;
        return j;
    }
    void display()
    {
        System.out.println("The sorted array is");
        for(int i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
    }
}