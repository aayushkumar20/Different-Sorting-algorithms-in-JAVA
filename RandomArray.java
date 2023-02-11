// WAP to generate random array of size n with values between 1 to m

import java.util.*;

class RandomArray
{
    public static int[] solution(int n, int m)
    {
        int[] res = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            res[i] = rand.nextInt(m) + 1;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("Enter n: ");
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            System.out.println("Enter m: ");
            int m = sc.nextInt();
            System.out.println(Arrays.toString(solution(n, m)));
        }
    }
}