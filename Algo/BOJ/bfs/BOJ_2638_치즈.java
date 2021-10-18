package bfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2638_치즈 {
	static int N;
	static int M;
	static int arr[][];
	static boolean[][] visited;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	private static int ans = Integer.MAX_VALUE;
	private static ArrayList<Data> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i = 0;i < N;i++) {
			for(int j = 0; j < M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//구멍 찾기
		boolean check = false;
		for (int cnt = 1; cnt <= 100; cnt++) {
			check = false;
			visited = new boolean[N+1][M+1];
			hole_bfs(N,M);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] == false && arr[i][j] != 1) {
						arr[i][j] = -1;
					}
				}
			}
			list = new ArrayList<Data>(); //새로 할당
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						int temp = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if(arr[nx][ny] == 0) {
								temp++;
							}
						}
						if(temp >= 2) {
							list.add(new Data(i,j));
						}
					}
				}
			}
			for(Data where : list) {
				arr[where.x][where.y] = 0;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						check = true;
					}
				}
			}
			visited = new boolean[N+1][M+1];
			hole_bfs(N,M);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j] == false && arr[i][j] != 1) {
						arr[i][j] = -1;
					}else if(visited[i][j] == true && arr[i][j] == -1) {
						arr[i][j] = 0;
					}
				}
			}
			if(check == false) {
				System.out.println(cnt);
				return;
			}
		}
	}
	private static void hole_bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx > N || ny > M || ny < 0 || visited[nx][ny] || arr[nx][ny] == 1) continue;
				visited[nx][ny] = true;
				q.add(new Data(nx,ny));
			}
		}
		
	}
/*	private static void bfs(int x, int y) {
		Queue<Data> q = new LinkedList<>();
		q.add(new Data(x,y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int size = q.size(); //1
				Data cur = q.poll();
				int cnt = 0;
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if(nx < 0 || nx >= N || ny >= M || ny < 0 || visited[nx][ny]) continue;
					if(arr[nx][ny] == 0) {
						cnt++;
					}
					visited[nx][ny] = true;
					q.add(new Data(nx,ny));
				}
				if(cnt >= 2) {
					list.add(new Data(cur.x,cur.y));
					return;
				}
		}
		
	}*/

	
}
