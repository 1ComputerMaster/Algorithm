package BOJ.Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2458_키_순서 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int d[][] = new int[N][N];
		for(int []a :  d) {
			Arrays.fill(a, 1_000_000);
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken()) - 1;
			int to = Integer.parseInt(tk.nextToken()) - 1;
			d[from][to] = 1;
		}
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		int arr[] = new int[N];
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if(d[i][j] != 1_000_000 && i != j) {
					arr[j] += 1;
				}
			} 
		}
		int count = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if(d[i][j] != 1_000_000) {
					count++ ;
				}
				if(i != j) {
					sum += d[i][j];
				}
				if(j == d.length - 1) {
					if(count + 1 + arr[i] == N) {
						cnt++;
						
					}
					sum = 0;
					count = 0;
				}
			}
		}
		System.out.println(cnt);
	}
}
