package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1613_역사 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int d[][] = new int[401][401];
		for(int[] map : d) {
			Arrays.fill(map, 100_000_000);
		}
		for (int i = 0; i < K; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			d[from][to] = 1;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(i == j) {
						d[i][j] = 0;
					}
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int start = Integer.parseInt(tk.nextToken());
			int end = Integer.parseInt(tk.nextToken());
			if(d[start][end] < 100_000_000)
			{
				System.out.println(1);
			}else if(d[end][start] < 100_000_000){
				System.out.println(-1);
			}else {
				System.out.println(0);
			}
		}
		
	}

}
