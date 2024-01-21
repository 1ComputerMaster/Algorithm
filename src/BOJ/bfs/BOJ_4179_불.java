package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4179_불 {
	static int R;
	static int C;
	static char arr[][];
	static boolean visited[][];
	static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int fire_count[][];
	static int[][] my_count;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		fire_count = new int[R][C];
		my_count = new int[R][C];
		Data start = new Data(0,0);
		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int map[] : fire_count) {
			Arrays.fill(map, 1000_000_000);
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == 'F') {
					fire_bfs(i, j); //다 셈
					visited = new boolean[R][C];
				}
				else if(arr[i][j] == 'J') {
					my_bfs(i, j);
					visited = new boolean[R][C];
				}
			}
		}
		
		int ans = 1000_000_000;
		for (int i = 0; i < out.size(); i++) {
			if(fire_count[out.get(i).x][out.get(i).y] > my_count[out.get(i).x][out.get(i).y]) {
				ans = Math.min(ans, my_count[out.get(i).x][out.get(i).y]);
			}
		}
		
		if(ans == 1000_000_000) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(ans);
		}
		/*for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(fire_count[i][j]+" ");
			}System.out.println();
		}*/
	}
	
	private static void fire_bfs(int firstx,int firsty) {
		visited[firstx][firsty] = true;
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(firstx,firsty));
		fire_count[firstx][firsty] = 1;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || arr[nx][ny] == '#') {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Data(nx,ny));
				if(fire_count[nx][ny] > fire_count[cur.x][cur.y] + 1 || fire_count[nx][ny] == 0)
					fire_count[nx][ny] = fire_count[cur.x][cur.y] + 1;
			}
		}
	}
	static ArrayList<Data> out = new ArrayList();
	private static void my_bfs(int firstx,int firsty) {
		visited[firstx][firsty] = true;
		Queue<Data> q = new LinkedList<Data>();
		q.add(new Data(firstx,firsty));
		my_count[firstx][firsty] = 1;
		while(!q.isEmpty()) {
			Data cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || ny >= C || ny < 0 || nx >=R) //최초로 나가면
				{
					out.add(new Data(cur.x,cur.y));
				}
				if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || arr[nx][ny] == '#') {
					continue;
				}
				visited[nx][ny] = true;
				q.add(new Data(nx,ny));
				my_count[nx][ny] = my_count[cur.x][cur.y] + 1;
			}
		}
	}
}
