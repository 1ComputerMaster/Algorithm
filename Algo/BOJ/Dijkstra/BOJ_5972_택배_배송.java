package dijkstrak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972_택배_배송 {
	static class Data implements Comparable<Data>{
		int to;
		int weight;
		public Data(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		ArrayList<Data>[] list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList();
		}
		
		for (int i = 0; i < M; i++) {
			
			tk = new StringTokenizer(in.readLine()," ");
			
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken());
			
			list[from].add(new Data(to,weight));
			list[to].add(new Data(from,weight));
		
		}
		int minEdge[] = new int[N+1];
		
		Arrays.fill(minEdge, 100_000_000);
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		pq.add(new Data(1,0)); //내꺼 제일 먼저 가니깐
		
		minEdge[1] = 0;
		boolean visited[] = new boolean[N+1];
		while(!pq.isEmpty())
		{
			Data cur = pq.poll();
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			if(minEdge[cur.to] < cur.weight) {
				continue;
			}
			
			for(Data next : list[cur.to])
			{
				/*현재 까지의 최단 거리 + 현재 연결된 노드의 최소 비용*/
				int cost = minEdge[cur.to] + next.weight;
				if(cost < minEdge[next.to])
				{
					minEdge[next.to] = cost;
					pq.add(new Data(next.to,cost));
				}
			}
		}
		System.out.print(minEdge[N]);
	}
}