package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * �Ϲ����� MST �����̳� ���� �˰����� �°� ������ �����ϴ� ���� �ſ� �������.
 * 
 * */
public class BOJ_4386_���ڸ�_����� {
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
			visited[i] = true; //i��° �� �ٽ� ���Ƽ� ���� üũ�� �ʿ� �����Ƿ�
			Data from = star[i]; 
			for (int j = 0; j < N; j++) {
				if(visited[j]) continue;
				Data to = star[j]; //from , to �Ÿ��� weight�� �ַ��� 
				  double dist = Math.sqrt(Math.pow(from.x - to.x, 2) 
	                        + Math.pow(from.y - to.y, 2));
				graph[i].add(new Node(j,dist)); // �����
				graph[j].add(new Node(i,dist));
			}
		}
		Prim(N);
		System.out.printf("%.2f",ans);
	}
	static boolean visited[];
	static double ans = 0.0;
	private static double Prim(int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0)); //1. ó�� ���� 0,0 �ֳ��ϸ� ���� �� �ڽ����� ���� �Ÿ��� 0
		int cnt = 0; // 2. �̰� N�� ������ �׸� �Ϸ��� �� ���� üũ��
		while(!pq.isEmpty()) {
			Node now = pq.poll(); // �� �ް�
			if(visited[now.idx]) continue; // �̷��� pq�� �� �����ص� �׶� �̻��� ���� ������ �ʴ´�.
			//tip. �ƴϸ� minEdge[] �迭�Ἥ ����ϸ� �ȴ�.
			visited[now.idx] = true;
			ans += now.dist; // ���� �Ÿ��� ���ϴ� ���̴�
			if(++cnt == N) { //�� �� ���̴�
				return ans;
			}
			for (Node next : graph[now.idx]) {
				if(visited[next.idx]) continue; //���� ���� �� �� �ʿ� ���� -> 
				pq.add(next); //�ƹ��ų� �־ ���ĵǼ� ����
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
			if(minEdge[now.idx] < now.dist) continue;
			//if(visited[now.idx]) continue; // �̷��� pq�� �� �����ص� �׶� �̻��� ���� ������ �ʴ´�.
			//�ƴϸ� minEdge[] �迭�Ἥ ����ϸ� �ȴ�.
			//visited[now.idx] = true;
			ans += now.dist; //�� �Ÿ��� ���ϴ� ���̴�...
			if(++cnt == N) { //�� �� ���̴�
				return ans;
			}
			for (Node next : graph[now.idx]) {
				int minidx = next.idx;
				//if(visited[next.idx]) continue; //���� ���� �� �� �ʿ� ���� -> 
				if(minEdge[next.idx] > graph[next.idx]) {
					minEdge[next.idx] = graph[next.idx];
					minidx = next.idx;
				}
			}
			pq.add(new Node(next.idx, minEdge[next.idx]));
		}
		return ans;
	}
*/
}
