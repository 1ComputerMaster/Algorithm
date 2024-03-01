package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_10211 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] dp = new int[N];
            dp[0] = arr[0];
            int max = dp[0];
            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }

}
