package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer tk;
        int T[] = new int[100];
        int P[] = new int[100];
        int dp[] = new int[100];
        for(int i = 1; i <= N; i++){
            tk = new StringTokenizer(in.readLine());    
            T[i] = Integer.valueOf(tk.nextToken());
            P[i] = Integer.valueOf(tk.nextToken());
        }
        int next = 0;
        for(int i = N; i > 0; i--){
            next = T[i] + i;
            if(next > N+1){
                dp[i] = dp[i+1];
            }else{
                dp[i] = Math.max(dp[i+1], P[i] + dp[next]);
            }
        }
        System.out.println(dp[1]);
    }
}