package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084_동전 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int N;
		int M;
		StringTokenizer tk;
		int coin[];
		int dp[];
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(in.readLine());
			tk = new StringTokenizer(in.readLine()," ");
			coin = new int[N];
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(tk.nextToken());
			}
			M = Integer.parseInt(in.readLine());
			dp = new int[M+1];
			dp[0] = 1;
			for (int i = 0; i < coin.length; i++) {
				for (int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j-coin[i]];
				}
			}
			System.out.println(dp[M]);
		}
	}
}
