package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_보급로 {
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
	static int arr[][], cost[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		PriorityQueue<Data> pq;
		StringTokenizer tk;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			cost = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = in.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = (str.charAt(j) -'0');
					cost[i][j] = 1000_000_000;
				}
			}
			pq = new PriorityQueue<>();
			pq.add(new Data(0,0,arr[0][0]));
			cost[0][0] = arr[0][0];
			while(!pq.isEmpty()) {
				int x = pq.peek().x;
				int y = pq.peek().y;
				int w = pq.peek().weight;
				pq.poll();
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || nx >= N || ny >= N || ny < 0) {
						continue;
					}
					if(cost[nx][ny] > cost[x][y] + arr[nx][ny]) {
						cost[nx][ny] = cost[x][y] + arr[nx][ny];
						pq.add(new Data(nx,ny,arr[nx][ny]));
					}
				}
			}
			System.out.println("#"+t+" "+cost[N-1][N-1]);
		}
	}
}
