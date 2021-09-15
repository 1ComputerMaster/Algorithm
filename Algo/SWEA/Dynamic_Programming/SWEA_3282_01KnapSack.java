package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3282_01KnapSack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t<=T;t++) {
			StringTokenizer tk = new StringTokenizer(in.readLine()," ");// 물건 
			int N = Integer.parseInt(tk.nextToken());
			int K = Integer.parseInt(tk.nextToken());
			int d[][] = new int[N+1][K+1];
			int w[] = new int[N+1];
			int v[] = new int[N+1];
			
			for(int i = 1; i <= N;i++) {
				tk = new StringTokenizer(in.readLine()," ");// 물건 
				w[i] = Integer.parseInt(tk.nextToken());
				v[i] = Integer.parseInt(tk.nextToken());
			}
			
			for(int i = 1;i<=N;i++) {
				for(int j = 1;j<=K;j++) {
					if(w[i] <= j) {
						d[i][j] = Math.max(d[i-1][j], d[i-1][j-w[i]]+v[i]);
					}else {
						d[i][j] = d[i-1][j];
					}
				}
			}
			
			
			System.out.println("#"+t+" "+d[N][K]);
		}
	}

}
