package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17485 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int M= Integer.parseInt(tk.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        long[][][] dp = new long[N][M][3];
        for (long[][] d : dp)
        {
            for (long[] d1 : d){
                Arrays.fill(d1, Long.MAX_VALUE / 2);
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = map[0][j];
        }

        for (int i = 1; i < N; i++){
            for (int j = 0; j < M; j++){
                //왼쪽에서 오는 경우
                if(j - 1 >= 0){
                    //이전에 내려온 경우와 이전에 오른쪽에서 온 경우
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + map[i][j], dp[i][j][0]); 
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][2] + map[i][j], dp[i][j][0]);
                }
                //오른쪽에서 오는 경우
                if(j + 1 < M){
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0] + map[i][j], dp[i][j][2]);
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][1] + map[i][j], dp[i][j][2]);
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][0] + map[i][j], dp[i][j][1]);
                dp[i][j][1] = Math.min(dp[i - 1][j][2] + map[i][j], dp[i][j][1]);
            }
        }
        long ans = Long.MAX_VALUE / 2;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                ans = Math.min(ans, dp[N - 1][j][k]);
            }
        }
        System.out.println(ans);
    }
}
