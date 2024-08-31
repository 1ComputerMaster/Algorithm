package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");
        int[] map = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++){
            map[i] = Integer.parseInt(tk.nextToken());
        }
        int ans = 0;
        for (int i = 0; i < N; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if(map[i] > map[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
