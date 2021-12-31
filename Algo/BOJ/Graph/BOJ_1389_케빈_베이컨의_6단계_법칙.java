package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
	static class Data implements Comparable<Data>{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Data o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}else {
				return this.x - o.x;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		int d[][] = new int[N+1][N+1];
		for (int map[] : d) {
			Arrays.fill(map, 1000_000_000);
		}
		for (int i = 0; i < M; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			d[to][from] = 1;
			d[from][to] = 1;
		}
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					d[i][j] = Math.min(d[i][j], (d[i][k] + d[k][j]));
				}
			}
		}
		ArrayList<Data> list = new ArrayList<Data>();
		for (int i = 1; i < d.length; i++) {
			int sum = 0;
			for (int j = 1; j < d.length; j++) {
				sum += d[i][j];
			}
			list.add(new Data(sum,i));
		}
		Collections.sort(list);
		
		
		System.out.println(list.get(0).y);
	}

}
