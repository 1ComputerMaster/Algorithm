package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int M,N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		M = Integer.parseInt(tk.nextToken());
		N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());
		int arr[][] = new int[M+1][N+1];
		for (int i = 0; i < K; i++) {
			visited = new boolean[M+1][N+1];
			tk = new StringTokenizer(in.readLine()," ");
			int y = Integer.parseInt(tk.nextToken());
			int x = Integer.parseInt(tk.nextToken());
			int y1 = Integer.parseInt(tk.nextToken());
			int x1 = Integer.parseInt(tk.nextToken());
			bfs(x,y,x1,y1,arr);
		}
		visited = new boolean[M][N];
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] == 0 && visited[i][j] == false) {
					list.add(check(i,j,arr));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int j = 0; j < list.size(); j++) {
			System.out.print(list.get(j)+" ");
		}
	}

	private static int check(int x, int y,int[][] arr) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N ) {
					if(arr[nx][ny] != 0) {
						continue;
					}
					if(visited[nx][ny] == false) {
						cnt++;
						q.add(new Data(nx,ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
		return cnt;
	}

	private static void bfs(int x, int y, int x1, int y1, int[][] arr) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		arr[x][y] = 1;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx >= 0 && nx < M && ny >= 0 && ny < N ) {
					if(visited[nx][ny] == false) {
						if(x < x1 && nx < x1 && nx >= x && y < y1 && ny < y1 && ny >= y) {
							q.add(new Data(nx,ny));
							arr[nx][ny] = 1;
							visited[nx][ny] = true;
						}
						if(x > x1 && nx < x && nx >= x1 && y < y1 && ny < y1 && ny >= y) {
							q.add(new Data(nx,ny));
							arr[nx][ny] = 1;
							visited[nx][ny] = true;
						}
						if(x > x1 && nx < x && nx >= x1 && y > y1 && ny < y && ny >= y1) {
							q.add(new Data(nx,ny));
							arr[nx][ny] = 1;
							visited[nx][ny] = true;
						}
						if(x < x1 && nx < x1 && nx >= x && y > y1 && ny < y && ny >= y1) {
							q.add(new Data(nx,ny));
							arr[nx][ny] = 1;
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
	}
}
