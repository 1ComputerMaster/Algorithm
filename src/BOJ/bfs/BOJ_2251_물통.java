package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
	
	static boolean ans[] = new boolean[201]; // ans[i] = T/F A가 비어 있을때 C에 i 리터 만큼 찰 수 있으면 t 불가능하면 f
	static boolean check[][] = new boolean[201][201];
	static int cap[] = new int[3]; // A : 0 , B : 1, C:2
	static int from[] = { 0,0,1,1,2,2 };
	static int to[] = { 1,2,0,2,0,1 };
	static class Data{
		int a;
		int b;
		public Data(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < 3; i++) {
			cap[i] = Integer.parseInt(tk.nextToken());
		}
		int sum = cap[2]; //처음 C의 양이 최초의 가득찬 물의 양이 되므로
		Queue <Data> q = new LinkedList<>(); 
		q.add(new Data(0, 0));
		check[0][0] = true;
		ans[cap[2]] = true;
		while (!q.isEmpty()) {
			int cur[] = new int[3];
			cur[0] = q.peek().a;
			cur[1] = q.peek().b;
			cur[2] = sum - cur[0] - cur[1];
			q.poll();
			for (int i = 0; i < 6; i++) {
				int next[] = { cur[0],cur[1],cur[2] };
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				if (next[to[i]] >= cap[to[i]]) {
					next[from[i]] = next[to[i]] - cap[to[i]];
					next[to[i]] = cap[to[i]];
				}
				if(!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Data(next[0], next[1]));
					if (next[0] == 0) {
						ans[next[2]] = true;
					}
				}
			}
		}
		for (int i = 0; i <= cap[2]; i++) {
			if(ans[i])
				System.out.print(i + " ");
		}
		System.out.println();
	}
}
