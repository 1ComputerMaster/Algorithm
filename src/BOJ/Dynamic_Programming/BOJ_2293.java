package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {
    static int N,K;
    static int[] coins;
    static long[] dp;
    private static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        N = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());
        coins = new int[N];
        dp = new long[K + 1];
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            coins[i] = Integer.parseInt(tk.nextToken());
        }
    }
    public static void main(String[] args) throws Exception{
        input();
        dp[0] = 1;
        for (int i = 0; i < N; i++){
            for (int j = coins[i]; j <= K; j++){
                if(j - coins[i] > K && j - coins[i] < 0){
                    continue;
                }
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[K ]);
    }
}
