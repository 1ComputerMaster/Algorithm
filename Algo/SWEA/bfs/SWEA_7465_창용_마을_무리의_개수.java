package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7465_창용_마을_무리의_개수 {
	static ArrayList<Integer>[] list;
	static boolean check[];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for(int t = 1;t<=T;t++) {
			cnt = 0;
			tk = new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(tk.nextToken());
			int M = Integer.parseInt(tk.nextToken());
			list = new ArrayList[N+1];
			for(int i = 0;i<N+1;i++) {
				list[i] = new ArrayList<>();
			}
			check = new boolean[N+1];
			for(int j = 0; j<M;j++) {
				tk = new StringTokenizer(in.readLine()," ");
				if(tk.countTokens() == 2) {
					int from = Integer.parseInt(tk.nextToken());
					int to = Integer.parseInt(tk.nextToken());
					list[from].add(to);
					list[to].add(from);
				}else {
					int from = Integer.parseInt(tk.nextToken());
					list[from].add(0);
				}
			}
			for(int i = 1;i<N+1;i++) {
				if(check[i] == false)
				{
					bfs(i);
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
	private static void bfs(int first) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(first);
		check[first] = true;
		cnt++;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i = 0;i<list[x].size();i++) {
				if(check[list[x].get(i)]==false) {
					check[list[x].get(i)] = true;
					q.add(list[x].get(i));
				}
			}
		}
	}

}
