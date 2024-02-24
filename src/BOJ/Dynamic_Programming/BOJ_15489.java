package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15489 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");

        int R = Integer.parseInt(str[0]) - 1;
        int C = Integer.parseInt(str[1]) - 1;
        int W = Integer.parseInt(str[2]);

        int[][] dp = new int[31][31];

        for (int i = 0; i < 31; i++){
            for (int j = 0; j <= i; j++){
                if(j == 0 || i == j){
                    dp[i][j] = 1;
                }
                if(dp[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        int ans = 0;

        for (int i = R; i < R + W; i++){
            for (int j = C; j <= C + (i - R); j++){
                ans += dp[i][j];
            }
        }
        System.out.println(ans);
    }
}
