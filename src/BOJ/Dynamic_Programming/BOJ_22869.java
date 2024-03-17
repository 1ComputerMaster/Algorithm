package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22869 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(in.readLine());

        int[] A = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(tk.nextToken());
        }
        dp[0] = 1;
        for (int i = 0; i < N - 1; i++){
            if(dp[i] == 1) {
                for (int j = i + 1; j < N; j++) {
                    if (((j - i) * (1 + Math.abs(A[i] - A[j]))) <= K) {
                        dp[j] = 1;
                    }
                }
            }
        }
        if(dp[N - 1] == 0)
        {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }
}
