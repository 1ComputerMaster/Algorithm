package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ_1261_알고스팟 {
	static int arr[][],ans;
	static int sum,N,M;
	static boolean[][] visited;
	static class Data implements Comparable<Data>{
		int x;
		int y;
		int cnt;
		public Data(int x, int y,int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		M = Integer.parseInt(tk.nextToken());//가로
		N = Integer.parseInt(tk.nextToken());//세로
		visited = new boolean[N][M];
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {//세로
			String str = in.readLine();
			for (int j = 0; j < M; j++) {//가로
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		visited[0][0] = true;
		bfs(new Data(0,0,arr[0][0]));
		System.out.println(ans);
	}
	private static void bfs(Data start) {
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.add(new Data(start.x,start.y,arr[start.x][start.y]));
		while (!pq.isEmpty()) {
			Data cur = pq.poll();
			if(cur.x == N-1 && cur.y == M-1) {
				ans = cur.cnt;
				return; 
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] == true) continue;
				//벽이냐 마냐로 기준을 잡으면 안된다고 한다. -> 왜냐? 그전에 벽 더 부순게 있는데 그때로 간게 벽이 아니라고 해서 이전의 것이 최소가 되지 않으므로
				//벽을 몇 번 부쉈는지가 기준이 되어야 함
				visited[nx][ny] = true;
				if(arr[nx][ny] == 1)
				{
					pq.add(new Data(nx,ny,cur.cnt+1));
				}
				else {
					pq.add(new Data(nx,ny,cur.cnt));
				}
			}
		}
	}
}
