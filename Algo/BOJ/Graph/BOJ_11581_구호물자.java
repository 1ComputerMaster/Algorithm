package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * Union - find는 무방향 그래프에서만 사이클 탐색이 가능하다.
 * 
 * 
 */
public class BOJ_11581_구호물자 {
	/*static int parent[];
	static boolean check[];
	static boolean end = false;
	private static void union(int x,int y){
		if(check[x] == true && parent[x] == y) {
			System.out.println("CYCLE");
			end = true;
			return;
		}
		x = find(x);
		y = find(y);
		if(x!=y) {
			parent[y] = x; //2 -> 1 , 1 -> 2
			check[y] = true;
		}
	}
	private static int find(int x) {
		// TODO Auto-generated method stub
		if(x == parent[x])
		{
			return parent[x];
		}
		else {
			int root = find(parent[x]);
			parent[x] = root;
			return root;
		}
	}*/
	static boolean graph[][] = new boolean[101][101];
	static int visited[] = new int[101];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine()); // 3
		for (int i = 1; i <= N-1; i++) {
			int M = Integer.parseInt(in.readLine()); //2
			StringTokenizer tk = new StringTokenizer(in.readLine()," "); // 2 3
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(tk.nextToken());//값
				graph[i][temp] = true; //여기는 갈 수 있음
			}
		}
		dfs(1);
		if(!checked)
		{
			System.out.println("NO CYCLE");
		}else {
			System.out.println("CYCLE");
		}
	}
	static boolean checked = false;
	private static void dfs(int from) {
		visited[from] = 1;//일단 여기 방문
		for (int to = 1; to < N; to++) {
			if(graph[from][to])
			{
				if(visited[to] == 1) { // 방문 한 곳에서 이미 방문하는 곳 또 오면
					checked = true;
					return;
				}else {
					dfs(to);
				}
			}
		}
		visited[from] = -1; // 방문 끝
	}
}
