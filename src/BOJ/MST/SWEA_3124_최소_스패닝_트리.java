package BOJ.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_최소_스패닝_트리 {
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
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 1;t<=T;t++) {
			StringTokenizer tk = new StringTokenizer(in.readLine(), " ");
			int V = Integer.parseInt(tk.nextToken());
			int E = Integer.parseInt(tk.nextToken());
			ArrayList<Data> []list = new ArrayList[V+1];
			visited = new boolean[V+1];
			for(int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0;i <E;i++) {
				tk = new StringTokenizer(in.readLine(), " ");
				int from = Integer.parseInt(tk.nextToken());
				int to = Integer.parseInt(tk.nextToken());
				int weight = Integer.parseInt(tk.nextToken());
				list[from].add(new Data(to,weight));
				list[to].add(new Data(from,weight));
			}
			PriorityQueue<Data> pq = new PriorityQueue<>();
			pq.add(new Data(1,0));
			long ans = 0; // 1000000 가중치가 계속 들어오는 경우
			while(!pq.isEmpty()) {
				Data cur = pq.poll();
				if(visited[cur.end]) {
					continue;
				}
				ans += cur.weight;
				visited[cur.end] = true;
				for(Data next : list[cur.end]) {
					if(!visited[next.end]) {
						pq.add(new Data(next.end,next.weight));
					}
				}
			}
			System.out.println("#"+ t + " " + ans);
		}
	}
}
