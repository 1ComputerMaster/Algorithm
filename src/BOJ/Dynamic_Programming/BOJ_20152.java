package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20152 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int H = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        int tmp = 0;
        if(H > N){
            tmp = N;
            N = H;
            H = tmp;
        }
        long[][] dp = new long[N + 1][N + 1];
        for (int i = H; i <= N; i++){
            dp[H][i] = 1;
        }
        for (int i = H + 1; i <= N; i++){
            for (int j = i; j <= N; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[N][N]);
    }
}
