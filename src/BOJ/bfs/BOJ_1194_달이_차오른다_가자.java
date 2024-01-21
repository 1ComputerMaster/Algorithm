package BOJ.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이_차오른다_가자 {
	static char arr[][];
	static boolean visited[][][];
	static class Data{
		int x;
		int y;
		int cnt;
		int key;
		public Data(int x, int y,int cnt,int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int N,M;
	static int ans;
	static int cost[][];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new char[N][M];
		visited = new boolean[N][M][64];
		Data start = null;
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '0') {
					start = new Data(i,j,0,0);
				}
			}
		}
		System.out.println(bfs(start.x,start.y,0));
	}
	private static int bfs(int startx,int starty,int cnt) {
		Queue<Data> q = new LinkedList();
		q.add(new Data(startx,starty,cnt,0));
		visited[startx][starty][0] = true;
		while(!q.isEmpty()) {
			Data d = q.poll();
			int x = d.x;
			int y = d.y;
			if(arr[x][y] == '1') {
				return d.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int key = d.key;
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][key] || arr[nx][ny] == '#') {
					continue;
				}
				//열쇠를 만난 경우에는
				if('a' <= arr[nx][ny] && arr[nx][ny] <= 'f') {
					key |= (1<<arr[nx][ny]-'a'); // key의 상태는 변경된다. -> or 연산하면 누적되니깐 저장용
				}
				//문을 만난 경우에는
				if('A' <= arr[nx][ny] && arr[nx][ny] <= 'F') {
				    if((key & (1<<(arr[nx][ny]-'A'))) == 0) { //나에게 해당 키가 없다면 pass (& 확인용)
				    	continue;
				    }//그게 아니고 키가 맞다면 true
				}
				q.add(new Data(nx,ny,d.cnt + 1,key));
				visited[nx][ny][key] = true;
			}
		}
		return -1;
	}
}

