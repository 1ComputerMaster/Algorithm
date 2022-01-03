package dijkstrak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1504_특정한_최단경로 {
	static class Data implements Comparable<Data>{
		int node;
		int dist;
		public Data(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.dist, o.dist);
		}
		
	}
	static ArrayList<Data> graph[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(tk.nextToken()); //정점
		int E = Integer.parseInt(tk.nextToken()); //간선
		graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Data>();
		}
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			graph[a].add(new Data(b,c));
			graph[b].add(new Data(a,c));
		}
		
		tk = new StringTokenizer(in.readLine()," ");
		int start = Integer.parseInt(tk.nextToken());
		int end = Integer.parseInt(tk.nextToken());
		/* 1-> v1 -> v2 -> N */
		int ans = dijkstra(1,start,N);
		ans += dijkstra(start,end,N);
		ans += dijkstra(end, N, N);
		/* 1-> v2 -> v1 -> N */
		int ans1 = dijkstra(1,end,N);
		ans1 += dijkstra(end,start,N);
		ans1 += dijkstra(start, N, N);
		ans = Math.min(ans, ans1);
		if(ans >= 100_000_000) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
	private static int dijkstra(int start, int end, int N) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		pq.add(new Data(start,0)); //나부터 시작
		int minEdge[] = new int[N+1];
		Arrays.fill(minEdge, 100_000_000);
		minEdge[start] = 0;
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			int node = cur.node;
			int dist = cur.dist;
			if(minEdge[node] < dist) {
				continue;
			}
			for (Data next : graph[node]) {
				if(minEdge[next.node] > minEdge[node] + next.dist) {
					minEdge[next.node] = minEdge[node] + next.dist;
					pq.add(new Data(next.node,minEdge[next.node]));
				}
			}
		}
		return minEdge[end];
	}
}
