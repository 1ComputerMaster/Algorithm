package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	static int arr[][],N,M;
	static ArrayList<int []> start = new ArrayList<>();
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		M = Integer.parseInt(tk.nextToken()); //가로
		N = Integer.parseInt(tk.nextToken()); //세로
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(tk.nextToken());
				if(arr[i][j] == 1) { //BFS 시작점
					start.add(new int[] {i,j}); // [0] == x , [1] == y
				}else if(arr[i][j] == -1) {
					visited[i][j] = true;
				}
			}
		}
		ArrayList<Integer> x = new ArrayList<>();
		ArrayList<Integer> y = new ArrayList<>();
		for (int i = 0; i < start.size(); i++) {
			int where[]=start.get(i);
			x.add(where[0]);
			y.add(where[1]);
		}
		int size = start.size();
		int ans = bfs(x,y,0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == false) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(ans);
	}
	private static int bfs(ArrayList <Integer> x,ArrayList <Integer> y,int cnt) {
		Queue<int []> q = new LinkedList<int[]>();
		for (int i = 0; i < y.size(); i++) {
			q.add(new int[] {x.get(i),y.get(i)});
			visited[x.get(i)][y.get(i)] = true;
		}
		while(!q.isEmpty()) {
			int [] temp = q.peek();
			if(arr[temp[0]][temp[1]] != 1)
			{
				cnt++;
			}
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] where = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = where[0] + dx[i];
					int ny = where[1] + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] == true || arr[nx][ny] == -1) {
						continue;
					}
					q.add(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		return cnt;
	}
}
