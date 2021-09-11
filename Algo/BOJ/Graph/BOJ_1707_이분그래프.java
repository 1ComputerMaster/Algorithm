package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {
/*	static int p[];
	static boolean check = false;
	static void Union(int start,int end) {
		start = find(start);
		end = find(end);
		if(end == start) {
			check = true;
		}
		p[end] = p[start]; 
	}
	static int find(int idx) {
		if(p[idx] == idx)
		{
			return p[idx];
		}else {
			return p[idx] = find(p[idx]);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for(int k = 0;k<K;k++) {
			check = false;
			tk = new StringTokenizer(in.readLine()," ");
			int V = Integer.parseInt(tk.nextToken());
			int E = Integer.parseInt(tk.nextToken());
			p = new int[V+1];
			for(int i = 1;i<=V;i++) { //make-set
				p[i] = i; //페어런트의 기본 부모 설정
			}
			for(int i = 0;i<E;i++) {
				tk = new StringTokenizer(in.readLine()," ");
				int from = Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				Union(from,to);
			}
			if(check) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
			//Union 한거 find로 찾자
		}
	}*/
	//아예 부모랑은 상관 없이 인접한 서로 다른 정점이 계속 다른 집합처럼 되어야 한다는 것
	//red black으로 서로 다른 색으로 탐색하자
	static int color[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		for(int t = 0;t<K;t++) {
			tk = new StringTokenizer(in.readLine()," ");
			int V = Integer.parseInt(tk.nextToken());
			int E = Integer.parseInt(tk.nextToken());
			list = new ArrayList[V+1];
			for(int i = 0;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0;i<E;i++) {
				tk = new StringTokenizer(in.readLine()," ");
				int from = Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				list[from].add(to);
				list[to].add(from); //그래프로 나가서 정점끼리 나눠야지..
			}
			color = new int[V+1];
			for(int i = 1;i<=V;i++) {
				if(color[i] == 0)
				{
					dfs(i,1);
				}
			}
			
			boolean ok = true;
			for (int i = 1; i <= V; i++) {//모든 노드에 대해서
				for (int k = 0; k < list[i].size(); k++) {//각 노드의 간선에 대해서
					int j = list[i].get(k);
					if (color[i] == color[j]) {//컬러가 내 컬러와 같은게 있다면 틀린 것이다.
						ok = false;
					}
				}
			}
			System.out.printf("%s\n", ok ? "YES" : "NO");
		}
	}
	private static void dfs(int idx, int c) {
		color[idx] = c;
		for(int i = 0;i < list[idx].size();i++)
			if(color[list[idx].get(i)] == 0) {
				dfs(list[idx].get(i),3-c);
			}
		}
	}

