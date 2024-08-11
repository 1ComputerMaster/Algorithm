package BOJ.Dynamic_Programming;

import java.util.Scanner;

public class BOJ_1010_tr {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
            int[][] dp = new int[31][31];
            for (int i = 0; i < 31; i++){
                dp[i][i] = 1;
                dp[i][0] = 1;
            }
            for (int i = 1; i < 31; i++) {
                for (int j = 1; j < 31; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
}
