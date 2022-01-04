package dijkstrak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용_구하기2 {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int E = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		ArrayList<Data> graph[] = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(tk.nextToken());
			int to = Integer.parseInt(tk.nextToken());
			int where = Integer.parseInt(tk.nextToken());
			graph[from].add(new Data(to,where));
		}
		tk = new StringTokenizer(in.readLine()," ");
		int start = Integer.parseInt(tk.nextToken());
		int end = Integer.parseInt(tk.nextToken());
		
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		pq.add(new Data(start,0));
		int minEdge[] = new int[N+1];
		Arrays.fill(minEdge, 1000_000_000);
		boolean visited[] = new boolean[N+1];
		minEdge[start] = 0;
		int route[] = new int[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			int node = cur.node;
			if(minEdge[node] < cur.dist) {
				continue;
			}
			if(visited[node]) continue;
			visited[node] = true;
			for(Data next : graph[node]) {
				int cost = next.dist + minEdge[node];
				if(minEdge[next.node] > cost) {
					/* route 배열을 이용해서 내가 왔던 곳을 거꾸로 탐색 가능하게 한다. */
					minEdge[next.node] = cost;
					route[next.node] = node;
					pq.add(new Data(next.node,cost));
				}
			}
		}
		System.out.println(minEdge[end]);
		/* routes에 거꾸로 저장된 route 배열을 다시 받아오고 그것을 거꾸로 출력하면 된다. 
		 * sort를 하면 틀리는 이유가 순서대로 가는 것이 아니고 1 -> 4 -> 3 -> 5 가 최적의 거리 일 수 있기 때문이다. */
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
	}
}
