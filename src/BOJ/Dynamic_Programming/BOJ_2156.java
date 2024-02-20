package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계단 오르기 문제와 비슷하여 접근이 쉬웠습니다.
 */
public class BOJ_2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        int[] wine = new int[N];
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            wine[i] = Integer.parseInt(tk.nextToken());
        }
        int[] dp = new int[N + 1];
        dp[1] = wine[0];
        if(N >= 2) {
            dp[2] = dp[1] + wine[1];
            if(N > 2) {
                for (int i = 3; i <= N; i++) {
                    dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i - 1], dp[i - 3] + wine[i - 2] + wine[i - 1]));
                }
            }
        }
        System.out.println(dp[N]);
    }
}
