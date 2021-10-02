package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol_1113_119구급대 {
	private static int[] dx = {-1,1,0,0}; //아래,위,왼,오
	private static int[] dy = {0,0,-1,1};
	private static boolean[][] visited;
	private static int N,M,R,C;
	private static int[][] arr;
	private static int ans = Integer.MAX_VALUE;
	private static int dist[][];
	//dfs로 갔다가 코너를 돌 때마다 카운터를 올려서 그때 도착한 수를 리턴하자
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new int[R][C];
		visited = new boolean[R][C];
		dist = new int[R][C];
		for (int i = 0; i < R; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
			}
		}
		visited[0][0] = true;
		for(int map[] : dist)
			Arrays.fill(map, 1000_000_00);
		dist[0][0] = 0;
		dfs(0,0,0);
		dfs(0,0,1);
		dfs(0,0,2);
		dfs(0,0,3);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(dist[i][j] == 1000_00_000 ? "0 " : dist[i][j] +" ");
			}System.out.println();
		}
		
		System.out.println(dist[N][M]);
	}
	private static void dfs(int x,int y,int dir){
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == 0) {
				continue;
			}
			if((dir == 0 || dir==1) &&(i == 2 || i == 3)) {
				if(dist[nx][ny] > dist[x][y] + 1) {
					dist[nx][ny] = dist[x][y] + 1;
					dfs(nx,ny,i);
				}
			}else if((dir == 0 || dir==1) &&(i == 0 || i == 1)){
				if(dist[nx][ny] > dist[x][y]) {
					dist[nx][ny] = dist[x][y];
					dfs(nx,ny,i);
				}
			}
			
			if((dir == 2 || dir==3) &&(i == 0 || i == 1)) {
				if(dist[nx][ny] > dist[x][y] + 1) {
					dist[nx][ny] = dist[x][y] + 1;
					dfs(nx,ny,i);
				}
			}else if((dir == 2 || dir==3) &&(i == 2 || i == 3)){
				if(dist[nx][ny] > dist[x][y]) {
					dist[nx][ny] = dist[x][y];
					dfs(nx,ny,i);
				}
			}
		}
	}
}
