package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2660_회장뽑기 {
	static int N;
	static class Data implements Comparable<Data>{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.y, o.y);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int [][]d = new int[N+1][N+1];
		for (int map[] : d) {
			Arrays.fill(map, 100_000_000);
		}
		StringTokenizer tk;
		while(true) {
			tk = new StringTokenizer(in.readLine()," ");
			int first = Integer.parseInt(tk.nextToken());
			int second = Integer.parseInt(tk.nextToken());
			if(first == -1 && second == -1) {
				break;
			}
			d[first][second] = 1;
			d[second][first] = 1;
		}
		for (int i = 1; i <= N; i++) {
			d[i][i] = 0;
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		ArrayList<Data> list = new ArrayList<Data>();
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= N; j++) {
				if(d[i][j] ==  100_000_000) {
					break;
				}
				temp = Math.max(temp, d[i][j]);
				if(j == N) {
					list.add(new Data(i,temp));
				}
			}
		}
		Collections.sort(list);
		int temp = list.get(0).y;
		while(true) {
			if(temp != list.get(list.size()-1).y) {
				list.remove(list.size()-1);
			}else {
				break;
			}
		}
		
		System.out.println(list.get(0).y + " " + list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).x + " ");
		}
		
	}
}
