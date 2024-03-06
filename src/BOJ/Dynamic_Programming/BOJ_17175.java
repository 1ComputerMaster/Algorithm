package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_17175 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] dp = new long[51];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= 50; i++) {
            dp[i] = ((dp[i - 1] % 1000000007) + (dp[i - 2]  % 1000000007) + 1);
        }

        int N = scanner.nextInt();
        System.out.println(dp[N] % 1000000007);

    }
}