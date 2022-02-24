package Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {
	static int N,M;
	static int d[][];
	static int arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		d = new int[N+1][N+1];
		arr = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					d[i][j] = 0;
				else
					d[i][j] = Integer.MAX_VALUE / 2;
			}
		}

		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken());
			d[from][to] = d[to][from] = weight;
			arr[from][to] = to;
			arr[to][from] = from;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(d[i][j] > d[i][k] + d[k][j])
					{
						d[i][j] = d[i][k] + d[k][j];
						arr[i][j] = k;
					}
				}
			}
		}
		//다시 그것을 찾아가는 형태로 찾아감
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == 0)
					sb.append("- ");
				else {
					int t = j; // 그 위치에서 arr[1][6] = 5
					while (arr[i][t] != t) { // arr[1][5] = 2 -> arr[1][2] = 2
						t = arr[i][t];
					}
					sb.append(arr[i][t] + " ");
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();

	}
	
}
