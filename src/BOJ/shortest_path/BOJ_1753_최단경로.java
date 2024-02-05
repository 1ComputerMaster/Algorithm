package BOJ.shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
	static class Data implements Comparable<Data>{
		int end;
		int weight;
		public Data(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static ArrayList<Data>[] list;
	static boolean visited[];
	static int ans[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int V = Integer.parseInt(tk.nextToken());
		int E = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(in.readLine());
		visited = new boolean[V+1];
		ans = new int[V+1];
		Arrays.fill(ans, -1);
		list = new ArrayList[V+1];
		for(int i = 0;i<V+1;i++) {
			list[i] = new ArrayList();
		}
		for(int i = 0; i<E;i++)
		{
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int weight = Integer.parseInt(tk.nextToken());
			list[from].add(new Data(to,weight)); //방향 그래프 이쪽으로만 간다.
		}
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		pq.offer(new Data(K,0)); //자기 자신은 0
		int cnt = 0;
		while(!pq.isEmpty())
		{
			Data cur = pq.poll();//최소의 weight가 나온다.
			if(visited[cur.end])
			{
				continue;
			}
			ans[cur.end]=cur.weight;
			visited[cur.end] = true;
			for(int i = 0;i<list[cur.end].size();i++) {
				Data next = list[cur.end].get(i);
				if(!visited[next.end]) {
					pq.offer(new Data(next.end,next.weight+cur.weight));
				}
			}
		}
		for(int i = 1;i<V+1;i++) {
			System.out.println((ans[i] == -1)? "INF":ans[i]);
		}
	}
}
