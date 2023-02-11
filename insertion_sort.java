// WAP to implement insertion sort

import java.util.Scanner;

class sort
{
    public static void insertion_sort(int a[],int n)
    {
        int i,j,temp;
        for(i=1;i<n;i++)
        {
            temp=a[i];
            j=i-1;
            while(j>=0 && a[j]>temp)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,i;
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the elements");
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        insertion_sort(a,n);
        System.out.println("The sorted array is");
        for(i=0;i<n;i++)
        {
            System.out.println(a[i]);
        }
    }
}