package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10164_격자상의_경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int arr[][] = new int[N][M];
		int dp[][] = new int[N][M];
		int w = 0;
		int h = 0;
		if(K != 0) {
			w = K/M;
			h = K%M - 1;
		}else {
			w = 0;
			h = 0;
		}
		for (int i = 0; i < N; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < M; j++) {
			dp[0][j] = 1;
		}
		loop : for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
				if(i == w && j == h) {
					for (int i1 = i; i1 < N; i1++) {
						dp[i1][j] = dp[i][j];
					}
					for (int j1 = 0; j1 < M; j1++) {
						dp[i][j1] = dp[i][j];
					}
					
					for (int j2 = i + 1; j2 < N; j2++) {
						for (int l = j + 1; l < M; l++) {
							dp[j2][l] = dp[j2 - 1][l] + dp[j2][l - 1];  
						}
					}
					break loop;
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
		
	}

}
