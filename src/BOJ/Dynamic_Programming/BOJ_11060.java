package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11060 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(tk.nextToken());
        int[] A = new int[N];
        int[] dp = new int[N];
        tk = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
        }
        dp[0] = 1;
        for (int i = 0; i < N; i++){
            if(A[i] > 0 && dp[i] != 0){
                for (int j = i; j < (Math.min((i + A[i] + 1), N)); j++){
                    if(dp[j] == 0 || dp[j] > dp[i] + 1) {
                        dp[j] = dp[i] + 1;
                    }
                }
            }
        }
        System.out.println(dp[N - 1] == 0 ? -1 : dp[N - 1] - 1);
    }
}
