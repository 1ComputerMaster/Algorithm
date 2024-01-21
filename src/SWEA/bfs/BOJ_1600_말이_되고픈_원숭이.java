package SWEA.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이_되고픈_원숭이 {
	static class Data{
		int x;
		int y;
		int c;
		public Data(int x, int y,int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	static int d[][][] = new int[201][201][31]; //가는 길이
	static int a[][] = new int[201][201]; //격자 크기
	static int dx[] = { 0,0,-1,1 ,-2, -2, -1, -1, 2, 2, 1, 1 };
	static int dy[] = { -1,1,0,0 ,1, -1, -2, 2, 1, -1, -2, 2 };
	static int cost[] = { 0,0,0,0,1,1,1,1,1,1,1,1 };
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		int H = Integer.parseInt(tk.nextToken());
		int W = Integer.parseInt(tk.nextToken());
		for(int i = 0; i<W;i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < H; j++) {
				a[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(0,0,0));
		for(int map[][] : d) {
			for(int m[] : map) {
				Arrays.fill(m, -1);
			}
		}
		d[0][0][0] = 0;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for(int i = 0; i<12;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				int nc = cur.c + cost[i];
				if(nc <= K) {
					if(nx >= 0 && nx < W && ny >= 0 && ny < H && a[nx][ny] == 0 && d[nx][ny][nc] == -1) {
						q.add(new Data(nx,ny,nc));
						d[nx][ny][nc] = d[cur.x][cur.y][cur.c] + 1;
					}
				}
			}
		}
		int ans = -1;
		for (int i = 0; i <= K; i++) {
			if (d[W - 1][H - 1][i] == -1) continue;
			if (ans == -1 || ans > d[W - 1][H - 1][i]) {
				ans = d[W - 1][H - 1][i];
			}
		}
		System.out.println(ans);		
	}
}
