package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++){
            dp[i] = (dp[i - 1] % 10007 + dp[i - 2] % 10007) % 10007;
        }
        System.out.println(dp[n]);
    }
}
