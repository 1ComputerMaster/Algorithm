package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	private static boolean[][] visited;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char arr[][];
	private static int ans = 0;
	static int dist[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());//가로
		M = Integer.parseInt(tk.nextToken());//세로
		String str;
		arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine(); //W : 바다 / L : 육지
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 'L' && visited[i][j] == false ) {
					visited[i][j] = true;
					ans = Math.max(ans, bfs(i,j));
				}
			}
		}
		System.out.println(ans);
	}

	private static int bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		boolean visited[][] = new boolean[N][M];
		visited[x][y] = true;
		dist = new int[N][M];
		int cnt = 0;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] == true || arr[nx][ny] == 'W') {
					continue;
				}
				if(dist[nx][ny] < dist[cur.x][cur.y] + 1) {
					dist[nx][ny] = dist[cur.x][cur.y] + 1;
					visited[nx][ny] = true;
					q.add(new Data(nx,ny));
					cnt = dist[nx][ny];
				}
			}
		}
		return cnt;
	}
}
