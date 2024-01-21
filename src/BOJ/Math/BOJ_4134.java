package BOJ.Math;

import java.util.Scanner;

public class BOJ_4134 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            if(n == 0 || n == 1){
                System.out.println(1);
                continue;
            }
            while (!isPrime(n)) n++;
            System.out.println(n);
        }
    }

    private static boolean isPrime(long n) {
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
