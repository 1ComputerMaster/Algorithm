package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * Prim 문제 인걸 알고 풀어서 쉬웠지만 모르고 풀었다면 어려웠을 법한 문제
 * 
 * */
public class BOJ_4386_별자리_만들기 {
	static class Data{
		double x;
		double y;
		public Data(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Node implements Comparable<Node>{
		int idx;
		double dist;
		public Node(int idx, double dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}
		
	}
	static ArrayList<Node> graph [];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer tk;
		Data star[] = new Data[N];
		visited = new boolean[N];
		boolean visited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			star[i] = new Data(Double.parseDouble(tk.nextToken()),Double.parseDouble(tk.nextToken()));
		}
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < N; i++) {
			visited[i] = true; //다시 내가 내꺼 거리 기록 할 필요 없음
			Data from = star[i]; 
			for (int j = 0; j < N; j++) {
				if(visited[j]) continue;
				Data to = star[j]; //from , to의 거리 차이를 weight로
				  double dist = Math.sqrt(Math.pow(from.x - to.x, 2) 
	                        + Math.pow(from.y - to.y, 2));
				graph[i].add(new Node(j,dist)); // prim에 쓰기 위함
				graph[j].add(new Node(i,dist));
			}
		}
		Prim(N);
		System.out.printf("%.2f",ans); //소수점 2자리만 출력하기 위함
	}
	static boolean visited[];
	static double ans = 0.0;
	private static double Prim(int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0)); //1. 원래 내가 내위치 가는건 weight 0
		int cnt = 0; // 2. 다 끝났는지 세기 위함
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // 가져옴
			if(visited[now.idx]) continue; // pq에서 막 넣어도 내가 갔던거 다시 안 받으니깐 내가 보는 노드에서 최소 거리만 가져온다.
			//tip. minEdge[]를 사용해서 visited 배열을 사용하지 않아도 된다.
			visited[now.idx] = true;
			ans += now.dist; // ans 이건 그냥 그때 그때의 거리값 최소로 체크
			if(++cnt == N) { //마지막이니 출력 후 끝
				return ans;
			}
			for (Node next : graph[now.idx]) {
				if(visited[next.idx]) continue; // 봤던거 또 안 보기용
				pq.add(next); //pq에 넣는다.
			}
		}
		return ans;
	}
/*	private static double Prim_minEdge(int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0));
		double minEdge[] = new double[N];
		Arrays.fill(minEdge, Double.MAX_VALUE);
		minEdge[0] = 0.0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(minEdge[now.idx] < now.dist) continue; // 이렇게 봤을때 트루 일리 없지만 넣음
			ans += now.dist; //�� �Ÿ��� ���ϴ� ���̴�...
			if(++cnt == N) { // 마찬 가지로 끝난지 체크
				return ans;
			}
			for (Node next : graph[now.idx]) {
				int minidx = next.idx; 
				if(minEdge[next.idx] > graph[next.idx]) {
					minEdge[next.idx] = graph[next.idx]; // 내가 보는 곳에서 제일 최소 거리가 된 것이 정해짐
					minidx = next.idx; //이때가 최소가 되는 위치
				}
			}
			pq.add(new Node(next.idx, minEdge[next.idx]));
		}
		return ans;
	}
*/
}
