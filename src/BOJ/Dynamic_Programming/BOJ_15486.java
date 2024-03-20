package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_15486 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(tk.nextToken());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];
        int ans = 0;
        for (int i = 1; i <= N; i++){
            tk = new StringTokenizer(in.readLine()," ");
            T[i] = Integer.parseInt(tk.nextToken());
            P[i] = Integer.parseInt(tk.nextToken());
        }
        /**
         * 부연 설명
         * 아래 프로세스 중 N + 1까지 조건을 거는 이유는 7일차가 마지막날인데
         * 마지막 날 이후로 더 일 할 수 없기 때문에 T[i] <= N + 1이하인 것을 구하였고
         * 또한, 넘어오는 Math.max(ans,dp[i])는 이미 이전에 탐색한 것 중 한 번 더 max 값을 탐색하는 것으로
         * 추가 확인 수단으로 넣었습니다.
         *
         */
        for (int i = 1; i <= N; i++){
            ans = Math.max(ans, dp[i]);
            if(i + T[i] <= N + 1){
                dp[i + T[i]] = Math.max(ans + P[i], dp[i + T[i]]);
            }
        }
        ans = Math.max(ans, dp[N+1]);
        System.out.println(ans);
    }
}
