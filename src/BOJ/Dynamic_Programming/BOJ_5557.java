package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_5557 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine()," ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++){
            list.add(Integer.parseInt(tk.nextToken()));
        }

        long[][] dp = new long[N - 1][21];

        dp[0][list.get(0)] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int sum = 0; sum <= 20; sum++) {
                if (dp[i - 1][sum] > 0) {
                    // 덧셈
                    if (sum + list.get(i) <= 20) {
                        dp[i][sum + list.get(i)] += dp[i - 1][sum];
                    }
                    // 뺄셈
                    if (sum - list.get(i) >= 0) {
                        dp[i][sum - list.get(i)] += dp[i - 1][sum];
                    }
                }
            }
        }
        System.out.println(dp[N - 2][list.get(N - 1)]);
    }
}
