package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < 101; i++){
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        int T = sc.nextInt();
        while (T-- > 0){
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}
