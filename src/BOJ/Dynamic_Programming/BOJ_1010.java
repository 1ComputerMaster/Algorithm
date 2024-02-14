package BOJ.Dynamic_Programming;

import java.util.Scanner;
public class BOJ_1010 {
    static long[][] dp = new long[31][31];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < 31; i++) {
            dp[i][i] = dp[i][0] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(dp[M][N]);
        }
    }
}