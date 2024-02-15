package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17626 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int dp[] = new int[50001];
        /**
         * 1 => 1*1 = 1
         * 2 => 1*1 1*1 => 2
         * 3 => 1*1 1*1 1*1 => 3
         * 4 => 2*2 => 1
         * 5 => 2*2 1*1 => 2
         * 6 => 2*2 1*1 1*1 => 3
         * 7 => 2*2 1*1 1*1 1*1 => 4
         * 8 => 2*2 + 2*2 => 2
         * 9 3*3 => 1
         *
         */
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 50001; i++){
            int ans = 100000;
            for(int j = 1; j*j <= i; j++){
                ans = Math.min(dp[i - (j * j)], ans);
            }
            dp[i] = ans + 1;
        }

        System.out.println(dp[N]);
    }
}
