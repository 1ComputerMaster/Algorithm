package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11660_구간_합_구하기_5 {
	static int arr[][],ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		arr = new int[N + 1][N + 1];
		ans = 0;
		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		int dp[][] = new int[N + 1][N + 1];
		/*DP의 누적합을 구하는 점화식*/
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
			}
		}
		StringBuffer sb;
		sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int x1 = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int x2 = Integer.parseInt(tk.nextToken());
			int y2 = Integer.parseInt(tk.nextToken());
			sb.append((dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
			
		}
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}
