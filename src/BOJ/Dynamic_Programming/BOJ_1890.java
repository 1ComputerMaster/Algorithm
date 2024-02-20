package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        long[][] dp = new long[N][N];
        int moveMentsCnt = 0;
        dp[0][0] = 1;
        for (int i = 0; i < N; i++){
            tk = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < N; j++){
                moveMentsCnt = Integer.parseInt(tk.nextToken());
                if(moveMentsCnt > 0){
                    if(i + moveMentsCnt < N) {
                        dp[i + moveMentsCnt][j] += dp[i][j];
                    }
                    if(j + moveMentsCnt < N) {
                        dp[i][j + moveMentsCnt] += dp[i][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
