package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*Prim Algorithm을 이용한 문제이다. 처음 보는 노드에서 제일 가중치가 적은 노드를 골라서
 * 나아가면서 푼다.
 * 그리고 그때의 weight 값을 가져오면 그것이 모든 점을 연결할때의 최소거리가 되므로 그것을 출력한다.
 * 
 * Prim과 Dijkstra의 차이 -> 프림은 모든 점을 연결 할 때의 최소 거리를 구하는 것이고
 * 다익스트라는 -> 시작과 끝점이 존재 할 때의 최소 거리를 구하는 것이다.(start와 end가 주어져야 한다.)
 * 
 * */
public class BOJ_1922_네트워크_연결 {
	static class Data implements Comparable<Data>{
		int node;
		int weight;
		public Data(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int E = Integer.parseInt(in.readLine());
		ArrayList<Data> graph[] = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<Data>();
		}
		StringTokenizer tk;
		for (int i = 0; i < E; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			int c = Integer.parseInt(tk.nextToken());
			graph[a].add(new Data(b,c));
			graph[b].add(new Data(a,c));
		}
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		boolean visited[] = new boolean[N+1];
		pq.add(new Data(1,0));
		int ans = 0;
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			int node = cur.node;
			if(visited[node]) continue;
			visited[node] = true;
			ans += cur.weight;
			for(Data next : graph[node]) {
				if(!visited[next.node]) {
					pq.add(next);
				}
			}
		}
		System.out.println(ans);
	}

}
