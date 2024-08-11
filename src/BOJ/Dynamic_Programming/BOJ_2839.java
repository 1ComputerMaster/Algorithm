package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] dp = new int[5001];
        dp[3] = 1;
        dp[5] = 1;
        for (int i = 5; i < 5001; i++){
            if(dp[i - 3] != 0 && dp[i - 5] != 0){
                if(dp[i - 3] < dp[i - 5]) {
                    dp[i] = dp[i - 3] + 1;
                }
                if(dp[i - 5] < dp[i - 3]) {
                    dp[i] = dp[i - 5] + 1;
                }
                if(dp[i - 5] == dp[i - 3]){
                    dp[i] = dp[i - 5] + 1;
                }
            }else{
                if(dp[i - 3] != 0 && dp[i - 5] == 0){
                    dp[i] = dp[i - 3] + 1;
                }
                if(dp[i - 5] != 0 && dp[i - 3] == 0){
                    dp[i] = dp[i - 5] + 1;
                }
            }
        }
        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}
