// WAP to implement selection sort
// Languages: java

import java.util.Scanner;

class sort
{
    public static void selection_sort(int a[], int n)
    {
        int i, j, temp, min;
        for(i=0; i<n-1; i++)
        {
            min = i;
            for(j=i+1; j<n; j++)
            {
                if(a[j] < a[min])
                {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
    public static void main(String args[])
    {
        int n, i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements: ");
        for(i=0; i<n; i++)
        {
            a[i] = sc.nextInt();
        }
        // Before sorting
        System.out.println("The array is: ");
        for(i=0; i<n; i++)
        {
            System.out.print(a[i]+ ",");
        }
        selection_sort(a, n);
        System.out.println("The sorted array is: ");
        for(i=0; i<n; i++)
        {
            System.out.print(a[i]+ ",");
        }
    }
}
