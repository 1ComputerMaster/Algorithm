package BOJ.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹색_옷_입은_애가_젤다지 {
	static int ans;
	static int arr[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N;
	static int cost[][];
	static class Data implements Comparable<Data>{
		int x;
		int y;
		int weight;
		public Data(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		int cnt = 0;
		while(true) {
			cnt++;
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			cost = new int[N][N];
			if(N == 0) {
				return;
			}
			for (int i = 0; i < N; i++) {
				tk = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(tk.nextToken());
					cost[i][j] = 1000_000_000;
				}
			}
			PriorityQueue<Data> pq = new PriorityQueue<>();
			cost[0][0] = arr[0][0];
			pq.add(new Data(0,0,arr[0][0]));
			while(!pq.isEmpty()) {
				Data d = pq.poll();
				for (int i = 0; i < 4; i++) {
					int nx = d.x + dx[i];
					int ny = d.y + dy[i];
					if(nx < 0 || ny >= N || ny < 0 || nx >= N ) {
						continue;
					}
					if(cost[nx][ny] > arr[nx][ny] + cost[d.x][d.y]) {
						cost[nx][ny] = arr[nx][ny] + cost[d.x][d.y];
						pq.add(new Data(nx,ny,arr[nx][ny]));
					}
				}
			}
			System.out.println("Problem "+cnt+ ": "+ cost[N-1][N-1]);
		}
	}

}
