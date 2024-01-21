package BOJ.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2636_치즈 {
	static int N;
	static int M;
	static int arr[][];
	static boolean[][][] check;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		check = new boolean[N][M][100];
		visited = new boolean[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i<N;i++) {
			for(int j = 0; j<M;j++) {
				if(arr[i][j] != 1)
				{
					bfs(i,j);
				}
			}
		}
		check = new boolean[N][M][100];
		for(int time = 0; time<100;time++)
		{	
			for(int i = 0;i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(arr[i][j] == 1 && check[i][j][time] != true) {
						find_bfs(i,j);
					}
				}
			}
			for(int i = 0;i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(arr[i][j] == 0)
					{
						bfs(i,j);
					}
				}
			}
			int count = 0;
			for(int i = 0;i<N;i++) {
				for(int j = 0; j<M;j++) {
					if(check[i][j][time] == true) {
						count++;
					}
				}
			}
			if(ans > count && count != 0) {
				ans = count;
			}
			if(count == 0)
			{
				System.out.println(time+" "+ ans);
				return;
			}
			cnt++;
		}
	}
	static int cnt = 0;
	private static void bfs(int startx,int starty) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(startx,starty));
		visited = new boolean[N][M];
		visited[startx][starty] = true;
		
		while(!q.isEmpty())
		{
			Data cur = q.poll();
			for(int d = 0;d<4;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] == true || arr[nx][ny] == 1) {
					continue;
				}
				if(nx == 0 && ny == 0) {
					arr[startx][starty] = 2;//구멍 아닌 곳
				}
				visited[nx][ny] = true;
				q.add(new Data(nx,ny));
				
			}
			
		}
	}
	
	private static void find_bfs(int startx,int starty) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(startx,starty));
		while(!q.isEmpty())
		{
			Data cur = q.poll();
			for(int d = 0;d<4;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || check[nx][ny][cnt] == true || arr[nx][ny] == 1 || arr[nx][ny] == 0) {
					continue;
				}else {
					arr[cur.x][cur.y] = 2;
					check[cur.x][cur.y][cnt] = true;
					return;
				}
			}
		}
	}
}
