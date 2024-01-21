package BOJ.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_18223_민준이와_마산_그리고_건우 {
	static class Data implements Comparable<Data>{
		int idx;
		int weight;
		public Data(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return this.weight - o.weight;
		}
	}
	static int minEdge[];
	static boolean visited[];
	static ArrayList<Data> list[];
	static int V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int P = sc.nextInt(); //건우가 위치한 정점
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		minEdge = new int [V+1];
		for(int i = 0;i<V+1;i++) {
			list[i] = new ArrayList<Data>();
		}
		
		for(int i = 0; i<E;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list[from].add(new Data(to,weight));
			list[to].add(new Data(from,weight)); //양방향 그래프
		}
		int temp = dijkstra(1,P) + dijkstra(P,V);
		int temp1 = dijkstra(1,V);
		
		if(temp == temp1) { // 거기 거쳐감
			System.out.println("SAVE HIM");
		}else {//다름
			System.out.println("GOOD BYE");
		}
	}
	private static int dijkstra(int start,int end) {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		visited = new boolean[V+1];
		pq.add(new Data(start,0));
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[start] = 0;
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			if(visited[cur.idx]) {
				continue;
			}
			if(cur.idx == end) {
				return minEdge[end];
			}
			visited[cur.idx] = true;
			for(Data next : list[cur.idx])
			{
				if(minEdge[next.idx] >= minEdge[cur.idx] + next.weight)
				{
					minEdge[next.idx] = minEdge[cur.idx] + next.weight;
					pq.offer(new Data(next.idx,minEdge[next.idx]));
				}
			}
		}
		return minEdge[end];
	}
}
