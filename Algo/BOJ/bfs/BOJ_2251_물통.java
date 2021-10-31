package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
	//공간 복잡도 많지만 조금 더 빠름
	
	/*static class Data{
		int a;
		int b;
		int c;
		public Data(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	private static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int A = Integer.parseInt(tk.nextToken());
		int B = Integer.parseInt(tk.nextToken());
		int C = Integer.parseInt(tk.nextToken());
		int sum = C; // 일단 최초 C가 다 꽉 찬 것이므로
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(0,0,sum));
		visited = new boolean[201][201][201];
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			Data cur = q.poll();
			
	        if (visited[cur.a][cur.b][cur.c] == true) continue;
	        visited[cur.a][cur.b][cur.c] = true;
	        if(cur.a == 0) {
				ans.add(cur.c);
			}
	        // A물통에서 B물통으로 줄 때
	        if (cur.a + cur.b > B) q.add(new Data(cur.a + cur.b - B, B, cur.c));
	        else q.add(new Data(0, cur.a + cur.b, cur.c));
	 
	        // A물통에서 C물통으로 줄 때
	        if (cur.a + cur.c > C) q.add(new Data(cur.a + cur.c - C, cur.b, C));
	        else q.add(new Data(0, cur.b, cur.a + cur.c));
	 
	        // B물통에서 A물통으로 줄 때
	        if (cur.b + cur.a > A) q.add(new Data(A, cur.b + cur.a - A, cur.c));
	        else q.add(new Data(cur.b + cur.a, 0, cur.c));
	 
	        // B물통에서 C물통으로 줄 때
	        if (cur.b + cur.c > C) q.add(new Data(cur.a, cur.b + cur.c - C, C));
	        else q.add(new Data(cur.a, 0, cur.b + cur.c));
	 
	        // C물통에서 A물통으로 줄 때
	        if (cur.c + cur.a > A) q.add(new Data(A, cur.b, cur.c + cur.a - A));
	        else q.add(new Data(cur.c + cur.a, cur.b, 0));
	 
	        // C물통에서 B물통으로 줄 때
	        if (cur.c + cur.b > B) q.add(new Data(cur.a, B, cur.c + cur.b - B));
	        else q.add(new Data(cur.a, cur.b + cur.c, 0));
		}
		Collections.sort(ans);
		for(int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) +" ");
		}
	}*/

	//공간 복잡도 낮지만 더 느림
	
	
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
