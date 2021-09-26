package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * dfs로 하면 메모리 초과 또는 틀렸습니다가 나오게 된다.
 * 아마도 최소가 되는 거리가 나오기 전에 다른 곳을 방문해서 그런 거 같다.
 */

public class BOJ_3055_탈출 {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static char crr[][];
	static int counter[][],dist[][];
	static boolean visited[][];
	static int R,C;
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Data end;
	static Data start;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		crr = new char[R][C];
		ArrayList<Data> water = new ArrayList<>();
		counter = new int[R][C];
		dist = new int[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				crr[i][j] = str.charAt(j);
				if(crr[i][j] == '*') {
					water.add(new Data(i,j));
				}
				else if(crr[i][j] == 'D') {
					end = new Data(i,j);
				}
				else if(crr[i][j] == 'S') {
					start = new Data(i,j);
				}
			}
		}
		for(int map[] : counter) {
			Arrays.fill(map, -1);
		} // counter를 -1로 초기화
		for (int i = 0; i < water.size(); i++) {
			counter[water.get(i).x][water.get(i).y] = 0;
			bfs(water.get(i).x,water.get(i).y);
		}
		dist[start.x][start.y]=1;
		go_bfs(start.x,start.y);
		if (check) {
			System.out.println(ans);
		}else {
			System.out.println("KAKTUS");
		}
	}
	static int ans = 0;
	static boolean check = false;
	private static void go_bfs(int x,int y) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int next[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = next[0] + dx[i];
				int ny = next[1] + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] ||(dist[next[0]][next[1]] >= counter[nx][ny] && counter[nx][ny] != -1) || crr[nx][ny] == 'X' || crr[nx][ny] == '*') {
					continue;
				}
				if(crr[nx][ny] == 'D') {
					ans = dist[next[0]][next[1]];
					check = true;
					return;
				}
				visited[nx][ny] = true;
				dist[nx][ny] = dist[next[0]][next[1]] + 1;
				q.add(new int[] {nx,ny});
			}
		}
	}
	private static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int next[] = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = next[0] + dx[i];
				int ny = next[1] + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || crr[nx][ny] == 'X' || crr[nx][ny] == 'D' || ((counter[nx][ny] < counter[next[0]][next[1]] + 1) && counter[nx][ny] != -1) || counter[nx][ny] != -1) {
					continue;
				}
				counter[nx][ny] = counter[next[0]][next[1]] + 1;
				q.add(new int[] {nx,ny});
			}
		}
	}
}
