package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static int N;
	static int arr[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int ans = 0;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr = new int[N][N];
		StringTokenizer tk;
		int max = 0;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}
		for(int i = 0;i<max;i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(arr[j][j2] <= i) {
						arr[j][j2] = -1;
					}
				}
			}
			int cnt = 0;//영역 체크
			boolean visited[][] = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(arr[j][k] != -1 && visited[j][k] == false) { //새로운 영역
						cnt++;
						Queue<Data> q = new LinkedList<>();
						q.add(new Data(j,k));
						visited[j][k] = true;
						while(!q.isEmpty()) {
							Data cur = q.poll();
							for (int l = 0; l < 4; l++) {
								int nx = cur.x + dx[l];
								int ny = cur.y + dy[l];
								if(nx < 0 || ny < 0 || ny >= N || nx >= N || visited[nx][ny] == true || arr[nx][ny] == -1) {
									continue;
								}
								visited[nx][ny] = true;
								q.add(new Data(nx,ny));
							}
						}
					} 
				}
			}
		
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

}
