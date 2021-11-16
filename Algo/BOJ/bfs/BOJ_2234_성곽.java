package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234_성곽 {
	static int N,M;
	static int arr[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = { 0,-1,0,1 };//1,2,4,8 의 순서로 가르키고 있다.
	static int dy[] = { -1,0,1,0 };
	static int dist[][];
	private static boolean[][][] visited;
	private static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		M = Integer.parseInt(tk.nextToken());//7
		N = Integer.parseInt(tk.nextToken());//4
		arr = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		for (int map[] : dist) {
			Arrays.fill(map,-1);
		}
		
		int rooms = 0;
		int cnt = 0;
		int[] room = new int[N*M+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(dist[i][j] == -1) {
					room[rooms] = bfs(i,j,rooms++);
				}
			}
		}
		for (int i = 0; i < N*M+1; i++) {
			if(room[i] > cnt) {
				cnt = room[i];
			}
		}
		System.out.println(rooms); //방의 갯수
		System.out.println(cnt); //최대 길이
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int x = i;
				int y = j;
				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (nx < 0 || nx >= N || ny >= M || ny < 0) continue;
					if (dist[nx][ny] == dist[x][y])continue;
					if ((arr[x][y] & (1 << k)) > 0) {
						if (ans < room[dist[nx][ny]] + room[dist[x][y]]) {
							ans = room[dist[nx][ny]] + room[dist[x][y]];
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	private static int bfs(int x, int y,int room) {
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(x,y));
		dist[x][y] = room;
		int cnt = 0;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M ) {
					continue;
				}
				if(dist[nx][ny] != -1) {
					continue;
				}
				if ((arr[cur.x][cur.y] & (1 << i)) > 0) {
					continue; // arr[x][y]가 2^i 이라는 것은 여기에 벽이 존재한다는 뜻이 된다.
				}
				q.add(new Data(nx,ny));
				dist[nx][ny] = room;
			}
			cnt+=1;
		}
		return cnt;
	}
}	
