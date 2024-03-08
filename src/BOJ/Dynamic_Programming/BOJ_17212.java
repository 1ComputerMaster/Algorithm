package BOJ.Dynamic_Programming;

import java.util.Scanner;
public class BOJ_17212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] coins = {1, 2, 5, 7};
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[N]);
        sc.close();
    }
}